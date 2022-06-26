package com.example.krushi_app1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Expandfragment extends Fragment {


    String name,owner,rent,status,image,phone;
    public Expandfragment() {
        // Required empty public constructor
    }

    public Expandfragment(String name,String owner,String rent,String status,String image,String phone) {

        this.name=name;
        this.owner=owner;
        this.rent=rent;
        this.status=status;
        this.image=image;
        this.phone=phone;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_expandfragment, container, false);
        ImageView imageholder = view.findViewById(R.id.imageholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView ownerholder = view.findViewById(R.id.ownerholder);
        TextView rentholder = view.findViewById(R.id.Rentholder);
        TextView statusholder = view.findViewById(R.id.statusholder);
        TextView phoneholder = view.findViewById(R.id.phoneholder);
        nameholder.setText(name);
        ownerholder.setText(owner);
        rentholder.setText(rent);
        statusholder.setText(status);
        phoneholder.setText(phone);
        Glide.with(getContext()).load(image).into(imageholder);

        return view;
    }
    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new Expandfragment()).addToBackStack(null).commit();
    }
}