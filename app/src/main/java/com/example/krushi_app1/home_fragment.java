package com.example.krushi_app1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

//import androidx.appcompat.widget.SearchView;
public class home_fragment extends Fragment {


Button b1;
Button b2;
RecyclerView recview;
adapter adapte;
    private FirebaseAuth mAuth;
    public home_fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //    ImageView s= (ImageView)findViewById(R.id.image_view);
    //    s.setY(0);
   //     s.setX(-100);
        View view=inflater.inflate(R.layout.fragment_home_fragment, container, false);
        b2=view.findViewById(R.id.Button2);
        b1=view.findViewById(R.id.Button1);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            b1.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
        } else {



        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment registerFrag = new Register();
                FragmentTransaction fm=getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,registerFrag);
                fm.addToBackStack("home_fragment");
                fm.commit();

            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment loginFrag=new Login();
                FragmentTransaction fm1=getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.container,loginFrag);
                fm1.addToBackStack("home_fragment");
                fm1.commit();
            }
        });



        //Recycler View

        recview=(RecyclerView)view.findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                     .setQuery(FirebaseDatabase.getInstance().getReference(), model.class)
                        .build();

       adapte=new adapter(options);
       recview.setAdapter(adapte);
        setHasOptionsMenu(true);
    return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapte.startListening();
    }


    @Override
    public void onStop() {
        super.onStop();
        adapte.stopListening();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_manu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchview= (SearchView) item.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processearch(s);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void processearch(String s)
    {
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().orderByChild("eqname").startAt(s).endAt(s+"\uf8ff"), model.class)
                        .build();
        adapte=new adapter(options);
        adapte.startListening();
        recview.setAdapter(adapte);

    }

}