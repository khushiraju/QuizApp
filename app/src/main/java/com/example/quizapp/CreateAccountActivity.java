package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    public final String TAG = "CreateAccountActivity";


    // Constants to use for labels in database
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";


    // reference to entire database
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
    }


    public void goToQuizFeed(View view) {

        addEvent();

        Intent intent = new Intent(this, ChooseQuizActivity.class);

        startActivity(intent);

    }

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


    /**
     * This method will be called to minimize the on screen keyboard in the Activity
     * When we get the current view, it is the view that has focus, which is the keyboard
     * Credit - Found and suggested by Ram Dixit, 2019
     *
     * Source:  https://www.youtube.com/watch?v=CW5Xekqfx3I
     */
    private void closeKeyboard() {
        View view = this.getCurrentFocus();     // view will refer to the keyboard
        if (view != null ){                     // if there is a view that has focus
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /*
        This method improves readability of the code for toast messages.  It is a simple helper method
     */
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}