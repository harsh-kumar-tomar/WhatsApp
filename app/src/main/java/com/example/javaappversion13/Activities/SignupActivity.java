package com.example.javaappversion13.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.javaappversion13.Domain.structUser;
import com.example.javaappversion13.R;
import com.example.javaappversion13.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#121B22"));


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressBar = binding.progressBar;
        progressBar.setVisibility(View.INVISIBLE);


        binding.SignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!binding.UserName.getText().toString().equals("") && !binding.UserEmail.getText().toString().equals("") && !binding.UserPassword.getText().toString().equals(""))
                {

                    progressBar.setVisibility(View.VISIBLE);
                    auth.createUserWithEmailAndPassword(binding.UserEmail.getText().toString() , binding.UserPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.INVISIBLE);

                                    if(task.isSuccessful())
                                    {

                                        structUser user = new structUser(binding.UserName.getText().toString() , binding.UserEmail.getText().toString() , binding.UserPassword.getText().toString());
                                        String id = task.getResult().getUser().getUid();
                                        database.getReference().child("Users").child(id).setValue(user);
                                        Toast.makeText( getApplicationContext() , "User registered Successfully" , Toast.LENGTH_SHORT).show();
                                    }else {

                                        Toast.makeText( getApplicationContext() , "Unable to make account" , Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });

                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(SignupActivity.this, "Empty User details", Toast.LENGTH_SHORT).show();

                }

            }

        });


        binding.alreadyHaveaAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , LoginActivity.class));
                overridePendingTransition(R.anim.activity_entering_animation,  R.anim.activity_exiting_animation);

                finish();
            }
        });



    }
}