package com.example.drink_en_eet;

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

public class ForgetFragment extends Fragment implements View.OnClickListener {

    EditText email;

    Button verstuur;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_forget, container, false);

        email = (EditText) view.findViewById(R.id.email);

        verstuur = (Button) view.findViewById(R.id.verstuur);
        verstuur.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verstuur:
                String email_string = email.getText().toString();

                Log.i("FORGET EMAIL", email_string);

                newPassword(email_string);


        }

    }

    public void newPassword(final String email) {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String URL = "http://192.168.178.17:8080/api/password?email=" + email;

        StringRequest sr = new StringRequest(
                Request.Method.GET,
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
                        Log.i("FAILED", error.toString());
                    }
                });
        requestQueue.add(sr);
    }
}
