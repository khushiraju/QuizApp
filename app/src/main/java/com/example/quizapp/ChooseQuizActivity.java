package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChooseQuizActivity extends AppCompatActivity {
    public final String TAG = "ChooseQuizActivity";

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_quiz);


        // Get the Intent that started this activity and extract the string
        // receive intent from quiz1 screen
        mAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();


    }

    // This function takes you to the page with ALL of your quiz answers.

    public void goToFinalResultPage(View view) {
        Intent intent = new Intent(this, AllQuizResults.class);
        startActivity(intent);
    }

    /*

    Based on which button is pressed, go to the corresponding quiz page.

    Online Code Resources: https://developer.android.com/reference/android/R.id
    getId() method: https://stackoverflow.com/questions/14647810/easier-way-to-get-views-id-string-by-its-id-int



     */

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

    public void signOut (View view ) {


        Intent intent = new Intent (this, MainActivity.class);
        //SignInActivity.mAuth.signOut();

        if (SignInActivity.db == null) {
            CreateAccountActivity.mAuth.signOut();
            Log.i(TAG, "Sign Out Successful");
        }
        else {
            SignInActivity.mAuth.signOut();
            Log.i(TAG, "Sign Out Successful");

        }

        //CreateAccountActivity.mAuth.getInstance().signOut();
        //Intent intent = new Intent (this, MainActivity.class);
        //SignInActivity.userID = null;
        startActivity(intent);

    }




}