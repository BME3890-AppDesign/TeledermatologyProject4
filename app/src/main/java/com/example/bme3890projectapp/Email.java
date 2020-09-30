package com.example.bme3890projectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Email extends AppCompatActivity {

    private EditText et_emailAddress;
    //public static final String EXTRA_EMAIL = "com.example.bme3890projectapp.EMAIL.EXTRA";
    private EditText et_subjectName;
    //public static final String EXTRA_SUBJECT = "com.example.bme3890projectapp.SUBJECT.EXTRA";
    private EditText et_messageBody;
    //public static final String EXTRA_TEXT = "com.example.bme3890projectapp.TEXT.EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        et_emailAddress = (EditText) findViewById(R.id.et_emailAddress);
        et_subjectName = (EditText) findViewById(R.id.et_subjectName);
        et_messageBody = (EditText) findViewById(R.id.et_messageBody);

        Toolbar my_Toolbar = (Toolbar) findViewById(R.id.tb_myToolbar);
        setSupportActionBar(my_Toolbar);
        getSupportActionBar().setTitle("Send Message");
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

    public void sendEmail(View view){
        String recipient = et_emailAddress.getText().toString();
        String subject = et_subjectName.getText().toString();
        String message = et_messageBody.getText().toString();
        String[] recipients = recipient.split(",");

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        // Verify the intent will resolve to at least one activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
        else {
            System.out.println("no available app to send email");
        }
    }
}


