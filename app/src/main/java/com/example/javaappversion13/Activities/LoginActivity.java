package com.example.javaappversion13.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.javaappversion13.Domain.structUser;
import com.example.javaappversion13.R;
import com.example.javaappversion13.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.e;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private FirebaseAuth auth;
    GoogleSignInClient googleSignInClient;
    FirebaseUser firebaseUser ;


    private static final int RC_SIGN_IN = 2;  // Can be any integer unique to the Activity.
    private boolean showOneTapUI = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#121B22"));
        binding.progressBar.setVisibility(View.INVISIBLE);


        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();


        //adding Google Signing


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))//you can also use R.string.default_web_client_id
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);




        //Google Button
        binding.GoogleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBar.setVisibility(View.VISIBLE);
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });






        binding.LoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.progressBar.setVisibility(View.VISIBLE);


                if (!binding.UserEmail.getText().toString().equals("") && !binding.UserPassword.getText().toString().equals(""))
                {

                    binding.progressBar.setVisibility(View.VISIBLE);

                    auth.signInWithEmailAndPassword(binding.UserEmail.getText().toString(), binding.UserPassword.getText().toString()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    binding.progressBar.setVisibility(View.INVISIBLE);

                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }).addOnCanceledListener(new OnCanceledListener() {
                                @Override
                                public void onCanceled() {
                                    Toast.makeText(LoginActivity.this, "error occurred", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    binding.progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Empty User details", Toast.LENGTH_SHORT).show();
                }



            }
        });

        binding.doNotHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_entering_animation, R.anim.activity_exiting_animation);
                finish();
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            overridePendingTransition(R.anim.activity_entering_animation, R.anim.activity_exiting_animation);
            finish();
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check condition
        if (requestCode == RC_SIGN_IN) {
            // When request code is equal to 100 initialize task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Initialize sign in account
                GoogleSignInAccount googleSignInAccount = task.getResult(ApiException.class);
                FirebaseAuthwithGoogle(googleSignInAccount.getIdToken());

            } catch (ApiException e) {

            }

        }


    }

    public void FirebaseAuthwithGoogle(String idToken)
    {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(idToken, null);
        // Check credential
        auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // Check condition
                if (task.isSuccessful()) {
                    // When task is successful redirect to profile activity display Toast
                    FirebaseUser user = auth.getCurrentUser();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    String id = task.getResult().getUser().getUid();
                    structUser u = new structUser("null" , user.getDisplayName() , user.getEmail() , "null" , id);

                    database.getReference().child("Users").child(id).setValue(u);






                    binding.progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText( getApplicationContext() , "User registered Successfully" , Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    Toast.makeText(getApplicationContext(),"Sign in with Google",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    // When task is unsuccessful display Toast
                }
            }

        });
    }
    }




