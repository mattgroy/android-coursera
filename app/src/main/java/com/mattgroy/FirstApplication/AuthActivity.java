package com.mattgroy.FirstApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnEnter;
    private Button btnRegister;

    private View.OnClickListener onEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO Обработка нажатий
        }
    };
    private View.OnClickListener onRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO Обработка нажатий
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnEnter = findViewById(R.id.btnEnter);
        btnRegister = findViewById(R.id.btnRegister);

        btnEnter.setOnClickListener(onEnterClickListener);
        btnRegister.setOnClickListener(onRegisterClickListener);
    }
}