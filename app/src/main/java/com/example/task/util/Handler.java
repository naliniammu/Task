package com.example.task.util;

import android.view.View;

import com.example.task.R;
import com.google.android.material.textfield.TextInputEditText;


public class Handler {
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) { System.out.print("S");

                if (!hasFocus) {
                    switch (view.getId()) {
                        case R.id.et_name:
                        case R.id.et_dob:
                            if (view instanceof TextInputEditText && ((TextInputEditText) view).getText().toString().isEmpty()) {
                                ((TextInputEditText) view).setError("Please enter " + ((TextInputEditText) view).getHint());
                            }
                    }
                }
            }
        };
    }
}
