package com.example.task.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.task.R;
import com.example.task.databinding.FragmentResidentsBinding;
import com.example.task.db.AppDatabase;
import com.example.task.db.Resident;
import com.example.task.db.ResidentsDao;
import com.example.task.viewmodel.ResidentViewModel;

import java.util.List;

public class ResidentsFragment extends Fragment {

    private ResidentViewModel mResidentViewModel;
    private FragmentResidentsBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_residents, container, false);
        setupBindings();
        initRecyclerView();
        initDao();
        loadData();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void setupBindings() {
        mResidentViewModel = ViewModelProviders.of(this).get(ResidentViewModel.class);
        mResidentViewModel.init();

        binding.setViewModel(mResidentViewModel);

        mResidentViewModel.getResidentList().observe(getViewLifecycleOwner(), new Observer<List<Resident>>() {
            @Override
            public void onChanged(List<Resident> residents) {
                mResidentViewModel.getResidentAdapter().refreshData(residents);
                mResidentViewModel.getResidentAdapter().notifyDataSetChanged();
            }
        });
    }

    private void initDao() {
        ResidentsDao residentsDao = AppDatabase.getInstance(this.getContext()).residentsDao();
        mResidentViewModel.setResidentsDao(residentsDao);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.residentsList.setLayoutManager(layoutManager);
    }

    private void loadData() {
        mResidentViewModel.showResidents();
    }

}
