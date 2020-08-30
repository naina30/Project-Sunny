package com.example.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.*;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity { //This is the activity which contains a list of all the chat windows

    Button settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Adding functionality to the Settings button to help migrate to the settings activity
        settings=findViewById(R.id.Vectorsettings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });


        //Attached a RecyclerViewer to recycle the existing memory space for the chat rooms.
        //Created an adapter to attach data into the Viewholder.
        RecyclerView chatlist= findViewById(R.id.chat_list);
        chatlist.setLayoutManager(new LinearLayoutManager(this));


        //Random data to check and display recyler viewer
        String[] names={"Sanjukta", "John", "Naina"};
        String[] message={"Been trying to call you", "What's up", "How you doin?"};


        //Pre created adapter named chatAdapter has been set
        chatlist.setAdapter(new chatAdapter(names, message));


        //Adding functionality to the items now, so that we can migrate to the individual chat windows after clicking their specific rooms
        chatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, chatWindow.class);
                startActivity(intent);
            }
        });
    }
}