package com.spizzyrichlife.ussrpg_v01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//This is where players will be able to roll dice and will be affected by which character is currently selected as the active character.
public class DicePoolerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_pooler);
    }
}
