package com.mattgroy.courseraandroid;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchActivity extends AppCompatActivity {
    public static final String QUERY_KEY = "QUERY_KEY";

    private static final String SEARCH_ENCODING = "UTF-8";
    private static final String SEARCH_ADDRESS = "http://www.google.com/#q=";

    private TextView tvQuery;
    private Button btnSearch;

    private final View.OnClickListener onSearchClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            String query = encodeQuery(tvQuery.getText().toString());
            if (query == null) return;

            Uri uri = Uri.parse(SEARCH_ADDRESS + query);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    @Nullable
    private String encodeQuery(final String query) {
        String escapedQuery = null;
        try {
            escapedQuery = URLEncoder.encode(query, SEARCH_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return escapedQuery;
    }

    private void animate(final AnimationDrawable animation) {
        animation.setEnterFadeDuration(10);
        animation.setExitFadeDuration(5000);
        animation.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_search);

        tvQuery = findViewById(R.id.ac_search_tv_text);
        btnSearch = findViewById(R.id.ac_search_btn_search);
        AnimationDrawable background = (AnimationDrawable) findViewById(R.id.ac_search_layout).getBackground();
        animate(background);

        Bundle bundle = getIntent().getExtras();
        String query = bundle != null
                ? bundle.getString(QUERY_KEY)
                : null;
        tvQuery.setText(query);

        btnSearch.setOnClickListener(onSearchClickedListener);
    }
}
