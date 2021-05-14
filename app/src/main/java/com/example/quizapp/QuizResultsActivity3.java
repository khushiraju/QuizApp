package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class QuizResultsActivity3 extends AppCompatActivity {
    public final String TAG = "QuizResultsActivity3";



    @Override

    // onCreate displays result string provided from the Intent from Quiz3Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results3);

        // Initialize Firebase Auth


        // get intent from quiz3Activity page
        Intent intent = getIntent();


        TextView textView3 = findViewById(R.id.q3answer);


        String message3 = intent.getStringExtra(Quiz3Activity.FINAL_ANSWER3);



        textView3.setText(message3);


    }


    // when back button pressed, go back to quiz feed (ChooseQuizActivity.class)
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }



}