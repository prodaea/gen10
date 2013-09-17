package com.etherealnation.gen10;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.etherealnation.gen10.fragment.ContentFragment;
import com.etherealnation.gen10.fragment.HashListFragment;
import com.etherealnation.gen10.util.ScreenHelper;

/**
 * Created by lcreasy on 9/17/13.
 * MainActivity
 */
public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.list_container, new HashListFragment());

        if (ScreenHelper.isTablet(this)) {
            fragmentTransaction.add(R.id.content_container, new ContentFragment());
        } else {
            findViewById(R.id.content_container).setVisibility(View.GONE);
        }

        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
