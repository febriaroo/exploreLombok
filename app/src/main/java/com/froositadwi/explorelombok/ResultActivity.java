package com.froositadwi.explorelombok;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultText;
    int score;
    String toDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String userName = getIntent().getStringExtra("userName");
        score = getIntent().getIntExtra("score",0);

        if(score == 4)
        {
            toDisplay = "Hello " + userName + "!\n" +
                    "You got a perfect score!! Congrats! Your score is " + score + " out of 4!\n" +
                    "You are a Lombok Expert now!";
        }
        else if(score == 3)
        {
            toDisplay = "Hello " + userName + "!\n" +
                    "Well done! You almost did it! Congrats! Your score is " + score + " out of 4!\n";
        }
        else if(score <= 2)
        {
            toDisplay = "Hello " + userName + "!\n" +
                    "Nice Try! Your score is " + score + " out of 4!\n" +
                    "You need to use this app to become a Lombok Expert :D";
        }

        resultText = (TextView) findViewById(R.id.resultText);
        resultText.setText(toDisplay);

        FloatingActionButton sharingButton = (FloatingActionButton) findViewById(R.id.shareButton);
        sharingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareIt();
            }
        });
    }

    private void shareIt() {
    //sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hi Guys! I got " + score + " out of 4 questions at ExploreLombok!\nDownload the apps guys! Very useful app for guide you in Lombok :)";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I'm an Expert Now!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
