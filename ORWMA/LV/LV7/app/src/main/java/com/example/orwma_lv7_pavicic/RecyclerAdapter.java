package com.example.orwma_lv7_pavicic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {
    private final List<String> studentsList = new ArrayList<>();
    private final NameClickListener clickListener;

    public RecyclerAdapter(NameClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new NameViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(studentsList.get(position));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public void addData(List<String> data) {
        this.studentsList.clear();
        this.studentsList.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewCell(String name) {
        studentsList.add(name);
        notifyItemInserted(studentsList.size());
    }

    public void removeCell(int position) {
        if (studentsList.size() > position) {
            studentsList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
