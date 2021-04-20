package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // copy paste all code changes here
    // https://docs.google.com/document/d/1io69aAmL-Ryfk2FjgMh9KWGuCvxa4gK72VA0blPfUk8/edit?usp=sharing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void goToSignUp( View view ) {

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);


    }


}