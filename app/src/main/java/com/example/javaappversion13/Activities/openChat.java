package com.example.javaappversion13.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.javaappversion13.Adapters.messageAdapter;
import com.example.javaappversion13.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class openChat extends AppCompatActivity {
    EditText enterMessage ;
    ImageView enter_to_microphone;
    RecyclerView recyclerView ;
    messageAdapter messageAdapter ;
    List<String> messagesList = new ArrayList<>() ;             //list of messages

    FirebaseAuth auth ;

    ImageView backbutton ;
    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_chat);

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#1F2C34"));

//        Animation bounceOutAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_out);
//        Animation bounceBackAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_back);



        intialize();

        //setting Chat profile image
        String imageResourceId = getIntent().getStringExtra("imageResourceId");
        ImageView imageView = findViewById(R.id.DP); // Replace with your ImageView ID

        Glide.with(getApplicationContext())
                .load(imageResourceId)
                .centerCrop()
                .into(imageView);

        //setting Chat profile Name
        String name = getIntent().getStringExtra("profileName");
        TextView profileName = findViewById(R.id.profileName);
        profileName.setText(name);

        //setting Chat Receiver UID and Sender UID
        String RECEIVER_UID = getIntent().getStringExtra("uid");
        auth = FirebaseAuth.getInstance();
        String SENDER_UID = Objects.requireNonNull(auth.getCurrentUser()).getUid();


        Toast.makeText(this, ""+RECEIVER_UID, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+SENDER_UID, Toast.LENGTH_SHORT).show();




        messagesList.add("hello");

        enterMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    enter_to_microphoneFunction();
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });//this is changing microphone to enter

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });//this is setting the back button



        messageAdapter = new messageAdapter(messagesList) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext() );
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageAdapter);

        enter_to_microphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


    }

    public void sendMessage()
    {
        String messageText = enterMessage.getText().toString();
        if (!messageText.isEmpty()) {
            messagesList.add(messageText);
            messageAdapter.notifyDataSetChanged();
            enterMessage.setText("");
            // Scroll to the last message
            recyclerView.smoothScrollToPosition(messagesList.size() - 1);
        }

    }

    void enter_to_microphoneFunction ()
    {
        if (enterMessage.getText().toString().isEmpty())
        {
           enter_to_microphone.setImageResource(R.drawable.baseline_mic_24);

        }else {
            enter_to_microphone.setImageResource(R.drawable.send);
        }
    }



    void intialize ()
    {
        enterMessage = findViewById(R.id.enterMessage);
        enter_to_microphone = findViewById(R.id.enter_to_microphone) ;
        toolbar = findViewById(R.id.toolbar);
        backbutton = findViewById(R.id.backbutton);

        recyclerView = findViewById(R.id.messageRecyclerView);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.option1_newGroup) {
            // Handle Option 1 click
            return true;
        } else if (itemId == R.id.option2_settings) {
            // Handle Option 2 click
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu, popupMenu.getMenu());


        // Set item click listeners for the popup menu items
        popupMenu.setOnMenuItemClickListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.option1_newGroup) {
                // Handle Option 1 click
                return true;
            } else if (itemId == R.id.option2_settings) {
                // Handle Option 2 click
                return true;
            } else {
                return false;
            }
        });

        popupMenu.show();
    }

    public void onOverflowButtonClick(View view) {
        showPopupMenu(view);
    }

}