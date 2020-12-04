package com.example.orwma_lv7_pavicic;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class ScreenSlidePageFragmentEditText extends Fragment implements TextWatcher {
    private String mMessageString = "Default message";
    private EditText mEditText;
    private Button mSubmitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_slide_page_edit_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditText = view.findViewById(R.id.edMessage);
        mSubmitButton = view.findViewById(R.id.btSubmit);
        setUpListeners();
    }

    public static ScreenSlidePageFragmentEditText newInstance() {
        ScreenSlidePageFragmentEditText fragment = new ScreenSlidePageFragmentEditText();
        return fragment;
    }

    private void setUpListeners() {
        mEditText.addTextChangedListener(this);
        ViewPager viewPager = getActivity().findViewById(R.id.viewPager);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                ScreenSlidePageFragment.setText(mMessageString);
                mEditText.getText().clear();
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mMessageString = s.toString();
    }

}
