package com.mattgroy.courseraandroid;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private Button btnContinue;

    private View.OnClickListener onContinueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isTextValid()) {
                showMessage(etText.getText());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        etText = findViewById(R.id.ac_main_et_text);
        btnContinue = findViewById(R.id.ac_main_btn_continue);

        btnContinue.setOnClickListener(onContinueClickListener);
    }

    private boolean isTextValid() {
        return !TextUtils.isEmpty(etText.getText());
    }

    private void showMessage(CharSequence message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}