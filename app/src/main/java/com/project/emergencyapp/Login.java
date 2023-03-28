package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    EditText username,upassword;
    RadioGroup radiogrp;
    RadioButton amb, hos;
    Button loginbtn;
    String Uid;
//    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        EditText name=findViewById(R.id.userid);
        username = findViewById(R.id.userid);
         upassword = findViewById(R.id.password);
         radiogrp= findViewById(R.id.radiogrp);
         loginbtn =  findViewById(R.id.login_button);
         amb= findViewById(R.id.amb_bttn);
         hos= findViewById(R.id.hos_bttn);
//        int radioId=radiogrp.getCheckedRadioButtonId();
//        RadioButton radiobutton=((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId()));
        //admin and admin

//        String email="raashigupta2504@gmail.com";
//        String password="123456";
        loginbtn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String email=username.getText().toString();
                String password=upassword.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = auth.getCurrentUser();
                                    Uid=user.getUid();
                                    if(((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText()==amb.getText()){
//                                        DocumentReference df=db.collection("Ambualnce").document(Uid);
                                        db.collection("Ambulance").whereEqualTo("Email",email).limit(1).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                try{
                                                if(task.isSuccessful())
                                                {
//                                                    updateUI(user,"Ambulance");
                                                    QuerySnapshot ds=task.getResult();
                                                    if(!ds.isEmpty())
                                                    {
                                                        updateUI(user,"Ambulance",email);
                                                    }
                                                    else{
                                                        Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }}
                                                catch (Exception e)
                                                {
                                                    Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                                    }
                                    else if(((RadioButton)findViewById(radiogrp.getCheckedRadioButtonId())).getText()==hos.getText()) {
//                                        DocumentReference df=db.collection("Hospitals").document(Uid);
                                        db.collection("Hospitals").whereEqualTo("email",email).limit(1).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                if(task.isSuccessful())
                                                {
//                                                    DocumentSnapshot ds=task.getResult();
                                                    QuerySnapshot ds=task.getResult();
                                                    if(!ds.isEmpty())
                                                    {
                                                        updateUI(user,"Hospital",email);
                                                    }
                                                    else{
                                                        Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        });
                                    }

                                }
                                else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

//                RadioButton rb= (RadioButton) radiobutton.getText();

            }



        });
    }
    public void updateUI(FirebaseUser account, String s,String email){

        if(account != null) {
            if (s == "Ambulance") {
                Toast.makeText(this, "You Signed In successfully", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this, Ambulance_homepage.class);
                intent.putExtra("email",email);
                startActivity(intent);

            }
            else if(s == "Hospital")
            {
                Toast.makeText(this, "You Signed In successfully", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(this, Hospital_homepage.class);
                intent.putExtra("email",email);
                startActivity(intent);

            }
        }else {
            Toast.makeText(this,"You Didn't signed in",Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_login)
        {
            Intent intent=new Intent(this,Login.class);
            startActivity(intent);
            return true;
        }
        else if(id==R.id.nav_register)
        {
            Intent intent=new Intent(this,Registration.class);
            startActivity(intent);
            return true;
        }
        else if(id==R.id.nav_emergency)
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//    public void btnnext123(View view) {
//        Intent intent=new Intent(this,Login.class);
//        startActivity(intent);
//    }
}