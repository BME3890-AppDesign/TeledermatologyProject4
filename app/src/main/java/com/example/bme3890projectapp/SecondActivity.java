package com.example.bme3890projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv_welcome;
    private Toolbar tb_myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_welcome = (TextView) findViewById(R.id.tv_welcome);
        Intent loginToApp = getIntent();
        //get extra info from intent
        String name = loginToApp.getStringExtra(MainActivity.NAME_EXTRA);

        //put string in textView
        tv_welcome.setText("Welcome, " + name);

        Toolbar my_Toolbar = (Toolbar) findViewById(R.id.tb_myToolbar);
        setSupportActionBar(my_Toolbar);
        getSupportActionBar().setTitle("Home Page");

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
            case R.id.mi_email:
                toThird(null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toThird(MenuItem item) {

        Intent i = new Intent(this, Email.class);
        startActivity(i);
    }

}