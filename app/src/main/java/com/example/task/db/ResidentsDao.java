package com.example.task.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ResidentsDao {
    @Query("SELECT * FROM Resident")
    Single<List<Resident>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertOrUpdateResident(Resident resident);
}
