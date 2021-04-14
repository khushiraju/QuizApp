package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Quiz1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);
    }
}

public void sendMessage(View view) {
    Intent intent = new Intent(this, ChooseQuizActivity.class);
    EditText editText = (EditText) findViewById(R.id.nameEditText);
    String name = editText.getText().toString();
    intent.putExtra(EXTRA_NAME, name);
    startActivity(intent);
    }
