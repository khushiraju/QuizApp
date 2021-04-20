package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Quiz1Activity extends AppCompatActivity {


   //public static final String EXTRA_NAME = "com.example.quizapp.NAME";

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);
    }


    // function goest to quiz feed.
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }


    // goes to quiz results page. still need to go back and add code so we can take information from it.

    public void submitResults(View view) {

        Intent intent = new Intent (this, QuizResultsActivity.class);
        startActivity(intent);
    }


    }
