package com.example.drink_en_eet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Home");
        actionBar.setSubtitle("Welkom");
    }

    public void onButtonClick(View view){
        Toast.makeText(this, "INGEDRUKT", Toast.LENGTH_SHORT).show();
    }

    public void onLoginButtonClick(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.action_add:
//                //TODO
//            case R.id.action_settings:
//                //TODO
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}


















