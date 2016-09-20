package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.spizzyrichlife.ussrpg_v01.R;

import java.util.ArrayList;

public class RollResultsActivity extends AppCompatActivity {
    //Member variables for # dice to roll
    int[] diceBundle;
    int blues;
    int greens;
    int yellows;
    int blacks;
    int purples;
    int reds;

    //Member variables for roll results.
    ArrayList<String[]> cupResults = new ArrayList<>();
    ArrayList<String[]> blueResults = new ArrayList<>();
    ArrayList<String[]> greenResults = new ArrayList<>();
    ArrayList<String[]> yellowResults = new ArrayList<>();
    ArrayList<String[]> blackResults = new ArrayList<>();
    ArrayList<String[]> purpleResults = new ArrayList<>();
    ArrayList<String[]> redResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_results);

        //Get intent and use it to perform dice rolls
        Intent intent = getIntent();
//        diceBundle = intent.getIntArrayExtra("dice");

        blues = intent.getIntExtra("blues",0);
        greens = intent.getIntExtra("greens",0);
        yellows = intent.getIntExtra("yellows",0);
        blacks = intent.getIntExtra("blacks",0);
        purples = intent.getIntExtra("purples",0);
        reds = intent.getIntExtra("reds",0);
        //store numbers as member variables.
//        blues = diceBundle[0];
//        greens = diceBundle[1];
//        yellows = diceBundle[2];
//        blacks = diceBundle[3];
//        purples = diceBundle[4];
//        reds = diceBundle[5];

        //Roll and store results of each roll
        DiceRoller roller = new DiceRoller();
        blueResults = roller.rollBlue(blues);
        greenResults = roller.rollGreen(greens);
        yellowResults = roller.rollYellow(yellows);
        blackResults = roller.rollBlack(blacks);
        purpleResults = roller.rollPurple(purples);
        redResults = roller.rollRed(reds);

    }

}
