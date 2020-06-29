package com.example.drink_en_eet;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ZoekFragment extends Fragment implements View.OnClickListener {
    private String titel;

    private ArrayList<EditText> input;

    private EditText eten;
    private EditText calories;
    private EditText eiwitten;
    private EditText koolhydraten;
    private EditText vetten;

    public ZoekFragment(String titel) {
        this.titel = titel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_eten_zoeken_2, container, false);

        input = new ArrayList<>();

        TextView text = view.findViewById(R.id.zoeken2_titel);
        Button button = view.findViewById(R.id.zoeken2_toevoegen);

        eten = view.findViewById(R.id.zoeken_eten);
        calories = view.findViewById(R.id.zoeken_calories);
        eiwitten = view.findViewById(R.id.zoeken_eiwitten);
        koolhydraten = view.findViewById(R.id.zoeken_koolhydraten);
        vetten = view.findViewById(R.id.zoeken_vetten);



        text.setText(titel);
        button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zoeken2_toevoegen:

                break;
        }
    }
}

