package ch.logixisland.anuto.util;

import android.content.res.Resources;

import java.text.DecimalFormat;

import ch.logixisland.anuto.R;

public final class StringUtils {
    private StringUtils() {

    }

    private static final DecimalFormat fmt0 = new DecimalFormat("0");
    private static final DecimalFormat fmt1 = new DecimalFormat("0.0");

    public static String formatSuffix(int value) {
        return formatSuffix((double) value, true);
    }

    public static String formatSuffix(long value) {
        return formatSuffix((double) value, true);
    }

    public static String formatSuffix(float value) {
        return formatSuffix(value, false);
    }

    public static String formatSuffix(float value, boolean integer) {
        return formatSuffix((double) value, integer);
    }

    public static String formatSuffix(double value, boolean integer) {
        String suffix = "";
        boolean big = false;

        if (value >= 1e13d) {
            suffix = "T";
            value /= 1e12d;
            big = true;
        } else if (value >= 1e10d) {
            suffix = "G";
            value /= 1e9d;
            big = true;
        } else if (value >= 1e7d) {
            suffix = "M";
            value /= 1e6d;
            big = true;
        } else if (value >= 1e4d) {
            suffix = "k";
            value /= 1e3d;
            big = true;
        }

        DecimalFormat fmt = (value < 1e2d && (!integer || big)) ? fmt1 : fmt0;
        return fmt.format(value) + suffix;
    }

    public static String formatBoolean(boolean value, Resources resources) {
        return resources.getString(value ? R.string.on : R.string.off);
    }

    public static String formatSwitchButton(String name, String value) {
        return String.format("%1$s (%2$s)", name, value);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
