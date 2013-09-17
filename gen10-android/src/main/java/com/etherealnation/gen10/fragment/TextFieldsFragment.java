package com.etherealnation.gen10.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.util.ExtrasConstants;

/**
 * Created by lcreasy on 9/17/13.
 * TextFieldsFragment
 */
public class TextFieldsFragment extends Fragment {

    public static final String TAG = TextFieldsFragment.class.getSimpleName();
    private TextView loginOutput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        if (v == null) {
            v = inflater.inflate(R.layout.fragment_text_fields, container, false);
        }

        loginOutput = (TextView) v.findViewById(R.id.loginOutput);

        Bundle args = getArguments();
        if (args != null) {
            update(args.getString(ExtrasConstants.USERNAME), args.getString(ExtrasConstants.PASSWORD));
        }

        return v;
    }

    private void update(String username, String password) {
        if (loginOutput != null) {
            loginOutput.setText(username.concat(", ").concat(password));
        }
    }

}
