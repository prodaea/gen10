package com.etherealnation.gen10.fragment;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.etherealnation.gen10.activity.LoginActivity;
import com.etherealnation.gen10.activity.TextFieldsActivity;
import com.etherealnation.gen10.util.Logger;
import com.etherealnation.gen10.util.ScreenHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcreasy on 9/17/13.
 * MenuFragment
 */
public class MenuFragment extends ListFragment {

    public static final Map<String, String> MENU_IDS;
    public static final String TAG = MenuFragment.class.getSimpleName();
    private OnMenuItemClickedListener listener;

    static {
        MENU_IDS = new HashMap<String, String>();
        MENU_IDS.put(LoginFragment.TAG, LoginActivity.TAG);
        MENU_IDS.put(TextFieldsFragment.TAG, TextFieldsActivity.TAG);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnMenuItemClickedListener) activity;
        } catch (ClassCastException ex) {
            Logger.error(TAG, activity.toString() + " must implement OnMenuItemClickedListener");
            throw new ClassCastException(activity.toString() + " must implement OnMenuItemClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity == null) return null;
        String[] ids = new String[MENU_IDS.size()];
        if (ScreenHelper.isTablet(activity)) {
            ids = MENU_IDS.keySet().toArray(ids);
        } else {
            ids = MENU_IDS.values().toArray(ids);
        }
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1, ids));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (listener != null) {
            listener.onClick((String) getListAdapter().getItem(position));
        }
    }

    public interface OnMenuItemClickedListener {
        void onClick(String item);
    }

}
