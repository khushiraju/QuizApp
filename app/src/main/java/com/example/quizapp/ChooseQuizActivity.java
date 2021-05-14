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

    public void goToFinalResultPage(View view) {
        Intent intent = new Intent(this, AllQuizResults.class);
        startActivity(intent);
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

    public void signOut (View view ) {


        Intent intent = new Intent (this, MainActivity.class);
        mAuth.signOut();
        //Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);



    }




}