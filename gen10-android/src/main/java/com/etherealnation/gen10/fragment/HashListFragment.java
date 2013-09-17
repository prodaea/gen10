package com.etherealnation.gen10.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.etherealnation.gen10.R;

/**
 * Created by lcreasy on 9/17/13.
 * HashListFragment
 */
public class HashListFragment extends Fragment {

    public static final Integer[] MENU_IDS = new Integer[]{
            R.string.PAGE_1,
            R.string.PAGE_2,
            R.string.PAGE_3,
            R.string.PAGE_4,
            R.string.PAGE_5
    } ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        if (v == null) {
            v = inflater.inflate(R.layout.list, container, false);
        }

        return v;
    }

}
