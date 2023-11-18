package com.example.javaappversion13.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.ViewCompat;
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


        RecyclerView recyclerView = view.findViewById(R.id.recylerView);
//        ViewCompat.setNestedScrollingEnabled(recyclerView, false);


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