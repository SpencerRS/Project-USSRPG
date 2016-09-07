package com.spizzyrichlife.ussrpg_v01;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class CharacterSelectionActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        listView = (ListView) findViewById(R.id.pcList);
    }
    Cursor cursor = DBHelper.getInstance(CharacterSelectionActivity.this).getCharacterPreviews();


}
