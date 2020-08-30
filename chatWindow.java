package com.example.sunny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

public class chatWindow extends AppCompatActivity {

    EditText userinput;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        userinput=findViewById(R.id.enteredText);
        recyclerView=findViewById(R.id.conversations);

    }
}