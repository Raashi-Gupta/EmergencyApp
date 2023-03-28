package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
//    public void loginpg(View view) {
//        Intent intent=new Intent(this,Login.class);
//        startActivity(intent);
//    }
//    public void registerpg(View view) {
//        Intent intent=new Intent(this,Registration.class);
//        startActivity(intent);
//    }

//    All the fields and button from frontend
    EditText uname,ucontact,uemail;
    RadioGroup utoa;
    RadioButton aot_ra,aot_fa,others;
    Button notify;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer,menu);
//       Getting all the values
        uname=findViewById(R.id.uname);
        ucontact=findViewById(R.id.ucontact);
        uemail=findViewById(R.id.uemail);
        aot_fa=findViewById(R.id.aot_fa);
        aot_ra=findViewById(R.id.aot_ra);
        notify=findViewById(R.id.button_notify);
        return true;
    }













//   Menu button at Menu Bar
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
}