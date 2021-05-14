package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    private FirebaseAuth mAuth;

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

    // Function fires when SignUp button is clicked. Send an intent to CreateAccountActivity page

    public void goToSignUp( View view ) {

        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);


    }


    // Function fires when SignUp button is clicked. Send an intent to SignInActivity page

    public void goToSignIn( View view ) {

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);


    }




    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }


}