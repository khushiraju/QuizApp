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

public class QuizResultsActivity extends AppCompatActivity {
    public final String TAG = "QuizResultsActivity";


    // Constants to use for labels in database




    // reference to entire database
    private FirebaseFirestore db;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // get intent from quiz page
        Intent intent = getIntent();

        TextView textView1 = findViewById(R.id.q1answer);

        String message1 = intent.getStringExtra(Quiz1Activity.FINAL_ANSWER1);

        //textView1.setText(R.string.quiz1String);

        if (message1.equals("Introvert") || message1.equals("Extrovert")) {
            textView1.setText(message1);
        }

        //addEvent();


    }



    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }





}