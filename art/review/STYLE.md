# Anuto reskin — Super Metroid–inspired 16-bit (Original / light theme)

**Branch:** `feature/metroid-style-graphics`  
**Scope:** Original (light) theme only — bare `drawable/*.png` (not `_dk` / `_co`)  
**Gate:** All candidate art under `art/review/` until you approve. No wiring into `res/drawable` or Java until then.

## Style lock

- **Look:** SNES-era 16-bit shooter, *inspired by* Super Metroid (Chozo tech, space-pirate armor, organic biohazards) — original designs, not copies of Samus / Metroids / franchise IP.
- **Medium:** Crisp pixel art, limited palette per asset (~12–24 colors), hard 1px dark outlines.
- **Readability (light map `#ffffff`):** strong silhouettes, mid/dark fills (avoid pure white bodies), high contrast vs white playfield, legible when scaled to ~1 tile on phone.
- **Background:** fully transparent (no black matte).
- **Strip format:** single horizontal row, **exact frame counts** from current Java `createTemplate(..., N)`, equal cell widths, subject centered in each cell, no divider lines.
- **Motion roles:** keep the *function* of each strip (pulse / morph / recoil / barrel cycle), not necessarily abstract squares.

## Frame counts (must keep)

| Asset | Frames | Role |
|-------|--------|------|
| soldier | 12 | enemy idle/pulse (fwd-back) |
| blob | 9 | organic morph |
| flyer | 6 | morph |
| sprinter | 6 | morph |
| healer | 4 | idle |
| canon | 4 | turret |
| canon_dual | 4 | dual body |
| canon_mg | 5 | MG barrel |
| canon_shot / canon_mg_shot | 4 | projectile |
| mortar | 8 | barrel cycle |
| glue_gun | 6 | gun |
| glue_tower_gun | 4 | tower head |
| glue_shot | 6 | projectile / glue tower body |
| glue_effect | 4 | ground FX |
| mine / mine_layer | 4 / 6 | mine + layer |
| grenade | 4 | mortar shot |
| rocket / rocket_fire / rocket_launcher | 4 each | rocket system |
| laser_tower1–3 | 4 each | laser heads |
| teleport_tower | 4 | teleporter |
| tower_base1–5 | 4 each | bases |
| plateau1 | 4 | build pads |
| rocket (shared) | 4 | |

## Review workflow

1. Style board + pilot bases → **you approve style**
2. Full base set (static frame 0 for every strip) → **you approve designs**
3. Animated strips (exact N frames) → **you approve motion**
4. Only then: copy into `res/drawable`, version bump, build, in-game screenshots

## Pilot batch (this round)

- `00_style_board` — palette + example motifs
- `soldier_base` — ground infantry (space-pirate inspired)
- `blob_base` — biohazard jelly enemy
- `canon_base` — ballistic turret head (points up; engine rotates)
- `tower_base1_base` — circular pad under gun towers
- `plateau1_base` — placeable build tile

## Style lock — APPROVED

User approved enthusiastically (red space-pirate soldier, spiky teal blob with red nucleus, cream/steel tech metal, teal accents). Proceed to full static base set, then strips.

## Integration — APPROVED

Strips approved and installed into `app/src/main/res/drawable/` (bare Original-theme names + `canon_mg_shot_dk`). Dark-theme `*_dk` / colour `*_co` tower/enemy variants left untouched except assets that share the bare / `_dk` shot path. Old hand-drawn originals backed up under `art/review/original_backup/`.
