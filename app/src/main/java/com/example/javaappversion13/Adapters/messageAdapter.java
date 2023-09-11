package com.example.javaappversion13.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.R;

import java.util.List;

public class messageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> messages ;

    public messageAdapter(List<String> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messageview, parent , false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).bind(messages.get(position));


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView messagetxtView ;
        public ViewHolder( View itemView) {
            super(itemView);
            messagetxtView = itemView.findViewById(R.id.messagetxtView);

        }
        public void bind(String message)
        {
            messagetxtView.setText(message);
        }
    }
}
