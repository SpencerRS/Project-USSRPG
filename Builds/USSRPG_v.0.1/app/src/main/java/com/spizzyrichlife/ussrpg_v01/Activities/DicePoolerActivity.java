package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spizzyrichlife.ussrpg_v01.R;

//This is where players will be able to roll dice and will be affected by which character is currently selected as the active character.
//TODO: Allow user to roll dice //TODO: Allow player to roll dice based on Active Character. //TODO: Allow player to "play" cards to the cup (Gesture control?)
public class DicePoolerActivity extends AppCompatActivity {

    EditText blues;
    EditText greens;
    EditText yellows;
    EditText blacks;
    EditText purples;
    EditText reds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_pooler);

        //Find roll nums
        blues = (EditText) findViewById(R.id.blueDiceET);
        greens = (EditText) findViewById(R.id.greenDiceET);
        yellows = (EditText) findViewById(R.id.yellowDiceET);
        blacks = (EditText) findViewById(R.id.blackDiceET);
        purples = (EditText) findViewById(R.id.purpleDiceET);
        reds = (EditText) findViewById(R.id.redDiceET);

        Button rollButton = (Button) findViewById(R.id.rollDiceButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DicePoolerActivity.this, RollResultsActivity.class);
                //Pass numbers of dice to roll, store as array
                int[] diceBundle = {Integer.parseInt(blues.toString()), Integer.parseInt(greens.toString()), Integer.parseInt(yellows.toString()), Integer.parseInt(blacks.toString()), Integer.parseInt(purples.toString()), Integer.parseInt(reds.toString())};
                intent.putExtra("dice", diceBundle);
                startActivity(intent);
            }
        });
    }
}
