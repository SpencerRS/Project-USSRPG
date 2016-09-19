package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.R;
//This is where players go when they view a character
//TODO: Allow players to view a character's deck/cards once they are set up.
public class CharacterViewActivity extends AppCompatActivity {
    TextView nameSpace;
    TextView xpSpace;
    TextView hpSpace;
    TextView spSpace;
    TextView cpSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);
        //Find views by id
        nameSpace = (TextView) findViewById(R.id.nameValue);
        xpSpace = (TextView) findViewById(R.id.xpValue);
        hpSpace = (TextView) findViewById(R.id.hpValue);
        spSpace = (TextView) findViewById(R.id.spValue);
        cpSpace = (TextView) findViewById(R.id.cpValue);

        //Get intent and use it to populate the view
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        populateView(name);
    }

    // fills the list view with the appropriate info for the selected character.
    public void populateView(String name) {
        Cursor cursor = DBHelper.getInstance(CharacterViewActivity.this).getCharacterByName(name);
        cursor.moveToFirst();
        //TODOne: Pull values from cursor and set text views.
        nameSpace.setText(name);
        xpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_XP))));
        hpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_HP))));
        spSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_SP))));
        cpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_CP))));
    }
}
