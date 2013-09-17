package com.etherealnation.gen10.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.util.ExtrasConstants;
import com.etherealnation.gen10.util.Logger;

/**
 * Created by lcreasy on 9/17/13.
 * BlankActivity
 */
public class BlankActivity extends Activity {

    private static final String TAG = BlankActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        String hashData = getIntent().getBundleExtra(ExtrasConstants.BLANK_HASH).toString();
        Logger.debug(TAG, hashData);
        ((TextView) findViewById(R.id.hashDataOutput)).setText(hashData);
    }

}
