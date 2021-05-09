package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    // copy paste all code changes here
    // https://docs.google.com/document/d/1io69aAmL-Ryfk2FjgMh9KWGuCvxa4gK72VA0blPfUk8/edit?usp=sharing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            reload();
        }

    }

    public void goToSignUp( View view ) {

        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);


    }


    public void goToSignIn( View view ) {

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);


    }




    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }


}