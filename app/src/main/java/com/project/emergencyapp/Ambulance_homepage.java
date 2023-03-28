package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Ambulance_homepage extends AppCompatActivity {

    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_homepage);
        TextView Yname=(TextView) findViewById(R.id.Yname);
        TextView uemail=(TextView) findViewById(R.id.uemail);
        TextView uvno=(TextView) findViewById(R.id.uvno);
//        TextView Yname=(TextView) findViewById(R.id.Yname);

        //        TextView Ycontact=(TextView) findViewById(R.id.Ycontact);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        DocumentReference docRef = db.collection("Ambulance").document(email);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("R1", "DocumentSnapshot data: " + document.getData());
                        Yname.setText((CharSequence) document.get("Name"));
                        uvno.setText((CharSequence) document.get("Vehicle Number"));
                        uemail.setText((CharSequence) document.get("Email"));
//                        Ycontact.setText((Integer) document.get("contact"));
                    } else {
                        Log.d("R", "No such document");
                    }
                } else {
                    Log.d("R2", "get failed with ", task.getException());
                }
            }
        });

    }
}