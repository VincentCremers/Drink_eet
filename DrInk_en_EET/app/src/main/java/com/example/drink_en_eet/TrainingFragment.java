package com.example.drink_en_eet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class TrainingFragment extends Fragment implements View.OnClickListener {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String CALORIES = "calories";
    private static final String FOOD_LIST = "food_list";

    private ArrayList<Food> foods;

    private NumberPicker workout_wheel;
    private NumberPicker time_wheel;

    private HashMap<String, Integer> workout_calories;

    public String[] workouts;
    public String[] time_options;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_training, container, false);

        workout_wheel = view.findViewById(R.id.training_workout_wheel);
        time_wheel = view.findViewById(R.id.training_workout_time_wheel);
        Button invul_button = (Button) view.findViewById(R.id.training_invullen);

        workout_calories = new HashMap<String, Integer>();
        workout_calories.put("Hardlopen", 10);
        workout_calories.put("Touw springen", 15);
        workout_calories.put("Zwemmen", 30);
        workout_calories.put("Wandelen", 40);

        workouts = new String[]{"Hardlopen", "Touw springen", "Zwemmen", "Wandelen"};
        time_options = new String[]{"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"};

        workout_wheel.setMinValue(0);
        workout_wheel.setMaxValue(workouts.length-1);
        workout_wheel.setDisplayedValues(workouts);

        time_wheel.setMinValue(0);
        time_wheel.setMaxValue(time_options.length-1);
        time_wheel.setDisplayedValues(time_options);

        invul_button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.training_invullen:
                //Toast.makeText(getActivity(), "Workout: " + workouts[workout_wheel.getValue()] + "\n Tijd: " + time_options[time_wheel.getValue()], Toast.LENGTH_SHORT).show();
                calculate_calories(workout_wheel.getValue(), time_wheel.getValue());
                break;
        }
    }

    public void calculate_calories(int workout, int tijd){
        int verbrand = workout_calories.get(workouts[workout]) * Integer.parseInt(time_options[tijd]);
        Toast.makeText(getActivity(), "Calorieën verbrand: " + verbrand, Toast.LENGTH_SHORT).show();

        Food food = new Food("Training", verbrand*-1, 0,0,0);

        saveData(food);
    }

    private void saveData(Food food) {
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
