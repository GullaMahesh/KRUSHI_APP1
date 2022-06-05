package com.example.krushi_app1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class logout_Fragment extends Fragment {



    public logout_Fragment() {
        // Required empty public constructor
    }

    FirebaseAuth mAuth;
Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_logout_, container, false);
        mAuth = FirebaseAuth.getInstance();
        b=view.findViewById(R.id.But1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Fragment homeFrag=new home_fragment();
                FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.container,homeFrag).commit();
            }
        });
        return view;
    }
}