package com.example.bme3890projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv_welcome;
    private Toolbar tb_myToolbar;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_welcome = (TextView) findViewById(R.id.tv_welcome);
        url = "https://www.skincancer.org/skin-cancer-information/basal-cell-carcinoma/";

        Intent loginToApp = getIntent();
        //get extra info from intent
        String name = loginToApp.getStringExtra(MainActivity.NAME_EXTRA);

        //put string in textView
        if (name == null) {
            tv_welcome.setText("Welcome!");
        } else {
            tv_welcome.setText("Welcome, " + name + "!");
        }
        Toolbar my_Toolbar = (Toolbar) findViewById(R.id.tb_myToolbar);
        setSupportActionBar(my_Toolbar);
        getSupportActionBar().setTitle("Home");

        findViewById(R.id.btn_aboutBCC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAboutBCC(url = "https://www.skincancer.org/skin-cancer-information/basal-cell-carcinoma/");

            }
        });
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

    public void toNewVisit(View view) {
        Intent i = new Intent(this, NewVisit.class);
        startActivity(i);

    }

    public void toMyImages(View view) {
        Intent i = new Intent(this, MyImages.class);
        startActivity(i);

    }

    public void toMyResults(View view) {
        Intent i = new Intent(this, MyResults.class);
        startActivity(i);

    }

    public void toAboutUs(View view) {
        Intent i = new Intent(this, AboutUs.class);
        startActivity(i);

    }

    public void toAboutBCC(String url) {
        Uri webpage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, webpage);
        if (i.resolveActivity(getPackageManager())!= null) {
            startActivity(i);
        }

    }

}