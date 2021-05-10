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


    // Constants to use for labels in database
    public static final String Q1A_KEY = "q1A";
    public static final String Q2A_KEY = "q2A";
    public static final String Q3A_KEY = "q3A";



    // reference to entire database
    private FirebaseFirestore db;

    private FirebaseAuth mAuth;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results3);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // get intent from quiz page
        Intent intent = getIntent();


        TextView textView3 = findViewById(R.id.q3answer);


        String message3 = intent.getStringExtra(Quiz3Activity.FINAL_ANSWER3);


        //if (message3.equals("Active") || message3.equals("Lazy")) {
        textView3.setText(message3);

        //}


        //addEvent();

    }



    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }


    public void addEvent() {

        String userq1A = findViewById(R.id.q1answer).toString();
        String userq2A = findViewById(R.id.q2answer).toString();
        String userq3A = findViewById(R.id.q3answer).toString();

        // Creates a key-value map of the object to add to the collection
        Map<String, Object> user = new HashMap<String, Object>();
        // Adds the all the key-value pairs to this object
        user.put(Q1A_KEY, userq1A);
        user.put(Q2A_KEY, userq2A);
        user.put(Q3A_KEY, userq3A);
        Log.i(TAG, user.toString());

        db.collection("quizApp")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        toastMessage("Event stored successfully");
                        Log.i(TAG, "Success");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        toastMessage("Event failed to add");
                        Log.i(TAG, "Failure");
                    }
                });
    }
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}