package com.project.emergencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Ambulance_register_fragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Ambulance_register_fragment extends Fragment {


        EditText dnamein,dconin,vnumin,userin,passin,passcin;
        Button reg;
        String userID;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    public Ambulance_register_fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ambulance_register_fragment, container, false);
        dnamein=v.findViewById(R.id.dnamein);
        dconin=v.findViewById(R.id.dconin);
        vnumin=v.findViewById(R.id.vnumin);
        userin=v.findViewById(R.id.userin);
        passin=v.findViewById(R.id.passin);
        passcin=v.findViewById(R.id.passcin);
        reg=v.findViewById(R.id.sub);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1)
            {

                finderr();
            }
        });
        return v;
    }



//    To read all variables in string form and validating the fields
    void finderr()
    {
        String name=dnamein.getText().toString();
        String scontact=dconin.getText().toString();
        long contact=Long.parseLong(scontact);
        String vehicle=vnumin.getText().toString();
        String email=userin.getText().toString();
        String password=passin.getText().toString();
        String cpassword=passcin.getText().toString();




//        Validating Name field
        if(name=="")
        {
//            Toast.makeText(getActivity(),"Field cant be empty",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(name.length()<2)
        {
//            Toast.makeText(getActivity(),"Invalid name",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed0",Toast.LENGTH_LONG).show();
        }




//        Validating Contact field
        else if(scontact=="")
        {
//            Toast.makeText(getActivity(),"Field cant be empty",Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(),"Registration Failed",Toast.LENGTH_LONG).show();
        }
        else if(scontact.length()!=10)
        {
            Toast.makeText(getActivity(),"Registration Failed1",Toast.LENGTH_LONG).show();
//            Toast.makeText(getActivity(),"Invalid contact number ",Toast.LENGTH_LONG).show();
        }



//      Validating Vehicle number
        else if(vehicle=="")
        {
            Toast.makeText(getActivity(),"Registration Failed2",Toast.LENGTH_LONG).show();
        }



//      Validating Email
        else if(email=="")
        {
            Toast.makeText(getActivity(),"Registration Failed3",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(getActivity(),"Registration Failed3",Toast.LENGTH_LONG).show();
        }




//       Validating Password field
        else if(password=="")
        {
            Toast.makeText(getActivity(),"Registration Failed4",Toast.LENGTH_LONG).show();
        }





//      Validating Confirm Password
        else if(cpassword=="")
        {
            Toast.makeText(getActivity(),"Registration Failed5",Toast.LENGTH_LONG).show();
        }
        else if(password==cpassword)
        {
            Toast.makeText(getActivity(),"Registration Failed6",Toast.LENGTH_LONG).show();
        }



//        Validation Succesfull Updating and registering the user
        else
        {
            register(email,password,name,contact,vehicle);
        }
    }







    private void register(String email,String password,String name,Long contact,String vehicle)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser firebaseuser=auth.getCurrentUser();
//                    firebaseuser.sendEmailVerification();//Sending Verification mail
                    userID=auth.getCurrentUser().getUid();
                    DocumentReference df=db.collection("Ambulance").document(email);
//                    Mapping the details of the user and storing it int db
                    Map<String,Object> user=new HashMap<>();
                    user.put("contact",contact);
                    user.put("Email",email);
                    user.put("Name",name);
                    user.put("Password",password);
                    user.put("Vehicle Number",vehicle);
                   df.set(user)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    //Opem User Profile after successful Registeration
                                    Toast.makeText(getActivity(),"Registered Successfully",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(getActivity(),Login.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    getActivity().finish();

                                }
                            });

                }
                else {
                    Toast.makeText(getActivity(),"Email id already registered",Toast.LENGTH_LONG).show();
                }
            }
        });
    }









//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Ambulance_register_fragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Ambulance_register_fragment newInstance(String param1, String param2) {
//        Ambulance_register_fragment fragment = new Ambulance_register_fragment();
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


}