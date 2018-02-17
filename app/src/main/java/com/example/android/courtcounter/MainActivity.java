package com.example.android.courtcounter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    public int counter;
    Button startTheGame;
    TextView gameTimerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);

        counter = 30;
        startTheGame = findViewById(R.id.start_button);
        gameTimerView = findViewById(R.id.gameTimer);
        gameTimerView.setText("30");

        startTheGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        gameTimerView.setText(String.valueOf(counter));
                        counter--;
                    }
                    public  void onFinish(){
                        if (scoreTeamA > scoreTeamB){
                            gameTimerView.setText("Team A is the Winner!");
                        }
                        else if (scoreTeamB > scoreTeamA){
                            gameTimerView.setText("Team B is the Winner!");
                        }  else {
                            gameTimerView.setText("It's a tie");
                        }
                    }
                }.start();

            }
        });
    }

    /* Display Team A Score */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointsTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void twoPointsTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void freeThrowTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /* Display Team B Score */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointsTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void twoPointsTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void freeThrowTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }


    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        gameTimerView.setText("30");
        counter = 30;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

}
