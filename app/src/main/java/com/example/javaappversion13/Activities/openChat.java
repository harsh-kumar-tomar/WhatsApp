package com.example.javaappversion13.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javaappversion13.Adapters.messageAdapter;
import com.example.javaappversion13.R;

import java.util.ArrayList;
import java.util.List;

public class openChat extends AppCompatActivity {
    EditText enterMessage ;
    ImageView enter_to_microphone;
    RecyclerView recyclerView ;
    messageAdapter messageAdapter ;
    List<String> messages = new ArrayList<>() ;             //list of messages


    ImageView backbutton ;
    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_chat);

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#1F2C34"));

        Animation bounceOutAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_out);
        Animation bounceBackAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_back);

        intialize();

        int imageResourceId = getIntent().getIntExtra("imageResourceId", 0);
        ImageView imageView = findViewById(R.id.DP); // Replace with your ImageView ID
        imageView.setImageResource(imageResourceId);

        String name = getIntent().getStringExtra("profileName");
        TextView profileName = findViewById(R.id.profileName);
        profileName.setText(name);




        messages.add("hello");

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



        messageAdapter = new messageAdapter(messages) ;

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
            messages.add(messageText);
            messageAdapter.notifyDataSetChanged();
            enterMessage.setText("");
            // Scroll to the last message
            recyclerView.smoothScrollToPosition(messages.size() - 1);
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