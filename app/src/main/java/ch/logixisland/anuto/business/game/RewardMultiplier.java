package ch.logixisland.anuto.business.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ch.logixisland.anuto.Preferences;

/**
 * Global preference for how much spendable credit rewards are multiplied.
 * Score / difficulty use unmultiplied earned credits elsewhere.
 */
public class RewardMultiplier implements SharedPreferences.OnSharedPreferenceChangeListener {

    public interface Listener {
        void multiplierChanged(int multiplier);
    }

    private final SharedPreferences mPreferences;
    private final List<Listener> mListeners = new CopyOnWriteArrayList<>();

    private int mMultiplier = 1;

    public RewardMultiplier(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mPreferences.registerOnSharedPreferenceChangeListener(this);
        updateMultiplier();
    }

    public int getMultiplier() {
        return mMultiplier;
    }

    /** Multiplies a base reward for wallet / HUD preview. */
    public long apply(int baseCredits) {
        return (long) baseCredits * mMultiplier;
    }

    public void addListener(Listener listener) {
        mListeners.add(listener);
    }

    public void removeListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (Preferences.REWARD_MULTIPLIER.equals(key)) {
            updateMultiplier();
        }
    }

    private void updateMultiplier() {
        String value = mPreferences.getString(Preferences.REWARD_MULTIPLIER, "1");
        int parsed;
        try {
            parsed = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            parsed = 1;
        }
        if (parsed < 1) {
            parsed = 1;
        }
        if (parsed != mMultiplier) {
            mMultiplier = parsed;
            for (Listener listener : mListeners) {
                listener.multiplierChanged(mMultiplier);
            }
        }
    }
}
