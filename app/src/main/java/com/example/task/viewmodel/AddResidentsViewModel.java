package com.example.task.viewmodel;

import androidx.databinding.BaseObservable;

public class AddResidentsViewModel extends BaseObservable {

    public boolean isNameValid(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isDobValid(String dob) {
        if (dob == null || dob.isEmpty()) {
            return false;
        }
        return true;
    }

}
