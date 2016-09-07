package com.spizzyrichlife.ussrpg_v01;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CharacterSelectionActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        listView = (ListView) findViewById(R.id.pcList);
        populateListView();
    }

    public void populateListView() {
        Cursor cursor = DBHelper.getInstance(CharacterSelectionActivity.this).getCharacterPreviews();
        String[] fromNames = new String[] {DBHelper.COL_NAME, DBHelper.COL_XP, DBHelper.COL_HP, DBHelper.COL_SP, DBHelper.COL_CP};
        int[] toViews = new int[] {R.id.pc_lv_character_name, R.id.pc_lv_character_xp, R.id.pc_lv_character_hp, R.id.pc_lv_character_sp, R.id.pc_lv_character_cp};
        SimpleCursorAdapter playerCharCursorAdapter;
        playerCharCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.pc_lv_item_layout, cursor, fromNames, toViews, 0);
        ListView pcList = (ListView) findViewById(R.id.pcList);
        pcList.setAdapter(playerCharCursorAdapter);
    }
}
