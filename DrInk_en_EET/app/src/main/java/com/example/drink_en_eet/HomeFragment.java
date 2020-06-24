package com.example.drink_en_eet;

import android.content.Intent;
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

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ProgressBar progressBar;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_home, container, false);

        Button button_toevoegen = (Button) view.findViewById(R.id.home_toevoegen);
        button_toevoegen.setOnClickListener(this);

        Button button_training = (Button) view.findViewById(R.id.home_training);
        button_training.setOnClickListener(this);

        textView = view.findViewById(R.id.progress_text);
        progressBar = view.findViewById(R.id.home_progress);

        Button plus = (Button) view.findViewById(R.id.plus);
        plus.setOnClickListener(this);

        Button min = (Button) view.findViewById(R.id.min);
        min.setOnClickListener(this);

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
            case R.id.plus:
                progressBar.setProgress(progressBar.getProgress()+10);
                textView.setText(String.valueOf(progressBar.getProgress()));
                break;
            case R.id.min:
                progressBar.setProgress(progressBar.getProgress()-10);
                textView.setText(String.valueOf(progressBar.getProgress()));
                break;
        }
    }


}
