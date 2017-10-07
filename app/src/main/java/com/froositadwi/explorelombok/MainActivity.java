package com.froositadwi.explorelombok;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button exploreButton = (Button) findViewById(R.id.explore);
        Button quizButton = (Button) findViewById(R.id.quiz);


        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform action on click

                Intent quizIntent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(quizIntent);
            }
        });

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent beachIntent = new Intent(getApplicationContext(), BeachActivity.class);
                startActivity(beachIntent);
            }
        });
    }

}
