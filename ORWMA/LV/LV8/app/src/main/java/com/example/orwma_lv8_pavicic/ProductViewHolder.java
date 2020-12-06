package com.example.orwma_lv8_pavicic;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView price;
    private final TextView rating;
    private final TextView description;
    private final ImageView image;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tvName);
        price = itemView.findViewById(R.id.tvPrice);
        rating = itemView.findViewById(R.id.tvRating);
        description = itemView.findViewById(R.id.tvDescription);
        image = itemView.findViewById(R.id.imageView);
    }

    public void setProduct(Product product) {
        this.name.setText(product.getName());
        if (product.getPrice() != null) {
            this.price.setText("Price: " + product.getPrice().toString());
        }
        if (product.getRating() != null) {
            this.rating.setText("Rating: " + product.getRating().toString());
        }
        this.description.setText(product.getDescription());
        Picasso.get().load(product.getImage_link()).into(image);
    }
}
