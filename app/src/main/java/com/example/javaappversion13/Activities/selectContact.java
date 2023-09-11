package com.example.javaappversion13.Activities;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.javaappversion13.Adapters.chatAdapter;
import com.example.javaappversion13.Adapters.contactAdapter;
import com.example.javaappversion13.Domain.structContactView;
import com.example.javaappversion13.R;

import java.util.ArrayList;
import java.util.List;

public class selectContact extends AppCompatActivity {
    ImageView backbutton ;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#1F2C34"));

        intialize();

        data();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void data() {

        ArrayList<structContactView> dataitems = new ArrayList<>() ;
        dataitems.add(new structContactView(R.drawable.profile1 , "Juice" , "haathi madarchod"));
        dataitems.add(new structContactView(R.drawable.profile2 , "Piyush ki balls" , "thod dunga apna"));
        dataitems.add(new structContactView(R.drawable.profile3 , "Anna" , "busy"));
        dataitems.add(new structContactView(R.drawable.profile4 , "Finix" , "."));
        dataitems.add(new structContactView(R.drawable.profile5 , "Alaadin" , "Naam toh suna hoga"));
        dataitems.add(new structContactView(R.drawable.profile6 , "Ali" , "naam me kya rkha h"));
        dataitems.add(new structContactView(R.drawable.profile7 , "Jasmine" , "i love piyush"));
        dataitems.add(new structContactView(R.drawable.profile8 , "Ekta" , "anekta me ekta"));
        dataitems.add(new structContactView(R.drawable.profile1 , "Anita" , "chugli"));
        dataitems.add(new structContactView(R.drawable.profile2 , "Babita" , "khadush"));
        dataitems.add(new structContactView(R.drawable.profile3 , "Sangita" , "sayog"));
        dataitems.add(new structContactView(R.drawable.profile4 , "Piyush ki Dolly" , "oe hoe...."));
        dataitems.add(new structContactView(R.drawable.profile5 , "Ellaa" , "ellaa ki jawani"));
        dataitems.add(new structContactView(R.drawable.profile6 , "Madumata" , "american ki aulad"));
        dataitems.add(new structContactView(R.drawable.profile7 , "Money" , "paisa paisa money money"));
        dataitems.add(new structContactView(R.drawable.profile8 , "Piyush ki lugaai" , "ompho...."));
        dataitems.add(new structContactView(R.drawable.profile1 , "Piyush's harsh" , "paddaii"));
        dataitems.add(new structContactView(R.drawable.profile2 , "Gopal" , "at school"));
        dataitems.add(new structContactView(R.drawable.profile3 , "Krishna" , "at vrindavan"));
        dataitems.add(new structContactView(R.drawable.profile4 , "Bihari" , "in bihar"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()) ;

        recyclerView.setLayoutManager(linearLayoutManager);
        contactAdapter adapter = new contactAdapter(dataitems , this);

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new contactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), openChat.class);
                intent.putExtra("imageResourceId", dataitems.get(position).getProfileImage());
                intent.putExtra("profileName", dataitems.get(position).getProfileName());

                startActivity(intent);
            }
        });





    }

    private void intialize() {

        backbutton=findViewById(R.id.backbutton);
        recyclerView = findViewById(R.id.recylerView);


    }


}