package com.example.krushi_app1;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class Addequip_Fragment extends Fragment {



    public Addequip_Fragment() {
        // Required empty public constructor
    }


EditText t1;
    EditText t2;
    EditText t3;
    EditText t4;
    EditText t5;
    EditText t6;
    EditText t7;
    EditText t8;
    Button b;
    Button b2;
    ImageView img;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_addequip_, container, false);
        img=view.findViewById(R.id.img);
        b=view.findViewById(R.id.submit);
        b2=view.findViewById(R.id.browse);
        t1=view.findViewById(R.id.t1);
        t2=view.findViewById(R.id.t2);
        t3=view.findViewById(R.id.t3);
        t4=view.findViewById(R.id.t4);
        t5=view.findViewById(R.id.t5);
        t6=view.findViewById(R.id.t6);
        t7=view.findViewById(R.id.t7);
        t8=view.findViewById(R.id.t8);
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Dexter.withContext(getActivity())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse response) {
                               Intent intent = new Intent(Intent.ACTION_PICK);
                               intent.setType("image/*");

                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse response) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                               token.continuePermissionRequest();
                           }
                       }).check();

           }
       });

        return view;
    }
}
