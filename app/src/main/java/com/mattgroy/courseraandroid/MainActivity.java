package com.mattgroy.courseraandroid;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private Button btnContinue;

    private final View.OnClickListener onContinueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            if (isTextValid()) {
                Utils.showMessage(MainActivity.this, etText.getText());

                Intent startSearchActivityIntent = new Intent(MainActivity.this, SearchActivity.class);
                startSearchActivityIntent.putExtra(SearchActivity.QUERY_KEY, etText.getText().toString());
                startActivity(startSearchActivityIntent);
            }
        }
    };

    private boolean isTextValid() {
        return !TextUtils.isEmpty(etText.getText());
    }

    private void animate(final AnimationDrawable animation) {
        animation.setEnterFadeDuration(10);
        animation.setExitFadeDuration(5000);
        animation.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        etText = findViewById(R.id.ac_main_et_text);
        btnContinue = findViewById(R.id.ac_main_btn_continue);
        AnimationDrawable background = (AnimationDrawable) findViewById(R.id.ac_main_layout).getBackground();

        animate(background);
        btnContinue.setOnClickListener(onContinueClickListener);
    }
}
