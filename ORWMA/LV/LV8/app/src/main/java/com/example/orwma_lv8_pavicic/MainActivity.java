package com.example.orwma_lv8_pavicic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Call<List<Product>> apiCall;
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private EditText etSearch;
    private Button btnSearch;
    private String brandToSearch = "maybelline";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
        setupRecycler();
        setUpApiCall();
    }

    private void setupRecycler() {
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter();
        recycler.setAdapter(adapter);
    }

    private void setUpApiCall() {
        apiCall = NetworkUtils.getApiInterface().getProducts(brandToSearch);
        apiCall.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showProducts(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showProducts(List<Product> data) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setDescription(data.get(i).getDescription().replaceAll("\n", " "));
        }
        adapter.addProduct(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null)
            apiCall.cancel();
    }

    @Override
    public void onClick(View v) {
        if (etSearch.getText().toString().matches(""))
            Toast.makeText(this, R.string.enterMsg, Toast.LENGTH_SHORT).show();
        else {
            brandToSearch = etSearch.getText().toString();
            setupRecycler();
            setUpApiCall();
            etSearch.getText().clear();
        }
    }
}