package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

///**
// * A simple {@link Fragment} subclass.
// // * Use the {@link Hospital_register_fragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Hospital_register_fragment extends Fragment {

    EditText HNamein,hconin,uidin,addhin,emailin,passhin,passchin,latitude,longitude;
    RadioButton gbtn, pbtn,srbtn;
    String userID;
    RadioGroup toh;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
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
        latitude=v.findViewById(R.id.latin);
        longitude=v.findViewById(R.id.lonin);
//        Radio Group gor type of hospital
//        toh=v.findViewById(R.id.toh);
//        gbtn=v.findViewById(R.id.gbtn);
//        pbtn=v.findViewById(R.id.pbtn);
        final int[] s_toh_id = new int[1];

//        if(toh.getCheckedRadioButtonId()== 0)
//        {
//            s_toh_id=toh.getCheckedRadioButtonId();
//            srbtn=(RadioButton)v.findViewById(s_toh_id);
//        }
//        Checklist for different type of facilities
        checkBox1=v.findViewById(R.id.checkBox1);
        checkBox2=v.findViewById(R.id.checkBox2);
        checkBox3=v.findViewById(R.id.checkBox3);
        checkBox4=v.findViewById(R.id.checkBox4);
        checkBox5=v.findViewById(R.id.checkBox5);

        reg=v.findViewById(R.id.sub);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1)
            {
//                if(toh.getCheckedRadioButtonId()== -1)
//                {
//                    Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    s_toh_id[0] =toh.getCheckedRadioButtonId();
//                    srbtn=(RadioButton)v.findViewById(s_toh_id[0]);
//
//                }
                finderr();
            }
        });
        return v;
    }
    void finderr()
    {
//        String toh=srbtn.getText().toString();
        List<String> healthcare=new ArrayList<String>();
        if(checkBox1.isChecked())
        {
            healthcare.add(checkBox1.getText().toString());
        }
        if(checkBox2.isChecked())
        {
            healthcare.add(checkBox2.getText().toString());
        }
        if(checkBox3.isChecked())
        {
            healthcare.add(checkBox3.getText().toString());
        }
        if(checkBox4.isChecked())
        {
            healthcare.add(checkBox4.getText().toString());

        }
        if(checkBox5.isChecked())
        {
            healthcare.add(checkBox5.getText().toString());
        }
//        String s_toh=srbtn.getText().toString();

        String name=HNamein.getText().toString();
        String scontact=hconin.getText().toString();
        Long contact=Long.parseLong(scontact);
        String suid=uidin.getText().toString();
        int uid=Integer.parseInt(suid);
        String s_lat=latitude.getText().toString();
        String s_lon=longitude.getText().toString();
        double lat=Double.parseDouble(s_lat);
        double lon=Double.parseDouble(s_lon);
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
        else if (s_lat=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if (s_lon=="")
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
//        else if (s_toh=="")
//        {
//            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
//        }
        else if(healthcare.isEmpty())
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
        else if(password==cpassword)
        {
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else
        {
            register(email,password,name,contact,uid,address,healthcare,lat,lon);
        }
    }




    private void register(String email,String password,String name,Long contact,int uid,String address,List<String> healthcare,double lat,double lon)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
//                    Toast.makeText(getActivity(),"Registered Successfully",Toast.LENGTH_LONG).show();

                    FirebaseUser firebaseuser=auth.getCurrentUser();
//                    firebaseuser.sendEmailVerification();
                    userID=auth.getCurrentUser().getUid();
                    DocumentReference df=db.collection("Hospitals").document(email);
                    Map<String,Object> user=new HashMap<>();
                    user.put("address",address);
                    user.put("contact_number",contact);
                    user.put("email",email);
                    user.put("name",name);
                    user.put("password",password);
                    user.put("hospital_type",toh);
                    user.put("health_care_type",healthcare);
                    user.put("hospital_type",toh);
                    user.put("Location", new GeoPoint(lat,lon));
                    df.set(user)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity(),"Registered Successfully",Toast.LENGTH_LONG).show();
                                    //Opem User Profi;e after successful Registeration
                                    Intent intent=new Intent(getActivity(),Login.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    getActivity().finish();
                                }
                            });

                }
                else
                {
                    Toast.makeText(getActivity(),"Emailid already registered",Toast.LENGTH_LONG).show();
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