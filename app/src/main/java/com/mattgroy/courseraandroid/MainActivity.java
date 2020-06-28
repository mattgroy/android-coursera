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

/**
 * Главное (стартовый) экран приложения.
 * Принимает от пользователя поисковый запрос и переключает на следующий экран.
 *
 * @author Max Ratkov
 * @since 28.06.2020
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Поле ввода поискового запроса.
     */
    private EditText etQuery;
    /**
     * Обработчик нажатия кнопки перехода на следущий экран.
     * По нажатии на кнопку показывает {@link android.widget.Toast} с введённым поисковым запросом
     * и переключает на {@link SearchActivity Activity поиска в интернете}.
     */
    private final View.OnClickListener onContinueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            if (isQueryValid()) {
                Utils.showToast(MainActivity.this, etQuery.getText());

                Intent startSearchActivityIntent = new Intent(MainActivity.this, SearchActivity.class);
                startSearchActivityIntent.putExtra(SearchActivity.QUERY_KEY, etQuery.getText().toString());
                startActivity(startSearchActivityIntent);
            }
        }
    };
    /**
     * Кнопка перехода на следующий экран.
     */
    private Button btnContinue;

    /**
     * Проверка валидности поискового запроса.
     *
     * @return является ли запрос валидным.
     */
    private boolean isQueryValid() {
        return !TextUtils.isEmpty(etQuery.getText());
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        etQuery = findViewById(R.id.ac_main_et_query);
        btnContinue = findViewById(R.id.ac_main_btn_continue);
        AnimationDrawable background = (AnimationDrawable) findViewById(R.id.ac_main_layout).getBackground();

        animate(background);
        btnContinue.setOnClickListener(onContinueClickListener);
    }
}
