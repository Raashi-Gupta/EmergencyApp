package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

///**
// * A simple {@link Fragment} subclass.
// // * Use the {@link Hospital_register_fragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Hospital_register_fragment extends Fragment {

    EditText HNamein,hconin,uidin,addhin,emailin,passhin,passchin;
    RadioButton gbtn, pbtn;
    Button reg;
    public Hospital_register_fragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hospital_register_fragment,container,false);
        HNamein=v.findViewById(R.id.hnamein);
        hconin=v.findViewById(R.id.hconin);
        uidin=v.findViewById(R.id.uidin);
        addhin=v.findViewById(R.id.addhin);
        emailin=v.findViewById(R.id.emailin);
        passhin=v.findViewById(R.id.passhin);
        passchin=v.findViewById(R.id.passhcin);
        reg=v.findViewById(R.id.sub);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1)
            {
                finderr();
            }
        });
        return v;
    }
    void finderr()
    {
        String name=HNamein.getText().toString();
        String scontact=hconin.getText().toString();
        int contact=Integer.parseInt(scontact);
        String suid=uidin.getText().toString();
        int uid=Integer.parseInt(suid);
        String address=addhin.getText().toString();
        String email=emailin.getText().toString();
        String password=passhin.getText().toString();
        String cpassword=passchin.getText().toString();
        if(name=="")
        {
//            Toast.makeText(getActivity(),"Field cant be empty",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(name.length()<2)
        {
//            Toast.makeText(getActivity(),"Invalid name",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(scontact=="")
        {
//            Toast.makeText(getActivity(),"Field cant be empty",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(scontact.length()!=10)
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
//            Toast.makeText(getActivity(),"Invalid contact number ",Toast.LENGTH_LONG).show();
        }
        else if(suid=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(address=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(email=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(password=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(cpassword=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(password!=cpassword)
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else
        {
            register(email,password,name,contact,uid,address);
        }
    }
    private void register(String email,String password,String name,int contact,int uid,String address)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener((Executor) Hospital_register_fragment.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getActivity(),"Registered Successfully",Toast.LENGTH_LONG).show();

                    FirebaseUser firebaseuser=auth.getCurrentUser();
                    firebaseuser.sendEmailVerification();
                    Map<String,Object> Hospitals=new HashMap<>();
                    Hospitals.put("address",address);
                    Hospitals.put("contact_number",contact);
                    Hospitals.put("email",email);
                    Hospitals.put("name",name);
                    Hospitals.put("password",password);
                    db.collection("users")
                            .add(Hospitals)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getActivity(),"Data added Successfully",Toast.LENGTH_LONG).show();

                                }
                            });
                    //Opem User Profi;e after successful Registeration
                    Intent intent=new Intent(getActivity(),Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
    }




































//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;



//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Hospital_register_fragment.
//     */
    // TODO: Rename and change types and number of parameters
//    public static Hospital_register_fragment newInstance(String param1, String param2) {
//        Hospital_register_fragment fragment = new Hospital_register_fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override



}