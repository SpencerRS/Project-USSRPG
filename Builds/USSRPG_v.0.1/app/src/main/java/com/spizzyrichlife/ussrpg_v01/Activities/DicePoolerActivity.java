package com.spizzyrichlife.ussrpg_v01.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spizzyrichlife.ussrpg_v01.R;

//This is where players will be able to roll dice and will be affected by which character is currently selected as the active character.
public class DicePoolerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_pooler);
    }
}