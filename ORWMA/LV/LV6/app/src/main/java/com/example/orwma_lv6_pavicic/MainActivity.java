package com.example.orwma_lv6_pavicic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    EditText etAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAdd = findViewById(R.id.editText);
        setupRecycler();
        setupRecyclerData();
    }

    private void setupRecycler() {
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    private void setupRecyclerData() {
        List<String> data = new ArrayList<>();
        data.add("Ivan Ivić");
        data.add("Pero Perić");
        data.add("Luka Lukić");
        adapter.addData(data);
    }

    public void addCell(View view) {
        String studentName = etAdd.getText().toString();
        if (studentName.matches("")) {
            Toast.makeText(this, "Niste unjeli ime i prezime", Toast.LENGTH_SHORT).show();
        } else {
            adapter.addNewCell(studentName);
            etAdd.getText().clear();
        }
    }

    public void removeCell(View view) {
        adapter.removeCell(0);
    }

    @Override
    public void onNameClick(int position) {
        adapter.removeCell(position);
    }
}