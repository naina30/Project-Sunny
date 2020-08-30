package com.example.sunny;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Launch extends AppCompatActivity {

    //This is the launch activity which shows the beautiful "sun" animation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        //Added an imageview for all the frames which are going to be used in the animation
        ImageView sun= findViewById(R.id.image);

        //Pre created animation list which contains the duration and list of the images which are going to be use din the animation
        sun.setImageResource(R.drawable.anim_list);

        //Creating an animation drawable object for getting drawable resources from the XML file
        AnimationDrawable movingSun= (AnimationDrawable) sun.getDrawable();

        //Start the animation drawable object using the inbuilt function start()
        movingSun.start();


        //Intents are used to migrate to the other activity. Here we have given a delay of 2000ms to migrate to the MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Launch.this, MainActivity.class);
                startActivity(i);
            }
        },2000);
    }
}