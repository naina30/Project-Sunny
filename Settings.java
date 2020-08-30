package com.example.sunny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity { //The activity which shows the settings panel.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings3);
        Button mbutton= findViewById(R.id.vector);
        Button logout=findViewById(R.id.logoutButton);
        TextView logoutText=findViewById(R.id.log_out);

        //Adding functionality to chatBubble to migrate to MainActivity
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Settings.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //Adding functionality to logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Settings.this, Signin.class);
                startActivity(intent);
            }
        });

        //Adding functionality to logout text
        logoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Settings.this, Signin.class);
                startActivity(intent);
            }
        });
    }
}