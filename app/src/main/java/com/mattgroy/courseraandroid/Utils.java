package com.mattgroy.courseraandroid;

import android.content.Context;
import android.widget.Toast;

/**
 * Класс со вспомогательными методами.
 *
 * @author Max Ratkov
 * @since 28.06.2020
 */
public class Utils {
    /**
     * Создание {@link Toast} с сообщением.
     *
     * @param context контекст.
     * @param message сообщение для показа.
     */
    public static void showToast(final Context context, final CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
