package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AllQuizResults extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_quiz_results);




    }

    // when back button pressed, go back the the quiz feed using an Intent (ChooseQuizActivity.class)
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

}
