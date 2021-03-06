package com.udacity.jokesfactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String jokeIntentName = "JokeIntent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String jokeText = intent.getStringExtra(jokeIntentName);

        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(jokeText);
    }

    public static Intent newIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(jokeIntentName, joke);
        return intent;
    }
}
