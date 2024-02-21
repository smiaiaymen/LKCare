package com.example.lkcare1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NurseAdapter extends RecyclerView.Adapter<NurseAdapter.NurseViewHolder> {
    private List<Nurse> nurseList;

    public NurseAdapter(List<Nurse> nurseList) {
        this.nurseList = nurseList;
    }

    @NonNull
    @Override
    public NurseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nurse_item, parent, false);
        return new NurseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NurseViewHolder holder, int position) {
        Nurse nurse = nurseList.get(position);
        holder.nameTextView.setText("Nom: " + nurse.getName());
        holder.cinTextView.setText("CIN: " + nurse.getCIN());
        holder.phoneTextView.setText("Téléphone: " + nurse.getPhone());
    }

    @Override
    public int getItemCount() {
        return nurseList.size();
    }

    public static class NurseViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView cinTextView;
        public TextView phoneTextView;

        public NurseViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            cinTextView = itemView.findViewById(R.id.cinTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
        }
    }
}
