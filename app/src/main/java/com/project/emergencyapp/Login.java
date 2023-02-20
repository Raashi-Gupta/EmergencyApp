package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView username =(TextView) findViewById(R.id.userid);
        TextView password =(TextView) findViewById(R.id.password);
        RadioGroup radiogrp=(RadioGroup) findViewById(R.id.radiogrp);
        Button loginbtn = (Button) findViewById(R.id.login_button);
        RadioButton amb=(RadioButton) findViewById(R.id.amb_bttn);
        RadioButton hos=(RadioButton) findViewById(R.id.hos_bttn);
//        int radioId=radiogrp.getCheckedRadioButtonId();
//        RadioButton radiobutton=((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId()));
        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

//                RadioButton rb= (RadioButton) radiobutton.getText();
                String s="Hello!!";
                if(((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText()==amb.getText()){
                if(username.getText().toString().equals("ambulance") && password.getText().toString().equals("ambulance")){
                    //correct
                    Toast.makeText(Login.this,"Ambulance LOGIN SUCCESSFUL"+s+((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login.this,Ambulance_homepage.class);
                    startActivity(intent);

                }else
                    //incorrect
                    Toast.makeText(Login.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
                else if(((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText()==hos.getText()) {
                    if(username.getText().toString().equals("hospital") && password.getText().toString().equals("hospital")){
                        //correct
                        Toast.makeText(Login.this,"Hospital LOGIN SUCCESSFUL"+s+((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText(),Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,Hospital_homepage.class);
                        startActivity(intent);

                    }else
                        //incorrect
                        Toast.makeText(Login.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                }
            }



        });
    }

//    public void btnnext123(View view) {
//        Intent intent=new Intent(this,Login.class);
//        startActivity(intent);
//    }
}