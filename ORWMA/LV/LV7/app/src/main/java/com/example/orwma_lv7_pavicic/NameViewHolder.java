package com.example.orwma_lv7_pavicic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView tvStudents;
    private final NameClickListener clickListener;
    private final Button btnRemove;

    public NameViewHolder(@NonNull View itemView, NameClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        tvStudents = itemView.findViewById(R.id.tvStudents);
        btnRemove = itemView.findViewById(R.id.btnRemove);
        itemView.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    public void setName(String student) {
        tvStudents.setText(student);
    }

    @Override
    public void onClick(View v) {
        clickListener.onNameClick(getAdapterPosition());
    }
}
