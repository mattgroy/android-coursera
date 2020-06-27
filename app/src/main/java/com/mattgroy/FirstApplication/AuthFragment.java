package com.mattgroy.FirstApplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class AuthFragment extends Fragment {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnEnter;
    private Button btnRegister;
    private View.OnClickListener onEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent = new Intent(getActivity(), ProfileActivity.class);
                startProfileIntent.putExtra(ProfileActivity.USER_KEY, new User(etLogin.getText().toString(), etPassword.getText().toString()));
                startActivity(startProfileIntent);
            } else {
                showMessage(R.string.auth_input_error);
            }
        }
    };
    private View.OnClickListener onRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO Обработка нажатий
        }
    };

    public static AuthFragment newInstance() {
        Bundle args = new Bundle();

        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private boolean isEmailValid() {
        return !TextUtils.isEmpty(etLogin.getText()) &&
                Patterns.EMAIL_ADDRESS.matcher(etLogin.getText()).matches();
    }

    private void showMessage(@StringRes int messageId) {
        Toast.makeText(getActivity(), messageId, Toast.LENGTH_LONG).show();
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(etPassword.getText());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_auth, container, false);

        etLogin = v.findViewById(R.id.ac_auth_et_login);
        etPassword = v.findViewById(R.id.ac_auth_et_password);
        btnEnter = v.findViewById(R.id.ac_auth_btn_enter);
        btnRegister = v.findViewById(R.id.ac_auth_btn_register);

        btnEnter.setOnClickListener(onEnterClickListener);
        btnRegister.setOnClickListener(onRegisterClickListener);

        return v;
    }
}