package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_quiz);


        // Get the Intent that started this activity and extract the string
        // receive intent from quiz1 screen
        Intent intent = getIntent();


    }

    // this probably works okay for now, but could be more efficient if we ever add more quizzes

    public void goToQuiz (View quiz) {

        Intent intent;
        int id = quiz.getId();

        if (id == R.id.quiz1Button) {

            intent = new Intent(this, Quiz1Activity.class);
            startActivity(intent);

        }

        else if ( id == R.id.quiz2Button) {

            intent = new Intent(this, Quiz2Activity.class);
            startActivity(intent);


        }

        else {

            intent = new Intent(this, Quiz3Activity.class);
            startActivity(intent);


        }




    }




}