package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results);

        // get intent from quiz page
        Intent intent = getIntent();

        String message = intent.getStringExtra(Quiz2Activity.FINAL_ANSWER2);
        TextView textView = findViewById(R.id.q2answer);
        textView.setText(message);

        String message1 = intent.getStringExtra(Quiz1Activity.FINAL_ANSWER1);
        TextView textView1 = findViewById(R.id.q1answer);
        textView1.setText(message1);

        String message3 = intent.getStringExtra(Quiz3Activity.FINAL_ANSWER3);
        TextView textView3 = findViewById(R.id.q3answer);
        textView3.setText(message3);

    }

    public void backButton(View view) {
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        startActivity(intent);
    }

    /*
    public void addEvent() {
        EditText name = (EditText) findViewById(R.id.nameID);
        EditText email = (EditText) findViewById(R.id.emailID);
        EditText password = (EditText) findViewById(R.id.passwordID);

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        // Creates a key-value map of the object to add to the collection
        Map<String, Object> user = new HashMap<String, Object>();
        // Adds the all the key-value pairs to this object
        user.put(NAME_KEY, userName);
        user.put(EMAIL_KEY, userEmail);
        user.put(PASSWORD_KEY, userPassword);
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

        // Clear the event name field
        name.setText("");
        email.setText("");
        password.setText("");

        closeKeyboard();
    }


     */
}