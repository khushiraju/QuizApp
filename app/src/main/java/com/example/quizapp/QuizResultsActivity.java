package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class QuizResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results);

        // get intent from quiz page
        Intent intent = getIntent();
        String message = intent.getStringExtra(Quiz2Activity.FINAL_ANSWER);

        TextView textView = findViewById(R.id.q1answer);
        textView.setText(message);


    }
}