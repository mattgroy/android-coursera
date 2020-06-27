package com.mattgroy.FirstApplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class RegistrationFragment extends Fragment {

    private EditText etLogin;
    private EditText etPassword;
    private EditText etPasswordAgain;
    private Button btnRegistration;

    private SharedPreferencesHelper sharedPreferencesHelper;

    private View.OnClickListener onRegistrationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isInputValid()) {
                boolean isAdded = sharedPreferencesHelper.addUser(new User(
                        etLogin.getText().toString(),
                        etPassword.getText().toString()
                ));

                if (isAdded) {
                    showMessage(R.string.login_register_success);
                } else {
                    showMessage(R.string.login_register_error);
                }
            } else {
                showMessage(R.string.input_error);
            }
        }
    };

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_register, container, false);

        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        etLogin = view.findViewById(R.id.fr_register_et_login);
        etPassword = view.findViewById(R.id.fr_register_et_password);
        etPasswordAgain = view.findViewById(R.id.fr_register_et_password_repeat);
        btnRegistration = view.findViewById(R.id.fr_register_btn_register);

        btnRegistration.setOnClickListener(onRegistrationClickListener);

        return view;
    }

    private boolean isInputValid() {
        String email = etLogin.getText().toString();
        return isEmailValid(email) && isPasswordsValid();
    }

    private boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordsValid() {
        String password = etPassword.getText().toString();
        String passwordAgain = etPasswordAgain.getText().toString();

        return password.equals(passwordAgain) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(passwordAgain);
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }

}
