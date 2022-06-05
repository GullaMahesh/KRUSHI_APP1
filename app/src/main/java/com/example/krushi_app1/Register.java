package com.example.krushi_app1;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class Register extends Fragment {



    public Register() {
        // Required empty public constructor
    }

    TextInputLayout t1,t2;
    ProgressBar bar;
    Button b1;
    private FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        t1=view.findViewById(R.id.email);
        t2=view.findViewById(R.id.pwd);
        bar=view.findViewById(R.id.progressBar);
        b1=view.findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=t1.getEditText().getText().toString();
                String password=t2.getEditText().getText().toString();
                mAuth=FirebaseAuth.getInstance();
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    bar.setVisibility(View.INVISIBLE);
                                    t1.getEditText().setText("");
                                   t2.getEditText().setText("");

                                    Log.d("134", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    bar.setVisibility(View.INVISIBLE);
                                    t1.getEditText().setText("");
                                    t2.getEditText().setText("");
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), task.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });
        return view;

    }
}