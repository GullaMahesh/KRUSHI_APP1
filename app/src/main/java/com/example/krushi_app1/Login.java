package com.example.krushi_app1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends Fragment {



    public Login() {
        // Required empty public constructor
    }
    TextInputLayout t1,t2;
    ProgressBar bar;
    FirebaseAuth mAuth;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        t1=view.findViewById(R.id.email_login);
        t2=view.findViewById(R.id.pwd_login);
        bar=view.findViewById(R.id.progressBar3_login);
        b=view.findViewById(R.id.Button3);
        mAuth = FirebaseAuth.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.setVisibility(View.VISIBLE);
                String email=t1.getEditText().getText().toString();
                String password=t2.getEditText().getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    bar.setVisibility(View.INVISIBLE);
                                    Fragment homeFrag=new home_fragment();
                                    FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
                                    fm1.replace(R.id.container,homeFrag).commit();

                                } else
                                {
                                    bar.setVisibility(View.INVISIBLE);
                                    t1.getEditText().setText("");
                                    t2.getEditText().setText("");
                                    Toast.makeText(getActivity(),"Invalid email/password",Toast.LENGTH_LONG).show();
                                }

                                // ...
                            }
                        });
            }
        });
        return view;
    }
}