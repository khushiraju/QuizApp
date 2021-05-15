package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignInActivity extends AppCompatActivity {



    public final String TAG = "SignInActivity";
    public static String userID;

    public static FirebaseFirestore db;
    public static FirebaseAuth mAuth;

     /*

    onCreate recieves intent from homeScreen and instantiates mAuth and db for FireStore functions

      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

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

    // fired when Back button pressed. When pressed, it goes to the page before it (MainActivity.class)

    public void backButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // This functions fires when the user HITs the button to create their account. Calls createAccount() and signIn()

    public void goToQuizFeed(View view) {

        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);


        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        signIn(userEmail, userPassword);




    }

    /*

    After the account is created, the user is automatically signed in.
    Sign In Authentication code from FireBase docs: https://firebase.google.com/docs/auth/android/start?authuser=0

     */

    public void signIn(String email, String password) {
        // [START sign_in_with_email]
        Intent intent = new Intent(this, ChooseQuizActivity.class);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = db.collection("quizResults").document(userID);
                            Toast.makeText(SignInActivity.this, "Login Successful!",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Incorrect email or password. Please try again.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }
// other required method stubs according to firebase
// https://github.com/firebase/snippets-android/blob/6ec6b5f9d5e79437aabf79c6856d77a8f1a0655f/auth/app/src/main/java/com/google/firebase/quickstart/auth/EmailPasswordActivity.java#L85-L102
    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }

}