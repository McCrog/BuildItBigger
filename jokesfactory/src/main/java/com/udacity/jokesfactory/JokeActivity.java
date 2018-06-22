package com.udacity.jokesfactory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String jokeText = intent.getStringExtra(getString(R.string.joke_intent));

        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(jokeText);
    }
}
