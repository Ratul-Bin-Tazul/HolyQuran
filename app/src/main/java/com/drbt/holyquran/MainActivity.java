package com.drbt.holyquran;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    

    public void suraList (View v) {
        Intent intent = new Intent(MainActivity.this,suraList.class);
        startActivity(intent);
    }

    public void aboutUs (View v) {
        Intent intent = new Intent(MainActivity.this,aboutUs.class);
        startActivity(intent);
    }

    public void rateApp (View v) {
        Intent intent = new Intent(MainActivity.this,rateApp.class);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // Intent intent = new Intent(MainActivity.this,dummy.class);


    }
}


