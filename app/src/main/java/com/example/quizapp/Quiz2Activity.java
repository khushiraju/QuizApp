package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


import java.util.ArrayList;

public class Quiz2Activity extends AppCompatActivity {


    public static final String FINAL_ANSWER2 = "com.example.quizapp.FINALSTRING";
    ArrayList<String> nightOwl = new ArrayList<String>();
    ArrayList<String> morningBird = new ArrayList<String>();
    public String finalString = " ";


    @Override

    // Resource Citations:  https://www.geeksforgeeks.org/how-to-change-the-background-color-after-clicking-the-button-in-android/
    // https://stackoverflow.com/questions/3882064/how-to-change-color-of-button-in-android-when-clicked
    // https://stackoverflow.com/questions/14647810/easier-way-to-get-views-id-string-by-its-id-int
    // https://stackoverflow.com/questions/3882064/how-to-change-color-of-button-in-android-when-clicked
    // https://www.youtube.com/watch?v=RJV9Ur-CUpw 



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);


        Button q1o1, q1o2, q2o1, q2o2, q3o1, q3o2;
        //final ConstraintLayout constraintLayout;

        

        q1o1 = findViewById(R.id.q1option1);
        q1o2 = findViewById(R.id.q1option2);
        q2o1 = findViewById(R.id.q2option1);
        q2o2 = findViewById(R.id.q2option2);
        q3o1 = findViewById(R.id.q3option1);
        q3o2 = findViewById(R.id.q3option2);

        //constraintLayout = findViewById(R.id.color);

        Intent intent = getIntent();

        q1o1.setOnClickListener(new View.OnClickListener() {
           // @Override
            public void onClick(View view) {
                // set the color to relative layout
                q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q1o1);

            }
       });

        q1o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q1o2);

            }
        });

        q2o1.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q2o1);

            }
        });

        q2o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q2o2);

            }
        });

        q3o1.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q3o1);

            }
        });

        q3o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q3o2);

            }
        });

    }


    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    public void submitResults(View view) {

        if (nightOwl.size() > morningBird.size() ) {

            finalString = "Night Owl";

        }
        else {

            finalString = "Morning Bird";
        }

        nightOwl.clear();
        morningBird.clear();

        Intent intent = new Intent (this, QuizResultsActivity.class);
        intent.putExtra(FINAL_ANSWER2, finalString);
        startActivity(intent);
    }


    public void getAnswers(View answer) {

        String choice = answer.getResources().getResourceName(answer.getId());


        if (choice.contains("option1")) {

        nightOwl.add(choice);
        }

        else {

        morningBird.add(choice);
        }

    }




}