package com.example.javaappversion13.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.R;
import com.example.javaappversion13.Domain.structChatView;

import java.util.ArrayList;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.myViewHolder> {
     ArrayList<structChatView> datalist ;

    OnItemClickListener onItemClickListener ;
     Context context;

    public chatAdapter(Context context, ArrayList<structChatView> datalist)
    {
        this.context = context ;
        this.datalist = datalist ;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener =  listener;
    }



    public myViewHolder onCreateViewHolder( ViewGroup parent, int viewType) { //inflater From xml file to actual view

        View v = LayoutInflater.from(context).inflate(R.layout.chatview , parent , false);

        myViewHolder m = new myViewHolder(v) ;

        return  m ;

    }


    public void onBindViewHolder( myViewHolder holder, int position) {

        holder.img.setImageResource(datalist.get(holder.getAdapterPosition()).getProfileImage());
        holder.name.setText(datalist.get(holder.getAdapterPosition()).getProfileName());
        holder.lastmesaage.setText(datalist.get(holder.getAdapterPosition()).getProfileLastMessage());
        holder.date.setText(datalist.get(holder.getAdapterPosition()).getProfileLastSeen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.getAdapterPosition());
                }
            }
        });



    }




    public int getItemCount() {
        return datalist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView img ;
        TextView name , lastmesaage , date ;

        public myViewHolder( View itemView) {       //constructor for viewholder
            super(itemView);
            img = itemView.findViewById(R.id.DP);
            name = itemView.findViewById(R.id.chatName);
            lastmesaage = itemView.findViewById(R.id.latestMessage);
            date = itemView.findViewById(R.id.lastmessageDate);


        }
    }
}
