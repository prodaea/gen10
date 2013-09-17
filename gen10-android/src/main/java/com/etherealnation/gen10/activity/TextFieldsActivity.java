package com.etherealnation.gen10.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.fragment.TextFieldsFragment;

/**
 * Created by lcreasy on 9/17/13.
 * TextFieldsActivity
 */
public class TextFieldsActivity extends FragmentActivity {

    public static final String TAG = TextFieldsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.activityContainer, new TextFieldsFragment(), TextFieldsFragment.TAG);

        fragmentTransaction.commit();
    }

}
