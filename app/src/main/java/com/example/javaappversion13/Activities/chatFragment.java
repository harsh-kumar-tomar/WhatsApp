package com.example.javaappversion13.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javaappversion13.Activities.openChat;
import com.example.javaappversion13.Adapters.chatAdapter;
import com.example.javaappversion13.Domain.structChatView;
import com.example.javaappversion13.R;

import java.util.ArrayList;


public class chatFragment extends Fragment {


    public chatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);



        ArrayList<structChatView> dataStream = new ArrayList<>();

        dataStream.add(new structChatView(R.drawable.profile1, "Aries", "so when are you coming ?", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile2, "Thor", "i am son of odin", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile3, "Hemdall", "in your service", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile2, "Hela", "i am goddess", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile5, "kusboo", "good", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile6, "Yulgar", "i am a journalist", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile7, "kanata", "if you stand , you are on your feet", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile8, "light", "tommarrow is exam", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile1, "L", "light is studying", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile2, "Bruce wayne", "do you bleed", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile3, "CLark", "save martha", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile4, "billi", "shazam", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile5, "Tenth Adam", "send them all", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile6, "Hawk Man", "where are you atom smasher ?", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile7, "Dr. Fate", "kneel or die", "Yesterday"));
        dataStream.add(new structChatView(R.drawable.profile8, "Tony", "tomarrow is party", "Yesterday"));


        RecyclerView recyclerView = view.findViewById(R.id.recylerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        chatAdapter recycleradapter = new chatAdapter(requireContext(), dataStream);

        recyclerView.setAdapter(recycleradapter);


        recycleradapter.setOnItemClickListener(new chatAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), openChat.class);
                intent.putExtra("imageResourceId", dataStream.get(position).getProfileImage());
                intent.putExtra("profileName", dataStream.get(position).getProfileName());

                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }




}