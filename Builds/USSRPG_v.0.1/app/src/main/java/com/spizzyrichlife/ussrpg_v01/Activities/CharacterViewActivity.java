package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.R;

public class CharacterViewActivity extends AppCompatActivity {
    TextView nameSpace;
    TextView xpSpace;
    TextView hpSpace;
    TextView spSpace;
    TextView cpSpace;

    //TODO: get intents and update view with values
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);
        nameSpace = (TextView) findViewById(R.id.nameValue);
        xpSpace = (TextView) findViewById(R.id.xpValue);
        hpSpace = (TextView) findViewById(R.id.hpValue);
        spSpace = (TextView) findViewById(R.id.spValue);
        cpSpace = (TextView) findViewById(R.id.cpValue);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        populateView(name);
    }

    public void populateView(String name) {
        Cursor cursor = DBHelper.getInstance(CharacterViewActivity.this).getCharacterByName(name);
        cursor.moveToFirst();


        //TODO: Pull values from cursor and set text views.
//        nameSpace.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COL_NAME)));
        nameSpace.setText(name);
//        int a=cursor.getInt(cursor.getColumnIndex(DBHelper.COL_XP))
//                ,b=cursor.getInt(cursor.getColumnIndex(DBHelper.COL_HP))
//                ,c=cursor.getInt(cursor.getColumnIndex(DBHelper.COL_SP))
//                ,d=cursor.getInt(cursor.getColumnIndex(DBHelper.COL_CP));
        xpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_XP))));
        hpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_HP))));
        spSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_SP))));
        cpSpace.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_CP))));
//        String[] fromNames = new String[]{DBHelper.COL_NAME, DBHelper.COL_XP, DBHelper.COL_HP, DBHelper.COL_SP, DBHelper.COL_CP};
//        int[] toViews = new int[]{R.id.nameValue, R.id.xpValue, R.id.hpValue, R.id.spValue, R.id.cpValue};
//        SimpleCursorAdapter playerCharCursorAdapter;
//        playerCharCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.pc_lv_item_layout, cursor, fromNames, toViews, 0);
//        ListView pcList = (ListView) findViewById(R.id.pcList);
//        pcList.setAdapter(playerCharCursorAdapter);
    }
}
