# Animation strips — review pack

**Branch:** `feature/metroid-style-graphics`  
**Status:** Full Original-theme strip set for approval (still **not** wired into `res/drawable`)  
**Cell size:** 128×128 px per frame, horizontal strips, transparent background

## Frame counts (match Java `createTemplate`)

| Asset | Frames | Animation source |
|-------|--------|------------------|
| soldier | 12 | pulse/idle from approved base (engine uses fwd-back) |
| blob | 9 | video morph harvest |
| flyer | 6 | video hover harvest |
| sprinter | 6 | generated run-cycle sheet |
| healer | 4 | pulse from base |
| canon | 4 | slight recoil variants |
| canon_dual | 4 | recoil |
| canon_mg | 5 | recoil |
| mortar | 8 | recoil (stand-in for barrel cycle) |
| glue_gun | 6 | recoil |
| glue_tower_gun | 4 | glow pulse |
| laser_tower1–3 | 4 each | glow pulse |
| rocket_launcher | 4 | glow |
| mine_layer | 6 | pulse |
| teleport_tower | 4 | glow |
| tower_base1–5 | 4 each | slight rotation variants |
| plateau1 | 4 | slight rotation |
| canon_shot / canon_mg_shot | 4 | static / glow |
| glue_shot | 6 | soft morph |
| glue_effect | 4 | soft morph |
| grenade | 4 | spin |
| mine | 4 | glow |
| rocket / rocket_fire | 4 | static / pulse |

## Review files

- Strips: `art/review/strips/*.png`
- White previews: `art/review/strips/previews/*_on_white.jpg`
- Contact: `art/review/strips/previews/_ALL_STRIPS_CONTACT.jpg`

## Known caveats (honest)

1. **Enemy motion quality varies** — blob/flyer from video are strongest; soldier is a scale-pulse (readable, not a full walk).
2. **Tower “recoil” frames** are procedural squash/glow, not unique art poses — fine for review, can upgrade later.
3. **Mortar** does not yet have a true 8-frame barrel elevation cycle like the original abstract art.
4. **No app integration yet** — approve strips before copy to `res/drawable`.

## After approval

1. Copy strips → `app/src/main/res/drawable/` (Original theme names only)
2. Optional final keying/size match to old sheet dimensions
3. Build + in-game screenshots for final QA
