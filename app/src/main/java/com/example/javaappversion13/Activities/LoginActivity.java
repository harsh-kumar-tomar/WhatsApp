package com.example.javaappversion13.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.javaappversion13.R;
import com.example.javaappversion13.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding ;
    private FirebaseAuth auth;
    GoogleSignInClient signInRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());








        setContentView(binding.getRoot());
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#121B22"));
        binding.progressBar.setVisibility(View.INVISIBLE);

        auth = FirebaseAuth.getInstance();


        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(getString(R.string.default_web_client_id))
                        // Only show accounts previously used to sign in.
                        .setFilterByAuthorizedAccounts(true)
                        .build())
                .build();



        if (auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(getApplicationContext() , MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_entering_animation, R.anim.activity_exiting_animation);


            finish();

        }








        binding.LoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(binding.UserEmail.getText().toString() , binding.UserPassword.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                binding.progressBar.setVisibility(View.VISIBLE);

                                if (task.isSuccessful())
                                {
                                    Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else
                                {
                                    Toast.makeText(getApplicationContext() , task.getException().toString() , Toast.LENGTH_SHORT);
                                }

                            }
                        });

            }
        });

        binding.doNotHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_entering_animation, R.anim.activity_exiting_animation);


                finish();
            }
        });





    }
}