package com.example.lsourtzo.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lsourtzo.scorekeeper.R;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    static final String scoreTeamAS = "scoreTeamA";
    static final String foulsTeamAS = "foulsTeamA";
    static final String penaltiesTeamAS = "penaltiesTeamA";
    static final String cornersTeamAS = "cornersTeamA";
    static final String YCTeamAS = "YCTeamA";
    static final String RCTeamAS = "RCTeamA";
    static final String scoreTeamBS = "scoreTeamB";
    static final String foulsTeamBS = "foulsTeamB";
    static final String penaltiesTeamBS = "penaltiesTeamB";
    static final String cornersTeamBS = "cornersTeamB";
    static final String YCTeamBS = "YCTeamB";
    static final String RCTeamBS = "RCTeamB";
    static final String teamAS = "teamA";
    static final String teamBS = "teamB";

    int scoreTeamA = 0;
    int foulsTeamA = 0;
    int penaltiesTeamA = 0;
    int cornersTeamA = 0;
    int YCTeamA = 0;
    int RCTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamB = 0;
    int penaltiesTeamB = 0;
    int cornersTeamB = 0;
    int YCTeamB = 0;
    int RCTeamB = 0;

    boolean firtsFoul = false;
    boolean firtsCorner = false;

    boolean DayNight = false;

    public static Integer[] images = new Integer[]{R.drawable.team1, R.drawable.team2, R.drawable.team3, R.drawable.team4, R.drawable.team5};

    int teamA = 0;
    int teamB = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(scoreTeamAS , scoreTeamA );
        savedInstanceState.putInt(foulsTeamAS , foulsTeamA );
        savedInstanceState.putInt(penaltiesTeamAS , penaltiesTeamA );
        savedInstanceState.putInt(cornersTeamAS , cornersTeamA );
        savedInstanceState.putInt(YCTeamAS , YCTeamA );
        savedInstanceState.putInt(RCTeamAS , RCTeamA );
        savedInstanceState.putInt(scoreTeamBS , scoreTeamB );
        savedInstanceState.putInt(foulsTeamBS , foulsTeamB );
        savedInstanceState.putInt(penaltiesTeamBS , penaltiesTeamB );
        savedInstanceState.putInt(cornersTeamBS , cornersTeamB );
        savedInstanceState.putInt(YCTeamBS , YCTeamB );
        savedInstanceState.putInt(RCTeamBS , RCTeamB );
        savedInstanceState.putInt(teamAS , teamA);
        savedInstanceState.putInt(teamBS , teamB);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(scoreTeamAS);
        foulsTeamA = savedInstanceState.getInt(foulsTeamAS);
        penaltiesTeamA = savedInstanceState.getInt(penaltiesTeamAS);
        cornersTeamA = savedInstanceState.getInt(cornersTeamAS);
        YCTeamA = savedInstanceState.getInt(YCTeamAS);
        RCTeamA = savedInstanceState.getInt(RCTeamAS);
        scoreTeamB = savedInstanceState.getInt(scoreTeamBS);
        foulsTeamB = savedInstanceState.getInt(foulsTeamBS);
        penaltiesTeamB = savedInstanceState.getInt(penaltiesTeamBS);
        cornersTeamB = savedInstanceState.getInt(cornersTeamBS);
        YCTeamB = savedInstanceState.getInt(YCTeamBS);
        RCTeamB = savedInstanceState.getInt(RCTeamBS);
        teamA = savedInstanceState.getInt(teamAS);
        teamB = savedInstanceState.getInt(teamBS);

        ConterInc_Matrix(scoreTeamA,R.id.team_a_score);
        ConterInc(foulsTeamA,R.id.team_a_foul);
        if (!firtsFoul){
            firtsFoul=true;
            FF_FC_MARKER('X',R.id.team_a_ff);
        }
        ConterInc(penaltiesTeamA,R.id.team_a_pen);
        ConterInc(cornersTeamA,R.id.team_a_corners);
        if (!firtsCorner){
            firtsCorner=true;
            FF_FC_MARKER('X',R.id.team_a_fc);
        }
        ConterInc(YCTeamA,R.id.team_a_yc);
        ConterInc(RCTeamA,R.id.team_a_rc);
        iconTeamA(teamA);
        iconTeamA2(teamA);

        ConterInc_Matrix(scoreTeamB,R.id.team_b_score);
        ConterInc(foulsTeamB,R.id.team_b_foul);
        if (!firtsFoul){
            firtsFoul=true;
            FF_FC_MARKER('X',R.id.team_b_ff);
        }
        ConterInc(penaltiesTeamB,R.id.team_b_pen);
        ConterInc(cornersTeamB,R.id.team_b_corners);
        if (!firtsCorner){
            firtsCorner=true;
            FF_FC_MARKER('X',R.id.team_b_fc);
        }
        ConterInc(YCTeamB,R.id.team_b_yc);
        ConterInc(RCTeamB,R.id.team_b_rc);
        iconTeamB(teamB);
        iconTeamB2(teamB);

    }

    /**
     * Increase for Team A.
     */
    public void methodGoalA(View v) {
        scoreTeamA = scoreTeamA +1;
        ConterInc_Matrix(scoreTeamA,R.id.team_a_score);
    }
    public void methodFoulsA(View v) {
        foulsTeamA = foulsTeamA +1;
        ConterInc(foulsTeamA,R.id.team_a_foul);
       if (!firtsFoul){
            firtsFoul=true;
            FF_FC_MARKER('X',R.id.team_a_ff);
        }
    }
    public void methodPenaltiesA(View v) {
        penaltiesTeamA = penaltiesTeamA +1;
        ConterInc(penaltiesTeamA,R.id.team_a_pen);
    }
    public void methodCornersA(View v) {
        cornersTeamA = cornersTeamA +1;
        ConterInc(cornersTeamA,R.id.team_a_corners);
        if (!firtsCorner){
            firtsCorner=true;
            FF_FC_MARKER('X',R.id.team_a_fc);
        }
    }
    public void methodYCA(View v) {
        YCTeamA = YCTeamA +1;
        ConterInc(YCTeamA,R.id.team_a_yc);
    }
    public void methodRCA(View v) {
        RCTeamA = RCTeamA +1;
        ConterInc(RCTeamA,R.id.team_a_rc);
    }

    /**
     * Increase for Team B.
     */
    public void methodGoalB(View v) {
        scoreTeamB = scoreTeamB +1;
        ConterInc_Matrix(scoreTeamB,R.id.team_b_score);
    }
    public void methodFoulsB(View v) {
        foulsTeamB = foulsTeamB +1;
        ConterInc(foulsTeamB,R.id.team_b_foul);
        if (!firtsFoul){
            firtsFoul=true;
            FF_FC_MARKER('X',R.id.team_b_ff);
        }
    }
    public void methodPenaltiesB(View v) {
        penaltiesTeamB = penaltiesTeamB +1;
        ConterInc(penaltiesTeamB,R.id.team_b_pen);
    }
    public void methodCornersB(View v) {
        cornersTeamB = cornersTeamB +1;
        ConterInc(cornersTeamB,R.id.team_b_corners);
        if (!firtsCorner){
            firtsCorner=true;
            FF_FC_MARKER('X',R.id.team_b_fc);
        }
    }
    public void methodYCB(View v) {
        YCTeamB = YCTeamB +1;
        ConterInc(YCTeamB,R.id.team_b_yc);
    }
    public void methodRCB(View v) {
        RCTeamB = RCTeamB +1;
        ConterInc(RCTeamB,R.id.team_b_rc);
    }

    /**
     * ResetButton.
     */

    public void resetButton(View v) {
        scoreTeamA = 0;
         foulsTeamA = 0;
         penaltiesTeamA = 0;
         cornersTeamA = 0;
         YCTeamA = 0;
         RCTeamA = 0;

         scoreTeamB = 0;
         foulsTeamB = 0;
         penaltiesTeamB = 0;
         cornersTeamB = 0;
         YCTeamB = 0;
         RCTeamB = 0;

        ConterInc_Matrix(scoreTeamA,R.id.team_a_score);
        ConterInc(foulsTeamA,R.id.team_a_foul);
        ConterInc(penaltiesTeamA,R.id.team_a_pen);
        ConterInc(cornersTeamA,R.id.team_a_corners);
        ConterInc(YCTeamA,R.id.team_a_yc);
        ConterInc(RCTeamA,R.id.team_a_rc);
        FF_FC_MARKER('-',R.id.team_a_fc);
        FF_FC_MARKER('-',R.id.team_a_ff);

        ConterInc_Matrix(scoreTeamB,R.id.team_b_score);
        ConterInc(foulsTeamB,R.id.team_b_foul);
        ConterInc(penaltiesTeamB,R.id.team_b_pen);
        ConterInc(cornersTeamB,R.id.team_b_corners);
        ConterInc(YCTeamB,R.id.team_b_yc);
        ConterInc(RCTeamB,R.id.team_b_rc);
        FF_FC_MARKER('-',R.id.team_b_fc);
        FF_FC_MARKER('-',R.id.team_b_ff);

        firtsFoul=false;
        firtsCorner=false;


    }

    /**
     * Change teams logos
     */
    public void methodTeamA(View v) {
        teamA = teamA+1;
        if (teamA == 5) {
            teamA = 0;
        }
        if (teamA == teamB) {
            teamA = teamA+1;
            if (teamA == 5) {
                teamA = 0;
            }
        }
        iconTeamA(teamA);
        iconTeamA2(teamA);
    }

    public void methodTeamB(View v) {
        teamB = teamB+1;
        if (teamB == 5) {
            teamB = 0;
        }
        if (teamA == teamB) {
            teamB = teamB+1;
            if (teamB == 5) {
                teamB = 0;
            }
        }
        iconTeamB(teamB);
        iconTeamB2(teamB);
    }

    public void iconTeamA(int val) {
        ImageView whoamiwith = (ImageView)findViewById(R.id.team_a_logo);
        whoamiwith.setImageResource(this.images[val]);
    }

    public void iconTeamA2(int val) {
        ImageView whoamiwith = (ImageView)findViewById(R.id.team_a_logo2);
        whoamiwith.setImageResource(this.images[val]);
    }

    public void iconTeamB(int val) {
        ImageView whoamiwith = (ImageView)findViewById(R.id.team_b_logo);
        whoamiwith.setImageResource(this.images[val]);
    }

    public void iconTeamB2(int val) {
        ImageView whoamiwith = (ImageView)findViewById(R.id.team_b_logo2);
        whoamiwith.setImageResource(this.images[val]);
    }

    /**
     * DayNight change theme
     */

    public void DNButton(View v) {
        if (DayNight) {
            DayNight = false;
            imch(R.drawable.im11,R.id.ph11);
            imch(R.drawable.im12,R.id.ph12);
            imch(R.drawable.im13,R.id.ph13);
        }
        else
        {
            DayNight = true;
            imch(R.drawable.im11n,R.id.ph11);
            imch(R.drawable.im12n,R.id.ph12);
            imch(R.drawable.im13n,R.id.ph13);
        }
    }

    public void imch (int val, int val2) {
        ImageView whoamiwith = (ImageView)findViewById(val2);
        whoamiwith.setImageResource(val);
    }

    /**
     * Display Counters.
     */
    public void ConterInc_Matrix(int val, int val2) {
        com.example.lsourtzo.scorekeeper.TextMatrix scoreView = (com.example.lsourtzo.scorekeeper.TextMatrix) findViewById(val2);
        scoreView.setText(String.valueOf(val));
    }
    public void ConterInc(int val, int val2) {
        com.example.lsourtzo.scorekeeper.TextAll scoreView = (com.example.lsourtzo.scorekeeper.TextAll) findViewById(val2);
        scoreView.setText(String.valueOf(val));
    }
    public void FF_FC_MARKER(char val, int val2) {
        com.example.lsourtzo.scorekeeper.TextAll scoreView = (com.example.lsourtzo.scorekeeper.TextAll) findViewById(val2);
        scoreView.setText(String.valueOf(val));
    }


}

