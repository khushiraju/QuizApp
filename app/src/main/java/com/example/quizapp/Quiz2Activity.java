package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


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

                if(q1o1.isSelected()) {
                    q1o1.setSelected(true);

                }
                else if (!q1o1.isSelected()){
                    q1o1.setSelected(true);
                    q1o2.setSelected(false);

                }

            }
       });

        q1o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q1o2);

                if(q1o2.isSelected()) {
                    q1o2.setSelected(true);

                }
                else if (!q1o2.isSelected()){
                    q1o2.setSelected(true);
                    q1o1.setSelected(false);

                }

            }
        });

        q2o1.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q2o1);

                if(q2o1.isSelected()) {
                    q2o1.setSelected(true);

                }
                else if (!q2o1.isSelected()){
                    q2o1.setSelected(true);
                    q2o2.setSelected(false);

                }

            }
        });

        q2o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q2o2);

                if(q2o2.isSelected()) {
                    q2o2.setSelected(true);

                }
                else if (!q2o2.isSelected()){
                    q2o2.setSelected(true);
                    q2o1.setSelected(false);

                }

            }
        });

        q3o1.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q3o1);

                if(q3o1.isSelected()) {
                    q3o1.setSelected(true);

                }
                else if (!q3o1.isSelected()){
                    q3o1.setSelected(true);
                    q3o2.setSelected(false);

                }

            }
        });

        q3o2.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {
                // set the color to relative layout
                //q1o1.setBackgroundColor(Color.BLUE);
                getAnswers(q3o2);

                if(q3o2.isSelected()) {
                    q3o2.setSelected(true);

                }
                else if (!q3o2.isSelected()){
                    q3o2.setSelected(true);
                    q3o1.setSelected(false);

                }

            }
        });

    }


    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    public void submitResults2(View view) {


        if (isComplete(nightOwl, morningBird)) {

            if (nightOwl.size() > morningBird.size()) {

                finalString = "Night Owl";

            } else {

                finalString = "Morning Bird";
            }

            nightOwl.clear();
            morningBird.clear();

            Intent intent2 = new Intent(this, QuizResultsActivity2.class);
            intent2.putExtra(FINAL_ANSWER2, finalString);
            startActivity(intent2);
        }
        else {

            Toast.makeText(Quiz2Activity.this, "Please answer all questions!",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void getAnswers(View answer) {

        String choice = answer.getResources().getResourceEntryName(answer.getId());


        if (choice.contains("option1")) {

            fillArrays(choice, nightOwl, morningBird);
        }

        else if (choice.contains("option2")) {

            fillArrays(choice, morningBird, nightOwl);

        }

    }

    public void fillArrays(String choice, ArrayList<String> correspondingArray, ArrayList<String> oppositeArray)  {

        int count = 0;

        if (correspondingArray.size() == 0 && oppositeArray.size() == 0) {
            correspondingArray.add(choice);
        } else {

            for (int i = 0; i < correspondingArray.size(); i++) {

                if (correspondingArray.get(i).equals(choice)) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                for (int j = 0; j < oppositeArray.size(); j++) {

                    if (oppositeArray.get(j).contains(choice.substring(0, 2))) {

                        oppositeArray.remove(j);
                        break;

                    }

                }
            }

            if (count == 0) {
                correspondingArray.add(choice);
            }
        }
    }

    public boolean isComplete(ArrayList <String> list1, ArrayList <String> list2){


        //we want to check that ALL of the questions have been answered. SO if one question already HAS an answer,

        int questionTracker = 0;

        if (list1.size() > 0) {
            for (int i = 0; i < list1.size(); i++) {

                if (list1.get(i).contains("q1") || list1.get(i).contains("q2") || list1.get(i).contains("q3")) {

                    questionTracker++;

                }

            }

        }

        if (list2.size() > 0) {

            for (int i = 0; i < list2.size(); i++) {


                if (list2.get(i).contains("q1") || list2.get(i).contains("q2") || list2.get(i).contains("q3")) {

                    questionTracker++;

                }

            }

        }


        if (questionTracker < 3) {

            return false;


        }

        else {

            return true;
        }




    }




}