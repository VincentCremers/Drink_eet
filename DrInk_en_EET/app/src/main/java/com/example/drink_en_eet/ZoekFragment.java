package com.example.drink_en_eet;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ZoekFragment extends Fragment implements View.OnClickListener {
    private String titel;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String CALORIES = "calories";


    private static final String ETEN = "eten";
    private static final String PROTEIN = "protein";
    private static final String KOOLHYDRATEN = "koolhydraten";
    private static final String VETTEN = "vetten";



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
                Food food = new Food(eten.getText().toString(), Integer.parseInt(calories.getText().toString()), Integer.parseInt(eiwitten.getText().toString()), Integer.parseInt(koolhydraten.getText().toString()), Integer.parseInt(vetten.getText().toString()));
                Toast.makeText(getActivity(), String.valueOf(food.getCalories()), Toast.LENGTH_SHORT).show();
                etenOpslaan(food);
                break;
        }
    }

    private void etenOpslaan(Food food) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


//        editor.putString(ETEN, food.getName());
        editor.putInt(CALORIES, sharedPreferences.getInt(CALORIES, 0) + food.getCalories());
//        editor.putInt(PROTEIN, food.getProtein());
//        editor.putInt(KOOLHYDRATEN, food.getCarbs());
//        editor.putInt(VETTEN, food.getFat());

        editor.apply();
    }
}

