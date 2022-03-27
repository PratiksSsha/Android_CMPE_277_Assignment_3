package com.example.android_assignment_third;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //For Launching the URL
        Button launchUrl = (Button) findViewById(R.id.launchUrl);
        launchUrl.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                EditText getUrl = (EditText) findViewById(R.id.getUrl);
                String s = getUrl.getText().toString();
                if (s.indexOf("http://www") < 0) {
                    s = "http://www." + s;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(s));
                startActivity(implicit);
            }
        });
        //For Making a call
        Button connectCall = (Button) findViewById(R.id.connectCall);
        connectCall.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                EditText getContact = (EditText) findViewById(R.id.getContact);
                Intent implicit = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + getContact.getText().toString()));
                startActivity(implicit);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
