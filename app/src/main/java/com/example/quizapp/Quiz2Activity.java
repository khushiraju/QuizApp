package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);
    }


    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }
}