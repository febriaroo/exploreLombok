package com.froositadwi.explorelombok;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    RadioButton q1_a,q1_b,q1_c,q1_d;
    RadioButton q2_a,q2_b,q2_c,q2_d;
    RadioButton q3_a,q3_b,q3_c,q3_d;
    RadioButton q4_a,q4_b,q4_c,q4_d;
    RadioGroup q1,q2,q3,q4;
    Button submitButton;
    TextView qu1,qu2,qu3,qu4;
    EditText myName;

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initRadioButton();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkingQuizScore();
            }
        });

    }
    void initRadioButton()
    {
        myName = (EditText) findViewById(R.id.myName);
        q1 = (RadioGroup) findViewById(R.id.q1);
        q2 = (RadioGroup) findViewById(R.id.q2);
        q3 = (RadioGroup) findViewById(R.id.q3);
        q4 = (RadioGroup) findViewById(R.id.q4);
        qu1 = (TextView) findViewById(R.id.que1);
        qu2 = (TextView) findViewById(R.id.que2);
        qu3 = (TextView) findViewById(R.id.que3);
        qu4 = (TextView) findViewById(R.id.que4);
        submitButton = (Button) findViewById(R.id.submitQuiz);

    }
    void checkingQuizScore()
    {
        int count = 0;
        int score = 0;
        if(!myName.getText().toString().isEmpty())
        {
            userName = myName.getText().toString();
            count++;
        } else {
            //if not answer
            myName.setHintTextColor(Color.RED);
        }
        int ans1 = q1.getCheckedRadioButtonId();
        int ans2 = q2.getCheckedRadioButtonId();
        int ans3 = q3.getCheckedRadioButtonId();
        int ans4 = q4.getCheckedRadioButtonId();
        //answer q1 = A
        if(ans1 == -1)
        {
            //if not answer
          qu1.setTextColor(Color.RED);
        }
        else if(ans1 == R.id.ans1_a)
        {
            score++;
            count++;
            qu1.setTextColor(Color.BLACK);
        }
        else count++;
        //answer q2 = D
        if(ans2 == -1)
        {
            //if not answer
            qu2.setTextColor(Color.RED);
        }
        else if(ans2 == R.id.ans2_d)
        {
            score++;
            count++;
            qu2.setTextColor(Color.BLACK);
        }
        else count++;
        //answer q3 = B
        if(ans3 == -1)
        {
            //if not answer
            qu3.setTextColor(Color.RED);
        }
        else if(ans3 == R.id.ans3_b)
        {
            score++;
            count++;
            qu3.setTextColor(Color.BLACK);
        }else count++;
        //answer q4 = A
        if(ans4 == -1)
        {
            qu4.setTextColor(Color.RED);
        }
        else if(ans4 == R.id.ans4_a)
        {
            score++;
            count++;

            qu4.setTextColor(Color.BLACK);
        }else count++;
        Toast.makeText(getApplicationContext(),"count: " +count, Toast.LENGTH_LONG);
        if(count == 5)
        {
            //user fill All the form
            Intent beachIntent = new Intent(getApplicationContext(), ResultActivity.class);
            beachIntent.putExtra("userName", userName);
            beachIntent.putExtra("score", score);
            startActivity(beachIntent);
        }

    }
}
