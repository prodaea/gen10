package com.etherealnation.gen10;

import android.test.ActivityInstrumentationTestCase2;
import com.etherealnation.gen10.util.ScreenHelper;

/**
 * Created by lcreasy on 9/17/13.
 * MainActivityTest
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        mActivity = getActivity();
    }

    public void testOnCreate() throws Exception {
        assertNotNull(mActivity);
        assertNotNull(mActivity.getApplication());
    }

    public void testCorrectSize() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.list));
        if (ScreenHelper.isTablet(mActivity)) {
            assertNotNull(mActivity.findViewById(R.id.content));
        }
    }
}
