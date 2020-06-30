package com.example.drink_en_eet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String DAILY_CALORIES = "calories";
    private static final String FOOD_LIST = "food_list";
    private static final String JWT_TOKEN = "jwt";

    private ArrayList<Food> foods;
    private int maxCalories;


    private ProgressBar progressBar;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home, container, false);


        Button button_toevoegen = view.findViewById(R.id.home_toevoegen);
        button_toevoegen.setOnClickListener(this);

        Button button_training = view.findViewById(R.id.home_training);
        button_training.setOnClickListener(this);

        textView = view.findViewById(R.id.progress_text);
        progressBar = view.findViewById(R.id.home_progress);

        setProgressBar();

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_toevoegen:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MaaltijdFragment()).addToBackStack("tag").commit();
                break;
            case R.id.home_training:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TrainingFragment()).addToBackStack("tag").commit();
                break;
        }
    }

    public void setProgressBar() {
        loadData();

        progressBar.setMax(maxCalories);

        int calorieen = 0;
        for (Food food : foods) {
            calorieen += food.getCalories();
        }

        progressBar.setProgress(calorieen, true);
        textView.setText(String.valueOf(progressBar.getProgress()) + "/" + String.valueOf(maxCalories));

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPreferences.getString(FOOD_LIST, null);
        maxCalories = sharedPreferences.getInt(DAILY_CALORIES, 2000);

        Type type = new TypeToken<ArrayList<Food>>() {
        }.getType();

        foods = gson.fromJson(json, type);

        if (foods == null) {
            foods = new ArrayList<>();
        }
    }
}
