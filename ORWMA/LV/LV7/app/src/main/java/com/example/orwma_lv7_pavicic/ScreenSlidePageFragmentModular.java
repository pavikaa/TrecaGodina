package com.example.orwma_lv7_pavicic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScreenSlidePageFragmentModular extends Fragment implements NameClickListener {
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private Button btnSubmit;
    private EditText etAdd;
    private Random rd = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rd.nextBoolean()) {
            return inflater.inflate(R.layout.fragment_screen_slide_page_image_view, container, false);
        } else {
            View recyclerView = inflater.inflate(R.layout.fragment_screen_slide_recycler, container, false);
            etAdd = recyclerView.findViewById(R.id.editText);
            btnSubmit = recyclerView.findViewById(R.id.btnAdd);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addCell();
                }
            });
            List<String> data = new ArrayList<>();
            data.add("Ivan Ivić");
            data.add("Pero Perić");
            data.add("Luka Lukić");
            adapter = new RecyclerAdapter(this);
            adapter.addData(data);
            recycler = recyclerView.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recycler.setLayoutManager(layoutManager);
            recycler.setAdapter(adapter);
            return recyclerView;

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static ScreenSlidePageFragmentModular newInstance() {
        ScreenSlidePageFragmentModular fragment = new ScreenSlidePageFragmentModular();
        return fragment;
    }

    public void addCell() {
        String studentName = etAdd.getText().toString();
        if (studentName.matches("")) {
            Toast.makeText(getActivity(), "Niste unjeli ime i prezime", Toast.LENGTH_SHORT).show();
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


