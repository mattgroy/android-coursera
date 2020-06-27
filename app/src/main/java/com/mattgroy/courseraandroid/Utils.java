package com.mattgroy.courseraandroid;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static void showMessage(final Context context, final CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
