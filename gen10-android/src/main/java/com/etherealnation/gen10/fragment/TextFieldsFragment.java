package com.etherealnation.gen10.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.etherealnation.gen10.R;
import com.etherealnation.gen10.activity.BlankActivity;
import com.etherealnation.gen10.util.ExtrasConstants;
import com.etherealnation.gen10.util.Logger;

import java.util.HashMap;

/**
 * Created by lcreasy on 9/17/13.
 * TextFieldsFragment
 */
public class TextFieldsFragment extends Fragment {

    public static final String TAG = TextFieldsFragment.class.getSimpleName();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
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

        v.findViewById(R.id.blankLaunch).setOnClickListener(new OnBlankLaunchClickedListener());

        return v;
    }

    private void update(String username, String password) {
        if (loginOutput != null) {
            loginOutput.setText(username.concat(", ").concat(password));
        }
    }

    private class OnBlankLaunchClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Logger.debug(TAG, "Building hash in thread!");
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    Activity activity = getActivity();
                    if (activity == null) return;
                    Intent intent = new Intent(activity, BlankActivity.class);
                    intent.putExtra(ExtrasConstants.BLANK_HASH, msg.getData());
                    activity.startActivity(intent);
                }
            };
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HashMap<Character, Integer> alphakeys = new HashMap<Character, Integer>();
                    for (Integer i = 0; i < ALPHABET.length(); i++) {
                        alphakeys.put(ALPHABET.charAt(i), i);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ExtrasConstants.BLANK_HASH, alphakeys);
                    Message msg = new Message();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                }
            }).start();
        }
    }
}
