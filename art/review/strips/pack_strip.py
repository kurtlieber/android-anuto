#!/usr/bin/env python3
"""Pack ordered frame PNGs into a horizontal strip with equal cells + transparent pad."""
import argparse
from pathlib import Path
from PIL import Image

def key_magenta(im: Image.Image) -> Image.Image:
    im = im.convert("RGBA")
    px = im.load()
    w, h = im.size
    for y in range(h):
        for x in range(w):
            r, g, b, a = px[x, y]
            if a and r > 175 and g < 125 and b > 175:
                px[x, y] = (0, 0, 0, 0)
    return im

def content_bbox(im: Image.Image, alpha_thr=8):
    a = im.split()[-1]
    return a.point(lambda p: 255 if p > alpha_thr else 0).getbbox()

def fit_cell(im: Image.Image, cell: int, pad_frac=0.08) -> Image.Image:
    im = key_magenta(im)
    bb = content_bbox(im)
    if bb:
        im = im.crop(bb)
    # scale to fit inside cell with padding
    max_dim = int(cell * (1 - 2 * pad_frac))
    im.thumbnail((max_dim, max_dim), Image.Resampling.NEAREST)
    # optional: quantize-ish by NEAREST already for pixel look
    cell_im = Image.new("RGBA", (cell, cell), (0, 0, 0, 0))
    x = (cell - im.width) // 2
    y = (cell - im.height) // 2
    cell_im.paste(im, (x, y), im)
    return cell_im

def pack(frames, out_path: Path, cell: int = 128):
    cells = [fit_cell(Image.open(f), cell) for f in frames]
    strip = Image.new("RGBA", (cell * len(cells), cell), (0, 0, 0, 0))
    for i, c in enumerate(cells):
        strip.paste(c, (i * cell, 0), c)
    out_path.parent.mkdir(parents=True, exist_ok=True)
    strip.save(out_path)
    # white preview
    prev = Image.new("RGBA", strip.size, (255, 255, 255, 255))
    prev.alpha_composite(strip)
    prev_path = out_path.parent.parent / "previews" / (out_path.stem + "_on_white.jpg")
    prev_path.parent.mkdir(parents=True, exist_ok=True)
    prev.convert("RGB").save(prev_path, quality=90)
    print(f"wrote {out_path} {strip.size} preview {prev_path}")

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("out")
    ap.add_argument("frames", nargs="+")
    ap.add_argument("--cell", type=int, default=128)
    args = ap.parse_args()
    pack(args.frames, Path(args.out), args.cell)

if __name__ == "__main__":
    main()
