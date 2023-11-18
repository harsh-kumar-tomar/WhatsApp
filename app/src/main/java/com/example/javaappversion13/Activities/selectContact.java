package com.example.javaappversion13.Activities;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javaappversion13.Adapters.chatAdapter;
import com.example.javaappversion13.Adapters.contactAdapter;
import com.example.javaappversion13.Domain.structContactView;
import com.example.javaappversion13.Domain.structUser;
import com.example.javaappversion13.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class selectContact extends AppCompatActivity {
    ImageView backbutton ;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TextView noofContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#1F2C34"));

        intialize();
        progressBar.setVisibility(View.VISIBLE);



        data();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void data() {

        ArrayList<structUser> dataitems = new ArrayList<>() ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()) ;

        recyclerView.setLayoutManager(linearLayoutManager);
        contactAdapter adapter = new contactAdapter(dataitems , this);

        recyclerView.setAdapter(adapter);



        FirebaseDatabase root = FirebaseDatabase.getInstance();
        DatabaseReference child = root.getReference("Users");


        child.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.INVISIBLE);

                dataitems.clear();
                for (DataSnapshot a : snapshot.getChildren())
                {
                    structUser user = new structUser();
                    user = a.getValue(structUser.class);

                    assert user != null;
                    user.setUserId(a.getKey());
                    Toast.makeText(selectContact.this, ""+a.getKey(), Toast.LENGTH_SHORT).show();

                    dataitems.add(user);
                    adapter.notifyDataSetChanged();

                }

                noofContacts.setText(dataitems.size()+" contacts");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        adapter.setOnItemClickListener(new contactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(getApplicationContext(), openChat.class);
                intent.putExtra("imageResourceId", dataitems.get(position).getUserProfilePicPath());
                intent.putExtra("profileName", dataitems.get(position).getUserName());
                intent.putExtra("uid", dataitems.get(position).getUserId());

                startActivity(intent);
            }
        });





    }

    private void intialize() {

        backbutton=findViewById(R.id.backbutton);
        recyclerView = findViewById(R.id.recylerView);
        progressBar = findViewById(R.id.progressBar);
        noofContacts = findViewById(R.id.noofContacts);


    }


}