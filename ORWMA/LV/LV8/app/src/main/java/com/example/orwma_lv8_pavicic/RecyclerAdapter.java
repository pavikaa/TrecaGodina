package com.example.orwma_lv8_pavicic;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private final List<Product> productList = new ArrayList<>();

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ProductViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.setProduct(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void addProduct(List<Product> data) {
        this.productList.clear();
        this.productList.addAll(data);
        notifyDataSetChanged();
    }

}
