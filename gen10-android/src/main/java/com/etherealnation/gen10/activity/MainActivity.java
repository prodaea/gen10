package com.etherealnation.gen10.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.fragment.LoginFragment;
import com.etherealnation.gen10.fragment.MenuFragment;
import com.etherealnation.gen10.fragment.TextFieldsFragment;
import com.etherealnation.gen10.util.Logger;
import com.etherealnation.gen10.util.ScreenHelper;

/**
 * Created by lcreasy on 9/17/13.
 * MainActivity
 */
public class MainActivity extends FragmentActivity implements MenuFragment.OnMenuItemClickedListener {

    private static final String ACTIVITY_PATH = "com.etherealnation.gen10.activity.";
    private static final String FRAGMENT_PATH = "com.etherealnation.gen10.fragment.";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String CONTENT_FRAGMENT = "content_fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MenuFragment menuFragment = new MenuFragment();
        fragmentTransaction.add(R.id.menuContainer, menuFragment, MenuFragment.TAG);

        if (ScreenHelper.isTablet(this)) {
            fragmentTransaction.add(R.id.contentContainer, new LoginFragment(), CONTENT_FRAGMENT);
        }

        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(String item) {
        Class clazz = null;
        try {
            if (ScreenHelper.isTablet(this)) {
                clazz = Class.forName(FRAGMENT_PATH.concat(item));
            } else {
                clazz = Class.forName(ACTIVITY_PATH.concat(item));
            }
        } catch (ClassNotFoundException e) {
            Logger.error(TAG, e.getMessage());
        }

        if (clazz != null) {
            if (ScreenHelper.isTablet(this)) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(CONTENT_FRAGMENT))
                        .add(R.id.contentContainer, new TextFieldsFragment(), CONTENT_FRAGMENT)
                        .commit();
            } else {
                Intent intent = new Intent(this, clazz);
                startActivity(intent);
            }
        }
    }

}
