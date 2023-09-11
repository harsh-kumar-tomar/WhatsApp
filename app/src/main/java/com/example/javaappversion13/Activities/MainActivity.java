package com.example.javaappversion13.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.javaappversion13.Adapters.chatAdapter;
import com.example.javaappversion13.R;
import com.example.javaappversion13.Adapters.ViewPagerAdapter;
import com.example.javaappversion13.Domain.structChatView;
import com.example.javaappversion13.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout ;
    ViewPager viewPager ;

    ActivityMainBinding binding ;
    private FirebaseAuth auth ;

    FloatingActionButton selectContacts ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();


        intialize();
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#1F2C34"));

        ViewPager2 viewPager = findViewById(R.id.viewPager2);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Chats");
                    break;
                case 1:
                    tab.setText("Status");
                    break;
                case 2:
                    tab.setText("Calls");
                    break;
            }
        }).attach();










        selectContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , selectContact.class);


                startActivity(intent);

            }
        }); //floating button for selecting contact

    }



    private void intialize() {


        selectContacts=findViewById(R.id.selectContact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {



        int itemId = item.getItemId();

        if (itemId == R.id.OptionSettings) {
        } else if (itemId == R.id.OptionNewGroup) {
        } else if (itemId == R.id.OptionLogout) {
            auth.signOut();
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}