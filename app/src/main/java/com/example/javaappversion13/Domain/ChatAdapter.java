package com.example.javaappversion13.Domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Objects;

public class ChatAdapter extends RecyclerView.Adapter {

     Context context;
     ArrayList<MessageModel> messageModelArrayList;

    final private int VIEW_TYPE_SENDER = 1;
    final private int VIEW_TYPE_RECEIVER = 2;
    final String SENDER_UID = FirebaseAuth.getInstance().getUid();


    public ChatAdapter(Context context, ArrayList<MessageModel> messageModelArrayList) {
        this.context = context;
        this.messageModelArrayList = messageModelArrayList;
    }

    @Override
    public int getItemViewType(int position) {

        if (Objects.equals(messageModelArrayList.get(position).getUID(), SENDER_UID ))
        {
            return VIEW_TYPE_SENDER;
        }else {
            return VIEW_TYPE_RECEIVER;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_SENDER)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_message_view, parent , false);
            return new SenderViewholder(view);

        }else {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_message_view, parent , false);
            return new ReceiverViewholder(view);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MessageModel messageModel = messageModelArrayList.get(position);

        if (holder.getClass() == SenderViewholder.class)
        {
            ((SenderViewholder) holder).senderMessage.setText(messageModel.getMessage());
            ((SenderViewholder) holder).senderTimeStamp.setText(messageModel.getTimeStamp());

        }else {

            ((ReceiverViewholder)holder).receiverMessage.setText(messageModel.getMessage());
            ((ReceiverViewholder)holder).receiverTimeStamp.setText(messageModel.getTimeStamp());
        }



    }

    @Override
    public int getItemCount() {
        return messageModelArrayList.size() ;
    }

    public class ReceiverViewholder extends RecyclerView.ViewHolder {

        TextView receiverMessage ;
        TextView receiverTimeStamp ;

        public ReceiverViewholder(@NonNull View itemView) {
            super(itemView);

            receiverMessage = itemView.findViewById(R.id.receiverMessage);
            receiverTimeStamp = itemView.findViewById(R.id.receiverTimeStamp);

        }
    }

    public class SenderViewholder extends RecyclerView.ViewHolder {

        TextView senderMessage ;
        TextView senderTimeStamp ;

        public SenderViewholder(@NonNull View itemView) {
            super(itemView);

            senderMessage = itemView.findViewById(R.id.senderMessage);
            senderTimeStamp = itemView.findViewById(R.id.senderTimeStamp);

        }
    }
}
