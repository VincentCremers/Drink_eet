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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class ZoekFragment extends Fragment implements View.OnClickListener {
    private String titel;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String FOOD_LIST = "food_list";

    private ArrayList<Food> foods;


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
                Toast.makeText(getActivity(), "Eten toegevoegd!", Toast.LENGTH_SHORT).show();
                etenOpslaan(food);
                break;
        }
    }


    private void etenOpslaan(Food food) {
        loadData();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        foods.add(food);

        String json = gson.toJson(foods);

        editor.putString(FOOD_LIST, json);
        editor.apply();
    }


    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPreferences.getString(FOOD_LIST, null);

        Type type = new TypeToken<ArrayList<Food>>() {
        }.getType();

        foods = gson.fromJson(json, type);

        if (foods == null) {
            foods = new ArrayList<>();
        }
    }
}











