package com.example.drink_en_eet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment implements View.OnClickListener {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String DAILY_CALORIES = "calories";

    private EditText calorieen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_instellingen, container, false);

        calorieen = view.findViewById(R.id.instellingen_calorieen);
        Button button = view.findViewById(R.id.instellingen_calorieen_button);

        button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.instellingen_calorieen_button:
                setDailyCalories();
                break;
        }
    }

    private void setDailyCalories(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(DAILY_CALORIES, Integer.parseInt(calorieen.getText().toString()));
        editor.apply();
    }
}
