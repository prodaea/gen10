package com.etherealnation.gen10.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.util.Logger;

/**
 * Created by lcreasy on 9/17/13.
 * LoginFragment
 */
public class LoginFragment extends Fragment {

    public static final String TAG = LoginFragment.class.getSimpleName();
    private EditText usernameField;
    private EditText passwordField;
    private Button loginButton;
    private OnLoginClickedListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnLoginClickedListener) activity;
        } catch (ClassCastException ex) {
            Logger.error(TAG, activity.toString() + " must implement OnLoginClickedListener");
            throw new ClassCastException(activity.toString() + " must implement OnLoginClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        if (v == null) {
            v = inflater.inflate(R.layout.fragment_login, container, false);
        }

        usernameField = (EditText) v.findViewById(R.id.username);
        passwordField = (EditText) v.findViewById(R.id.password);
        passwordField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_GO) {
                    startTextFields();
                }
                return false;
            }
        });

        loginButton = (Button) v.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new OnLoginButtonClickedListener());

        CheckBox showPassword = (CheckBox) v.findViewById(R.id.showPassword);
        showPassword.setOnCheckedChangeListener(new ShowPasswordOnCheckedChangeListener());

        return v;
    }

    private void startTextFields() {
        if (listener != null) {
            listener.onLoginClick(usernameField.getText().toString(), passwordField.getText().toString());
        }
    }

    private class ShowPasswordOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int start = passwordField.getSelectionStart();
            int end = passwordField.getSelectionEnd();
            if (isChecked) {
                passwordField.setTransformationMethod(null);
            } else {
                passwordField.setTransformationMethod(new PasswordTransformationMethod());
            }
            passwordField.setSelection(start, end);
        }
    }

    public interface OnLoginClickedListener {
        void onLoginClick(String username, String password);
    }

    private class OnLoginButtonClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startTextFields();
        }
    }
}
