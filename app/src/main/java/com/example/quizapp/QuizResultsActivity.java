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

        String message = intent.getStringExtra(Quiz2Activity.FINAL_ANSWER2);
        TextView textView = findViewById(R.id.q2answer);
        textView.setText(message);

        String message1 = intent.getStringExtra(Quiz1Activity.FINAL_ANSWER1);
        TextView textView1 = findViewById(R.id.q1answer);
        textView1.setText(message1);

        String message3 = intent.getStringExtra(Quiz3Activity.FINAL_ANSWER3);
        TextView textView3 = findViewById(R.id.q3answer);
        textView3.setText(message3);



    }
}