package com.etherealnation.gen10.util;

import android.content.Context;
import com.etherealnation.gen10.R;

/**
 * Created by lcreasy on 9/17/13.
 * ScreenHelper
 */
public class ScreenHelper {

    private static final String PHONE = "phone";
    private static final String TABLET_7 = "7-inch-tablet";
    private static final String TABLET_10 = "10-inch-tablet";

    /**
     * see: http://stackoverflow.com/questions/5832368/tablet-or-phone-android
     * allows tests and app to determine tabletiness
     *
     * @param context will use app context
     * @return boolean
     */
    public static boolean isTablet(Context context) {
        Context appContext = context.getApplicationContext();

        String screenType = appContext.getResources().getString(R.string.screen_type);
        return !screenType.equals(PHONE);
    }
}
