package com.example.krushi_app1;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.Random;


public class Addequip_Fragment extends Fragment {



    public Addequip_Fragment() {
        // Required empty public constructor
    }


EditText eqname;
    EditText eqcompany;
    EditText eqowner;
    EditText eqrent;
    EditText address;
    EditText phone;
    EditText email;
    EditText status;
    Button b;
    Button b2;
    ImageView img;
    Uri filepath;
    Bitmap bitmap;
   //String upload;
     FirebaseDatabase db= FirebaseDatabase.getInstance();
     DatabaseReference root = db.getReference();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_addequip_, container, false);
        img=view.findViewById(R.id.img);
        b=view.findViewById(R.id.submit);
        b2=view.findViewById(R.id.browse);
        eqname=view.findViewById(R.id.t1);
        eqcompany=view.findViewById(R.id.t2);
        eqowner=view.findViewById(R.id.t3);
        eqrent=view.findViewById(R.id.t4);
        address=view.findViewById(R.id.t5);
        phone=view.findViewById(R.id.t6);
        email=view.findViewById(R.id.t7);
        status=view.findViewById(R.id.t8);
       b2.setOnClickListener(
               new View.OnClickListener() {
          @Override
          public void onClick(View view) {

               Dexter.withContext(getActivity())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse response) {
                               Intent intent = new Intent(Intent.ACTION_PICK);
                               intent.setType("image/*");
                               startActivityForResult(Intent.createChooser(intent,"Please select Image"),1);

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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super method removed
        if(requestCode==1  && resultCode==RESULT_OK)
        {

                filepath = data.getData();
                try{
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filepath);
                img.setImageBitmap(bitmap);
                }catch (Exception ex)
                {

                }
        }
        //Uri returnUri;
        //returnUri = data.getData();

}
    private void uploadtofirebase()
    {
        final ProgressDialog dialog=new ProgressDialog(getActivity());
        dialog.setTitle("File Uploader");
        dialog.show();



        FirebaseStorage storage=FirebaseStorage.getInstance();
        final StorageReference uploader=storage.getReference("Image1"+new Random().nextInt(50));

        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri){

                                dialog.dismiss();
                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                                DatabaseReference root=db.getReference();

                                dataholder obj=new dataholder(eqname.getText().toString(),eqcompany.getText().toString(),eqowner.getText().toString(),eqrent.getText().toString(),address.getText().toString(),phone.getText().toString(),email.getText().toString(),status.getText().toString(),uri.toString());
                                root.child(phone.getText().toString()).setValue(obj);

                                eqname.setText("");
                                eqcompany.setText("");
                                eqowner.setText("");
                                eqrent.setText("");
                                address.setText("");
                                phone.setText("");
                                email.setText("");
                                status.setText("");
                                img.setImageResource(R.drawable.ic_launcher_background);
                                Toast.makeText(getActivity(),"uploaded",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        dialog.setMessage("Uploaded : "+(int)percent+"%");
                    }
                });

    }

}


