package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz1Activity extends AppCompatActivity {


    public static final String FINAL_ANSWER1 = "com.example.quizapp.FINALSTRING";
    ArrayList<String> extrovert = new ArrayList<String>();
    ArrayList<String> introvert = new ArrayList<String>();
    public final String TAG = "Quiz1Activity";
    public String finalString = " ";
    public static final String Q1A_KEY = "q1A";
    public static final String Q2A_KEY = "q2A";
    public static final String Q3A_KEY = "q3A";

    @Override

    /* OnCreate Code Online Resources:
    Button Color Change: https://www.youtube.com/watch?v=c_TVDow4Rbk
    Button onClick Listener: https://www.geeksforgeeks.org/how-to-change-the-background-color-after-clicking-the-button-in-android/


    onCreate handles Button OnClick events such as color changes when buttons are clicked and also calls getAnswers() for quiz functions
    that store question responses. Also gets intent from ChooseQuizActivity


     */



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



        Intent intent = getIntent();

        q1o1.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {


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


    // function goes to quiz feed.
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }


    /*

    Online Code Resources:

   FireStore Update Collection: https://firebase.google.com/docs/firestore/manage-data/add-data?authuser=0#java_16


    compares the lengths of the two personality arrays that answers can fall into. Whichever personality list that has the bigger size will end up being the result of the user
    earns after taking the quiz. Then, the result is stored iin FireStore in the user's own data collection. The lists are cleared so that the quizzes can be taken again.
    An intent is sent to the page that displays the user's result. If the user has not answered all the questions (which is determined through the isComplete() function call, then
    a Toast will appear indicating that they need to finish all questions before proceeding

     */

    public void submitResults(View view) {

        if (isComplete(extrovert, introvert)) {


            if (extrovert.size() > introvert.size()) {

                finalString = "Extrovert";

            } else {

                finalString = "Introvert";
            }

            //code to update the database:
            System.out.println(SignInActivity.userID);

            if (SignInActivity.db == null) {
                CreateAccountActivity.db.collection("quizResults").document(CreateAccountActivity.userID)
            .update(CreateAccountActivity.QUIZ1, finalString);


            }
            else {
                SignInActivity.db.collection("quizResults").document(SignInActivity.userID)
                        .update(CreateAccountActivity.QUIZ1, finalString);

            }
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

    /*

   Online Code Resources:

   Get name of View id: https://www.codegrepper.com/code-examples/java/android+studio+get+id+name+from+view

   based on the button id, which indicates the "option number" for each of the question, the id is stored in one of two personality lists: each of the the lists corresponds to
   a result, as there are only two possible results for a quiz. In addition, it calls the function fillArray() which makes sure that the same answer cannot be added to the list twice
   and that quiz answers can be changed.



     */




    public void getAnswers(View answer) {


        String choice = answer.getResources().getResourceEntryName(answer.getId());



        if (choice.contains("option1")){

            fillArrays(choice, extrovert, introvert);

        }
        else if (choice.contains("option2")) {

            fillArrays(choice, introvert, extrovert);

        }


        }

        /*

        This function is very essential, as it makes sure that answers choices are added to the ArrayLists correctly.
        The function checks to see if BOTH of the ArrayLists are empty. If so, then an answer can be added to its corresponding list.
        If both of the lists are NOT empty, then the function checks the ArrayLists to make sure that the option the user pressed has not already been added to an array. If if has been added,
        nothing happens and the list stays stays as is.
        If an answers has NOT been added to its corresponding list, then we need to check that the QUESTION has not been answered. The function loops through the OTHER array and checks to see
        if any of its elements contain the same starting character (q1, q2, or q3) as the id of the answer choice that the user clicked, the that element is REMOVED from the OTHER array and the NEW
      , most RECENT choice the user clicked is added to its corresponding array.





         */


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


      /*

      This method checks both arrays to verify that all questions have been answered. Loops through both arrays looking for elements that contains "q1", "q2", or "q3". Every time
      these substrings are found, a counter goes up. If the counter does NOT equal 3 by the time both arrays are traversed (count 3 for 3 questions), then the method returns false.
      Method called by submitResults and displays a Toast if method returns false.



       */

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


    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    }


