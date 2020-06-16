package com.example.drink_en_eet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_home, container, false);
    }

    public void onButtonClick(View view){
        Toast.makeText(getActivity(), "INGEDRUKT", Toast.LENGTH_SHORT).show();
    }

    public void onLoginButtonClick(View view){
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
    }
}
