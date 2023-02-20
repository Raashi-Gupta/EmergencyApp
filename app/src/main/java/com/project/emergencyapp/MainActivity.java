package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginpg(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
    public void registerpg(View view) {
        Intent intent=new Intent(this,Registration.class);
        startActivity(intent);
    }
}