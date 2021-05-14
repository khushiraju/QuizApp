package com.example.quizapp;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AllQuizResults extends AppCompatActivity {

    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

}
