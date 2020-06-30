package com.example.drink_en_eet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_login, container, false);

        Button registreer_button = (Button) view.findViewById(R.id.registreer);
        Button wwvergeten_button = (Button) view.findViewById(R.id.wwvergeten);

        registreer_button.setOnClickListener(this);
        wwvergeten_button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registreer:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RegisterFragment()).addToBackStack("tag").commit();
                break;

            case R.id.wwvergeten:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ForgetFragment()).addToBackStack("tag").commit();
        }
    }
}
