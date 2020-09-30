package com.example.bme3890projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Toolbar my_Toolbar = (Toolbar) findViewById(R.id.tb_myToolbar);
        setSupportActionBar(my_Toolbar);
        getSupportActionBar().setTitle("About Us");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle the selected item
        switch (item.getItemId()) {
            case R.id.mi_home:
                toHome(null);
                return true;
            case R.id.mi_email:
                toThird(null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toHome(MenuItem item) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void toThird(MenuItem item) {

        Intent i = new Intent(this, Email.class);
        startActivity(i);
    }
}