package com.mattgroy.FirstApplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ProfileActivity extends AppCompatActivity {

    public static final String EMAIL_KEY = "EMAIL_KEY";
    public static final String PASSWORD_KEY = "PASSWORD_KEY";

    private AppCompatImageView ivPhoto;
    private TextView tvLogin;
    private TextView tvPassword;

    private View.OnClickListener onPhotoClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_profile);

        ivPhoto = findViewById(R.id.ac_profile_iv_photo);
        tvLogin = findViewById(R.id.ac_profile_tv_email);
        tvPassword = findViewById(R.id.ac_profile_tv_password);

        Bundle bundle = getIntent().getExtras();
        tvLogin.setText(bundle.getString(EMAIL_KEY));
        tvPassword.setText(bundle.getString(PASSWORD_KEY));

        ivPhoto.setOnClickListener(onPhotoClickedListener);
    }
}
