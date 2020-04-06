package com.example.task.util;

import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("app:onFocusChange")
    public static void onFocusChange(EditText text, final View.OnFocusChangeListener listener) {
        text.setOnFocusChangeListener(listener);
    }
}
