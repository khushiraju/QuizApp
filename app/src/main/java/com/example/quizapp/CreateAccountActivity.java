package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity {

    public final String TAG = "CreateAccountActivity";


    // Constants to use for labels in database
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String QUIZ1 = "quiz1";
    public static final String QUIZ2 = "quiz2";
    public static final String QUIZ3= "quiz3";



    // reference to entire database
    public static FirebaseFirestore db;

    public static FirebaseAuth mAuth;

    public static String userID;

    private String quiz1Result = "No quiz taken";
    private String quiz2Result = "No quiz taken";
    private String quiz3Result = "No quiz taken";

        //private FirebaseUser currentUser;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.create_account);

            // db = FirebaseFirestore.getInstance();
            // ...
            // Initialize Firebase Auth
            mAuth = FirebaseAuth.getInstance();
            db = FirebaseFirestore.getInstance();

            Intent intent = getIntent();
        }

        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                reload();
            }
        }


    private void createAccount(String email, String password, String name) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = db.collection("quizResults").document(userID);
                            Map<String, Object> newUser = new HashMap<String, Object>();
                            // Adds the all the key-value pairs to this object
                            newUser.put(NAME_KEY, name);
                            newUser.put(EMAIL_KEY, email);
                            newUser.put(QUIZ1, quiz1Result);
                            newUser.put(QUIZ2, quiz2Result);
                            newUser.put(QUIZ3, quiz3Result);
                            documentReference.set(newUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "New User Created! UID:" + userID);
                                }
                            });
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(CreateAccountActivity.this, "Login Successful!",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(intent);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(CreateAccountActivity.this, "Login Failed",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }




    public void goToQuizFeed(View view) {

        EditText name = (EditText) findViewById(R.id.nameID);
        EditText email = (EditText) findViewById(R.id.emailID);
        EditText password = (EditText) findViewById(R.id.passwordID);

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();



        createAccount(userEmail, userPassword, userName);
        signIn(userEmail, userPassword);

        // we only want to go to the next page IF the signin is succesful. otherwise, it should dispaly the toast.
        //Intent intent = new Intent(this, ChooseQuizActivity.class);


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


    /**
     * This method will be called to minimize the on screen keyboard in the Activity
     * When we get the current view, it is the view that has focus, which is the keyboard
     * Credit - Found and suggested by Ram Dixit, 2019
     *
     * Source:  https://www.youtube.com/watch?v=CW5Xekqfx3I
     */
    /*
    private void closeKeyboard() {
        View view = this.getCurrentFocus();     // view will refer to the keyboard
        if (view != null ){                     // if there is a view that has focus
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    */

    /*
        This method improves readability of the code for toast messages.  It is a simple helper method
     */

    /*
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    */


    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }
    public String getUserID() {

        return this.userID;
    }


}