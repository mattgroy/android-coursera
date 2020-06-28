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

/**
 * Экран запуска поискового запроса.
 *
 * @author Max Ratkov
 * @since 28.06.2020
 */
public class SearchActivity extends AppCompatActivity {
    /**
     * Ключ для получения поискового запроса с главного экрана.
     */
    public static final String QUERY_KEY = "QUERY_KEY";

    /**
     * Кодировка поискового запроса.
     */
    private static final String SEARCH_ENCODING = "UTF-8";
    /**
     * Адрес поисковой системы.
     */
    private static final String SEARCH_ADDRESS = "http://www.google.com/#q=";

    /**
     * Поле с введённым пользователем поисковым запросом.
     */
    private TextView tvQuery;
    /**
     * Обработчик нажатия кнопки выполнения поискового запроса.
     * По нажатии на кнопку открывает браузер с введённым в
     * {@link SearchActivity#SEARCH_ADDRESS поисковик} {@link SearchActivity#tvQuery запросом}.
     */
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
    /**
     * Кнопка выполнения поискового запроса.
     */
    private Button btnSearch;

    /**
     * Кодирование поискового запроса.
     *
     * @param query поисковый запрос.
     * @return поисковый запрос в кодировке {@link SearchActivity#SEARCH_ENCODING}.
     */
    @Nullable
    private String encodeQuery(final String query) {
        String encodedQuery = null;
        try {
            encodedQuery = URLEncoder.encode(query, SEARCH_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedQuery;
    }

    /**
     * Подготовка и запуск анимации.
     *
     * @param animation анимация.
     */
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
