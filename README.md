# Anuto - Another Ugly Tower Defense

**This is a fork of [mjaun/android-anuto](https://github.com/mjaun/android-anuto) to add rewards multipliers as a form of a cheat code. Because sometimes, you just want to watch the world burn.** Upstream remains the canonical project; changes here are intentional mods on top of that base.

<img src="./images/feature.png" width="400" />

Anuto is yet another tower defense game for Android.
However it features astonishing hand-drawn graphics and a smooth gameplay.

## Fork changes

Compared to upstream, this fork adds:

- **Reward multiplier** (Settings → Reward multiplier: 1× / 2× / 5× / 100×)
  - Multiplies **wallet credits only** from kills, wave clears, and early-wave bonuses
  - **Score and difficulty are unchanged** (still based on unmultiplied earned credits)
  - HUD early-bonus preview shows the multiplied amount
- **Damage multiplier** (Settings → Damage multiplier: 1× / 2× / 5× / 100×)
  - Multiplies all tower damage applied to enemies
- **Obtainium-friendly releases** — GitHub Actions builds and attaches a signed APK on `v*` tags (`anuto-<version>.apk`)
- **Dedicated release signing** — APKs from **0.13.2+** use a private release keystore (not the Android debug key)

Current app version: **0.13.3** (based on upstream 0.13).

## Download (this fork)

Install from [GitHub Releases](https://github.com/kurtlieber/android-anuto/releases) (e.g. via [Obtainium](https://github.com/ImranR98/Obtainium)).

**Signing change:** if you installed **0.13.1** (debug-signed), uninstall it first, then install 0.13.2+. Android does not allow updates that change the signing certificate.

For the original unforked app:

<a href="https://f-droid.org/packages/ch.logixisland.anuto" target="_blank">
<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it on F-Droid" height="100"/></a>
<a href="https://play.google.com/store/apps/details?id=ch.logixisland.anuto" target="_blank">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Google Play" height="100"/></a>

## Beta Testing

Become a [beta tester](https://play.google.com/apps/testing/ch.logixisland.anuto)! (upstream Play Store track)

## How to play

- Buy new towers by dragging a tower from the inventory at the top onto the field.
  Make sure you have enough credits.
- Open the properties window for a tower by double tapping it.
  To close the window tap somewhere on the field.
- Strategy: Determines which enemy to target if there are multiple in range.
- Lock Target: If true the tower will not switch target until it is dead or out of range.
- Enhance: Increases the level of the tower making it better.
- Upgrade: Replaces the tower with a higher tier tower.
  Note that any enhancements of the tower are lost.
- Sell: Removes the tower. Refund decreases over time.
- Call in the next wave using the button in the upper right corner.
  If you call in the next wave while there are still enemies in the game you receive bonus credits.
- Make sure the enemies don't make it through the course!
