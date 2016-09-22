package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spizzyrichlife.ussrpg_v01.DiceRoller;
import com.spizzyrichlife.ussrpg_v01.R;

import java.util.ArrayList;
import java.util.Arrays;

public class RollResultsActivity extends AppCompatActivity {

    TextView successBrand;
    TextView successTV;
    TextView advantageBrand;
    TextView advantageTV;
    TextView diceFacesTV;

    //Set up space to track result totals.
    int success = 0;
    int advantage = 0;
    ArrayList<String> diceFaces = new ArrayList<>();

    //Member variables for # dice to roll
    int[] diceBundle;
    int blues;
    int greens;
    int yellows;
    int blacks;
    int purples;
    int reds;

    //Member variables for roll results.
    ArrayList<ArrayList<String[]>> cupResults = new ArrayList<>();
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
        successBrand = (TextView) findViewById(R.id.successBrand);
        successTV = (TextView) findViewById(R.id.successesTV);
        advantageBrand = (TextView) findViewById(R.id.advantageBrand);
        advantageTV = (TextView) findViewById(R.id.advantagesTV);
        diceFacesTV = (TextView) findViewById(R.id.diceFaces);


        //Get intent and use it to perform dice rolls
        Intent intent = getIntent();
//        diceBundle = intent.getIntArrayExtra("dice");

        blues = intent.getIntExtra("blues", 0);
        greens = intent.getIntExtra("greens", 0);
        yellows = intent.getIntExtra("yellows", 0);
        blacks = intent.getIntExtra("blacks", 0);
        purples = intent.getIntExtra("purples", 0);
        reds = intent.getIntExtra("reds", 0);
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

        //Bundle all roll results into Cup Results
        cupResults.add(blueResults);
        cupResults.add(greenResults);
        cupResults.add(yellowResults);
        cupResults.add(blackResults);
        cupResults.add(purpleResults);
        cupResults.add(redResults);

        //Calculate successes
        getSuccesses(blueResults);
        getSuccesses(greenResults);
        getSuccesses(yellowResults);
        getSuccesses(blackResults);
        getSuccesses(purpleResults);
        getSuccesses(redResults);

        //Calculate advantages
        getAdvantages(blueResults);
        getAdvantages(greenResults);
        getAdvantages(yellowResults);
        getAdvantages(blackResults);
        getAdvantages(purpleResults);
        getAdvantages(redResults);

        //Accumulate dice face results.
        getDiceFaces("Blue", blueResults);
        getDiceFaces("Green", greenResults);
        getDiceFaces("Yellow", yellowResults);
        getDiceFaces("Black", blackResults);
        getDiceFaces("Purple", purpleResults);
        getDiceFaces("Red", redResults);

        successTV.setText(Integer.toString(success));
        advantageTV.setText(Integer.toString(advantage));
        String diceFaceString = Arrays.toString(diceFaces.toArray());
        diceFacesTV.setText((diceFaceString.substring(1, diceFaceString.length()-1).trim()));


    }

    //Get every success String (the second string in each String[] in the ArrayList)
    public void getSuccesses(ArrayList<String[]> results) {
        for (int i = 0; i < results.size(); i++) {
            success += Integer.parseInt(results.get(i)[1]);
        }
    }

    //Get every advantage String (the third string in each String[] in the ArrayList)
    public void getAdvantages(ArrayList<String[]> results) {
        for (int i = 0; i < results.size(); i++) {
            advantage += Integer.parseInt(results.get(i)[2]);
        }
    }

    //Get every dice side String (the first string in each String[] in the ArrayList)
    public void getDiceFaces(String color, ArrayList<String[]> results) {
        for (int i = 0; i < results.size(); i++) {
            diceFaces.add("   " + color + ": " + (results.get(i)[0]));
        }
    }

}



