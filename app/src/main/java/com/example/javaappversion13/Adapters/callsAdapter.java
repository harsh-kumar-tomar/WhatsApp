package com.example.javaappversion13.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.Domain.structCallsView;
import com.example.javaappversion13.R;

import java.util.ArrayList;

public class callsAdapter extends RecyclerView.Adapter<callsAdapter.myViewholder> {

    ArrayList<structCallsView> datalist ;
    Context context ;

    public callsAdapter(ArrayList<structCallsView> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.callview , parent , false);
        myViewholder v = new myViewholder(view);

        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
            holder.DP.setImageResource(datalist.get(position).getProfileImage());
            holder.profileName.setText(datalist.get(position).getProfileName());
            holder.dateTime.setText(datalist.get(position).getDateTime());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder {

        ImageView DP  ;
        TextView profileName , dateTime ;

        public myViewholder(@NonNull View itemView) {
            super(itemView);

            DP = itemView.findViewById(R.id.DP);
            profileName = itemView.findViewById(R.id.profileName);
            dateTime = itemView.findViewById(R.id.dateTime);


        }
    }

}
