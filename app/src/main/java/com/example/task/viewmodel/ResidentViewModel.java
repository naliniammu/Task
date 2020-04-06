package com.example.task.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.adapter.ResidentAdapter;
import com.example.task.db.Resident;
import com.example.task.db.ResidentsDao;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ResidentViewModel extends ViewModel {

    private MutableLiveData<List<Resident>> mResidentList;
    private ResidentAdapter mResidentAdapter;
    private ResidentsDao mResidentsDao;

    public void init() {
        mResidentAdapter = new ResidentAdapter();
    }

    public MutableLiveData<List<Resident>> getResidentList() {
        if (mResidentList == null) {
            mResidentList = new MutableLiveData<>();
        }
        return mResidentList;
    }


    public ResidentAdapter getResidentAdapter() {
        return mResidentAdapter;
    }

    public void setResidentsDao(ResidentsDao residentsDao) {
        this.mResidentsDao = residentsDao;
    }

    public void showResidents() {
        mResidentsDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<Resident>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Resident> residents) {
                        getResidentList().setValue(residents);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
