package com.example.drink_en_eet;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MaaltijdFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_maaltijd, container, false);

        Button ontbijt_button = view.findViewById(R.id.maaltijd_ontbijt);
        Button middageten_button = view.findViewById(R.id.maaltijd_middageten);
        Button avondeten_button = view.findViewById(R.id.maaltijd_avondeten);
        Button snack_button = view.findViewById(R.id.maaltijd_snack);

        ontbijt_button.setOnClickListener(this);
        middageten_button.setOnClickListener(this);
        avondeten_button.setOnClickListener(this);
        snack_button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.maaltijd_ontbijt:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ZoekFragment("Ontbijt")).addToBackStack("tag").commit();
                break;

            case R.id.maaltijd_middageten:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ZoekFragment("Middageten")).addToBackStack("tag").commit();
                break;

            case R.id.maaltijd_avondeten:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ZoekFragment("Avondeten")).addToBackStack("tag").commit();
                break;

            case R.id.maaltijd_snack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ZoekFragment("Snack")).addToBackStack("tag").commit();
                break;

        }
    }


}
