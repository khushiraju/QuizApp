package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        if (isComplete(extrovert, introvert)) {


            if (extrovert.size() > introvert.size()) {

                finalString = "Extrovert";

            } else {

                finalString = "Introvert";
            }

            //addEvent();

            extrovert.clear();
            introvert.clear();

            Intent intent = new Intent(this, QuizResultsActivity.class);
            intent.putExtra(FINAL_ANSWER1, finalString);

            startActivity(intent);

        }


        else {

            Toast.makeText(Quiz1Activity.this, "Please answer all questions!",
                    Toast.LENGTH_SHORT).show();

        }
    }





    // ROUGH SKETCH FOR WHAT THE QUIZ CODE WILL LOOK LIKE

    /*
    1. When a button for an answer choice is pressed, we need to make sure that that the button has not been clicked
    before. If it has, we need to make sure that it doesn't get added again.
    2. We also need to make sure that you can change your answer to a question. To do this, we need to check the corresponding
    list and the OTHER list. If the question has already been answered but the answer is for the opposite answer choice
    (in the opposite list, then we need to remove the element for that question from the other list and put it in the list
    for the button they MOST recently pressed.
    3. ok, but when CAN we add an answer to the list? we can add answer to the list when it is NOT in the list, and there is not
    already an answer to that question., or if the length of the list is 0.

    CODE PLAN:


    i think i need to make a whole new method to call in getAnswers UGH



    https://www.codegrepper.com/code-examples/java/android+studio+get+id+name+from+view


     */

    public void getAnswers(View answer) {

        // what is getResourceName vs. getResourceEntryName
        String choice = answer.getResources().getResourceEntryName(answer.getId());

        //pseudo code:

        if (choice.contains("option1")){

            fillArrays(choice, extrovert, introvert);

        }
        else if (choice.contains("option2")) {

            fillArrays(choice, introvert, extrovert);

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


