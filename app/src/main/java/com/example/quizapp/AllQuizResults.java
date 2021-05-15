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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_quiz_results);
        Intent intent = getIntent();
        getDocumentWithOptions();
    }

    // when back button pressed, go back the the quiz feed using an Intent (ChooseQuizActivity.class)
    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    // https://github.com/firebase/snippets-android/blob/6ec6b5f9d5e79437aabf79c6856d77a8f1a0655f/firestore/app/src/main/java/com/google/example/firestore/DocSnippets.java#L618-L633
    // https://stackoverflow.com/questions/48492993/firestore-get-documentsnapshots-fields-value
    public void getDocumentWithOptions() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        DocumentReference docRef = db.collection("quizResults").document(userID);
        TextView textView1 = findViewById(R.id.q1answer);
        TextView textView2 = findViewById(R.id.q2answer);
        TextView textView3 = findViewById(R.id.q3answer);
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

}
