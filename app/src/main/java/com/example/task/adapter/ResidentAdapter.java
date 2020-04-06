package com.example.task.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.R;
import com.example.task.databinding.ViewResidentBinding;
import com.example.task.db.Resident;

import java.util.List;


public class ResidentAdapter extends RecyclerView.Adapter<ResidentViewHolder> {
    private List<Resident> residentList;

    @NonNull
    @Override
    public ResidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewResidentBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.view_resident, parent, false);
        return new ResidentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentViewHolder holder, int position) {
        holder.bind(residentList.get(position));
    }

    @Override
    public int getItemCount() {
        if (residentList == null)
            return 0;
        return residentList.size();
    }

    public void refreshData(List<Resident> residents) {
        residentList = residents;
    }
}

class ResidentViewHolder extends RecyclerView.ViewHolder {
    private ViewResidentBinding binding;

    public ResidentViewHolder(@NonNull ViewResidentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(Resident resident) {
        binding.setResident(resident);
    }
}
