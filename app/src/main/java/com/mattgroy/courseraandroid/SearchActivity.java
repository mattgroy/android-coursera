package com.mattgroy.courseraandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    public static final String QUERY_KEY = "QUERY_KEY";

    private TextView tvQuery;
    private Button btnSearch;

    private View.OnClickListener onSearchClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_search);

        tvQuery = findViewById(R.id.ac_search_tv_text);
        btnSearch = findViewById(R.id.ac_search_btn_search);

        Bundle bundle = getIntent().getExtras();
        String query = bundle != null
                ? bundle.getString(QUERY_KEY)
                : null;
        tvQuery.setText(query);

        btnSearch.setOnClickListener(onSearchClickedListener);
    }
}
