package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AllQuizResults extends AppCompatActivity {

    public final String TAG = "AllQuizResults";
    public static String userID;

    public static FirebaseFirestore db;
    public static FirebaseAuth mAuth;

    public String quiz1Result;
    public String quiz2Result;
    public String quiz3Result;

    public TextView textView1 = findViewById(R.id.q1answer);
    public TextView textView2 = findViewById(R.id.q2answer);
    public TextView textView3 = findViewById(R.id.q3answer);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_quiz_results);
        //Intent intent = getIntent();
    }

    // when back button pressed, go back the the quiz feed using an Intent (ChooseQuizActivity.class)
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    /*
    public void getDocumentWithOptions() {
        userID = mAuth.getCurrentUser().getUid();
        DocumentReference docRef = db.collection("quizResults").document(userID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        quiz1Result = (String) document.getString("quiz1");
                        quiz2Result = (String) document.getString("quiz2");
                        quiz3Result = (String) document.getString("quiz3");
                        textView1.setText(quiz1Result);
                        textView2.setText(quiz2Result);
                        textView3.setText(quiz3Result);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
*/
}
