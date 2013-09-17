package com.etherealnation.gen10;

import android.app.Application;
import com.etherealnation.gen10.util.Logger;

/**
 * Created by lcreasy on 9/17/13.
 * Gen10App
 */
public class Gen10App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.setAppLogTag(getString(R.string.app_name));
        Logger.setLevel(Logger.DEBUG);
    }

}
