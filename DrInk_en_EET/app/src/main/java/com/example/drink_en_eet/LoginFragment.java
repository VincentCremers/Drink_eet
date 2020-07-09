package com.example.drink_en_eet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String JWT_TOKEN = "jwt";

    private EditText username;
    private EditText password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_login, container, false);

        Button registreer_button = (Button) view.findViewById(R.id.registreer);
        Button wwvergeten_button = (Button) view.findViewById(R.id.wwvergeten);
        Button login_button = (Button) view.findViewById(R.id.login);

        username = view.findViewById(R.id.voornaam);
        password = view.findViewById(R.id.achternaam);

        registreer_button.setOnClickListener(this);
        wwvergeten_button.setOnClickListener(this);
        login_button.setOnClickListener(this);


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
                break;

            case R.id.login:
                fakeLogin();
                getJWT();
        }
    }


    public void getJWT() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String URLs = "http://192.168.0.198:8080/api/authenticate";

        final String voornaam = username.getText().toString();
        final String password = this.password.getText().toString();

        Map<String, String> params = new HashMap<>();
        params.put("username", voornaam);
        params.put("password", password);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jr = new JsonObjectRequest(
                Request.Method.POST,
                URLs,
                parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        editor.putString(JWT_TOKEN, response.toString());
                        ((MainActivity)getActivity()).onCreateHelper();
                        Log.i("JSON RESPONSE", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ERROR", error.toString());
                    }
                });
        requestQueue.add(jr);
    }


    private void fakeLogin() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JWT_TOKEN, "token");
        editor.apply();
        ((MainActivity)getActivity()).onCreateHelper();
    }
}
