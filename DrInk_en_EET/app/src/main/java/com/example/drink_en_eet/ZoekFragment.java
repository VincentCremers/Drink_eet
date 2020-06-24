package com.example.drink_en_eet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ZoekFragment extends Fragment implements View.OnClickListener {
    private String titel;

    public ZoekFragment(String titel){
        this.titel = titel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_eten_zoeken, container, false);

        TextView text = view.findViewById(R.id.zoeken_titel);



        text.setText(titel);


        return view;
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button4:
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new SettingsFragment()).addToBackStack("tag").commit();
//                break;
//        }
    }
}
