package com.example.task.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "resident")
public class Resident {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "resid")
    public String mId;

    @ColumnInfo(name = "name")
    public String mName;

    @ColumnInfo(name = "dob")
    public String mDOB;

    @ColumnInfo(name = "address")
    public String mAddress;


    public Resident() {
        mId = UUID.randomUUID().toString();
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDOB(String mDOB) {
        this.mDOB = mDOB;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
