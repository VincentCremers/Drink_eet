package com.example.drink_en_eet;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SearchableActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "HIER GEKOMEN", Toast.LENGTH_SHORT).show();

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    public void doMySearch(String query) {
//        Toast.makeText(this, "HIER GEKOMEN", Toast.LENGTH_SHORT).show();

//        return query;
    }
}
