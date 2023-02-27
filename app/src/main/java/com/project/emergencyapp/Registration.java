package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Registration extends AppCompatActivity {
    Button hosp_reg,amb_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Ambulance_register_fragment amb_frag=new Ambulance_register_fragment();
        loadFragment(amb_frag);
        hosp_reg=findViewById(R.id.hos_reg);
        amb_reg=findViewById(R.id.amb_reg);

        amb_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ambulance_register_fragment amb_frag=new Ambulance_register_fragment();
                loadFragment(amb_frag);
            }
        });
        hosp_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospital_register_fragment hos_frag=new Hospital_register_fragment();
                loadFragment(hos_frag);
            }
        });
    }


    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

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
}