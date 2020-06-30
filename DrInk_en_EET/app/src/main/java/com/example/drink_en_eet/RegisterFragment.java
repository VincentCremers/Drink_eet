package com.example.drink_en_eet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    EditText voornaam;
    EditText achternaam;
    EditText email;
    EditText wachtwoord;

//    Voor later
//    EditText herhaalwachtwoord;

    Button registreer;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_register, container, false);

        voornaam = (EditText) view.findViewById(R.id.voornaam);
        achternaam = (EditText) view.findViewById(R.id.achternaam);
        email = (EditText) view.findViewById(R.id.email);
        wachtwoord = (EditText) view.findViewById(R.id.wachtwoord);

//        Voor later
//        herhaalwachtwoord = (EditText) view.findViewById(R.id.wachtwoord_herhaal);

        registreer = (Button) view.findViewById(R.id.registreer);
        registreer.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registreer:
                String voornaam_string = voornaam.getText().toString();
                String achternaam_string  = achternaam.getText().toString();
                String email_string  = email.getText().toString();
                String wachtwoord_string = wachtwoord.getText().toString();

//                Voor in de console
                Log.i("VOORNAAM", voornaam_string);
                Log.i("ACHTERNAAM", achternaam_string);
                Log.i("EMAIL", email_string);
                Log.i("WACHTWOORD", wachtwoord_string);

                registerUser(voornaam_string, achternaam_string, email_string, wachtwoord_string);
        }
    }

    public void registerUser(String voornaam, final String achternaam, String email, String wachtwoord) {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        String URL = "http://192.168.178.17:8080/api/add";

        final String voornaam_string = voornaam;
        final String achternaam_string = achternaam;
        final String email_string = email;
        final String wachtwoord_string = wachtwoord;

        StringRequest sr= new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("SUCCES", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ERROR", error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("firstName", voornaam_string);
                params.put("lastName", achternaam_string);
                params.put("email", email_string);
                params.put("password", wachtwoord_string);

                return params;
            }
        };
        requestQueue.add(sr);
    }
}

