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

public class QuizResultsActivity2 extends AppCompatActivity {
    public final String TAG = "QuizResultsActivity2";






    @Override

    // onCreate displays result string provided from the Intent from Quiz2Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results2);


        // get intent from quiz2Activity page
        Intent intent = getIntent();


        TextView textView2 = findViewById(R.id.q2answer);


        String message2 = intent.getStringExtra(Quiz2Activity.FINAL_ANSWER2);



        textView2.setText(message2);


    }


// When back button pressed, Go back to the quix feed (ChooseQuizActivity.class)
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }



}