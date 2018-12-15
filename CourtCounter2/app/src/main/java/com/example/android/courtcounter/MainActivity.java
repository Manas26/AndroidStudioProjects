package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count1,count=0;
    public void button2(View view){
        count = count +3;
        displayForTeamA(count);
    }

    public void button3(View view){
        count = count +2;
        displayForTeamA(count);
    }

    public void freeThrow(View view){
        count = count +1;
        displayForTeamA(count);
    }

    public void button4(View view){
        count1 = count1 +3;
        displayForTeamB(count1);
    }

    public void button5(View view){
        count1 = count1 +2;
        displayForTeamB(count1);
    }

    public void freeThrowB(View view){
        count1 = count1 +1;
        displayForTeamB(count1);
    }

public void reset(View view){
    displayForTeamA(0);
    displayForTeamB(0);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
