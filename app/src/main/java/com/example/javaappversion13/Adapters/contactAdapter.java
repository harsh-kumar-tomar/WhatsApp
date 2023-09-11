package com.example.javaappversion13.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.Domain.structContactView;
import com.example.javaappversion13.R;

import java.util.ArrayList;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.ContactViewHolder> {

    ArrayList <structContactView> dataList ;
    contactAdapter.OnItemClickListener onItemClickListener ;
    Context context ;

    public contactAdapter(ArrayList<structContactView> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(contactAdapter.OnItemClickListener listener) {
        this.onItemClickListener =  listener;
    }

    @NonNull
    @Override
    public contactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.contactview , parent , false);
       ContactViewHolder contactViewHolder = new ContactViewHolder(view);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull contactAdapter.ContactViewHolder holder, int position) {

        holder.profileImage.setImageResource(dataList.get(position).getProfileImage());
        holder.profileName.setText(dataList.get(position).getProfileName());
        holder.profileDescription.setText(dataList.get(position).getProfileDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage ;
        TextView profileName ;
        TextView profileDescription ;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.DP);

            profileDescription = itemView.findViewById(R.id.profileMessage);
            profileName = itemView.findViewById(R.id.profileName);


        }
    }
}
