package com.mattgroy.FirstApplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ProfileActivity extends AppCompatActivity {

    public static final String USER_KEY = "USER_KEY";

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
        User user = (User) bundle.get(USER_KEY);
        tvLogin.setText(user.getLogin());
        tvPassword.setText(user.getPassword());

        ivPhoto.setOnClickListener(onPhotoClickedListener);
    }
}
