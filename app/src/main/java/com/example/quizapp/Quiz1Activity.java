package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Quiz1Activity extends AppCompatActivity {


    public static final String FINAL_ANSWER1 = "com.example.quizapp.FINALSTRING";
    ArrayList<String> extrovert = new ArrayList<String>();
    ArrayList<String> introvert = new ArrayList<String>();
    public String finalString = " ";



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);


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
                //q1o1.setBackgroundColor(Color.BLUE);
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


    // function goest to quiz feed.
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    // get text IDS for each of the buttons, need an indication when to




    // goes to quiz results page. still need to go back and add code so we can take information from it.

    public void submitResults(View view) {

        if (extrovert.size() > introvert.size() ) {

            finalString = "Extrovert";

        }
        else {

            finalString = "Introvert";
        }

        extrovert.clear();
        introvert.clear();

        Intent intent = new Intent (this, QuizResultsActivity.class);
        intent.putExtra(FINAL_ANSWER1, finalString);
        startActivity(intent);
    }

    // ROUGH SKETCH FOR WHAT THE QUIZ CODE WILL LOOK LIKE

    public void getAnswers(View answer) {

        // maybe change to findViewById? 
        
        String choice = answer.getResources().getResourceName(answer.getId());

        

        if (choice.contains("option1")) {
            // if (extrovert.size() > 0) {
            extrovert.add(choice);
        }
   
         
        else {

            introvert.add(choice);
        }

    }
    
    //public void cleanUpList(ArrayList<String> answerList, String choice)  {
        
    //1. what do we need to do? make sure that if a button is pressed twice, it does not get added to the array twice
    //2. If user wants to CHANGE their answer, then their answer for that question needs to be removed from one list and put in the other.
    
    // for (int i = 0; i < answerList.size(); i++) {
         
       //q1option1
         
        // if (answerList.get(i).substring(0,2).equals(choice.substring(0,2))){
             
            // if (!answerList.get(i).substring(2).equals(choice.substring(2))) {
                 
                // answerList.set(i, choice);
                 
            
                 
            // }
             
             
             
             
       //  }
         
         
    // }
        
        
        
   // }
  
    }
