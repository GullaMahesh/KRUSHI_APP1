package com.example.krushi_app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class adapter extends FirebaseRecyclerAdapter<model,adapter.myviewholder>
{

    public adapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getEqname());
        holder.owner.setText(model.getEqowner());
        holder.Rent.setText(model.getEqrent());
        holder.status.setText(model.getStatus());
        Glide.with(holder.img1.getContext()).load(model.getPimage()).into(holder.img1);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView name;
        TextView owner;
        TextView Rent;
        TextView status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            name=itemView.findViewById(R.id.name);
            owner=itemView.findViewById(R.id.owner);
            Rent=itemView.findViewById(R.id.Rent);
            status=itemView.findViewById(R.id.status);
        }
    }
}
