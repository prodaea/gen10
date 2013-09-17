package com.etherealnation.gen10;

import android.support.v4.app.FragmentManager;
import android.test.ActivityInstrumentationTestCase2;
import com.etherealnation.gen10.activity.MainActivity;
import com.etherealnation.gen10.fragment.MenuFragment;
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
        assertNotNull(mActivity.findViewById(R.id.menuContainer));
        if (ScreenHelper.isTablet(mActivity)) {
            assertNotNull(mActivity.findViewById(R.id.contentContainer));
        }
    }

    public void testMenu() throws Exception {
        getInstrumentation().waitForIdle(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm = mActivity.getSupportFragmentManager();
                MenuFragment menuFragment = (MenuFragment) fm.findFragmentByTag(MenuFragment.TAG);

                assertEquals(menuFragment.getListAdapter().getCount(), MenuFragment.MENU_IDS.length);
            }
        });
    }

}
