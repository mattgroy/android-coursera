package com.mattgroy.FirstApplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnEnter;
    private Button btnRegister;

    private View.OnClickListener onEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent = new Intent(AuthActivity.this, ProfileActivity.class);
                startProfileIntent.putExtra(ProfileActivity.EMAIL_KEY, etLogin.getText().toString());
                startProfileIntent.putExtra(ProfileActivity.PASSWORD_KEY, etPassword.getText().toString());
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

    private boolean isEmailValid() {
        return !TextUtils.isEmpty(etLogin.getText()) &&
                Patterns.EMAIL_ADDRESS.matcher(etLogin.getText()).matches();
    }

    private void showMessage(@StringRes int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(etPassword.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        etLogin = findViewById(R.id.ac_auth_et_login);
        etPassword = findViewById(R.id.ac_auth_et_password);
        btnEnter = findViewById(R.id.ac_auth_btn_enter);
        btnRegister = findViewById(R.id.ac_auth_btn_register);

        btnEnter.setOnClickListener(onEnterClickListener);
        btnRegister.setOnClickListener(onRegisterClickListener);
    }
}