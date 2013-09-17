package com.etherealnation.gen10.util;

import android.util.Log;

/**
 * Created by lcreasy on 9/17/13.
 * Logger
 */
public class Logger {

    public static final int VERBOSE = Log.VERBOSE;
    public static final int DEBUG = Log.DEBUG;
    public static final int INFO = Log.INFO;
    public static final int WARN = Log.WARN;
    public static final int ERROR = Log.ERROR;
    public static final int ASSERT = Log.ASSERT;
    private static int currentLevel = ASSERT;
    private static String appLogTag = "";
    private static int level;

    public static void error(String tag, String error) {
        Log.e(appLogTag, formatMessage(tag, error));
    }

    private static String formatMessage(String tag, String message) {
        StringBuilder builder = new StringBuilder();
        if (tag.length() > 20) {
            tag = tag.substring(0, 20);
        }

        tag = "[".concat(tag).concat("]");

        String prefix = String.format("%-22s ", tag);

        builder.append(prefix).append(message);
        return builder.toString();
    }

    public static void info(String tag, String info) {
        Log.i(appLogTag, formatMessage(tag, info));
    }

    public static void debug(String tag, String message) {
        Log.d(appLogTag, formatMessage(tag, message));
    }

    public static void setAppLogTag(String appLogTag) {
        Logger.appLogTag = appLogTag;
    }

    public static void setLevel(int level) {
        Logger.level = level;
    }

}