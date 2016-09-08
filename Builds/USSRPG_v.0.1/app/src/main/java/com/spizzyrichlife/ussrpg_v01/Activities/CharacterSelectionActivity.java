package com.spizzyrichlife.ussrpg_v01.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.R;

//This is where players view all the PCs and select their active PC TODO: add ability so select active character.
public class CharacterSelectionActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.pcList);
        populateListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    //This method can be called anytime the Character Selection list view needs to be updated.
    public void populateListView() {
        Cursor cursor = DBHelper.getInstance(CharacterSelectionActivity.this).getCharacterPreviews();
        String[] fromNames = new String[]{DBHelper.COL_NAME, DBHelper.COL_XP, DBHelper.COL_HP, DBHelper.COL_SP, DBHelper.COL_CP};
        int[] toViews = new int[]{R.id.pc_lv_character_name, R.id.pc_lv_character_xp, R.id.pc_lv_character_hp, R.id.pc_lv_character_sp, R.id.pc_lv_character_cp};
        SimpleCursorAdapter playerCharCursorAdapter;
        playerCharCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.pc_lv_item_layout, cursor, fromNames, toViews, 0);
        ListView pcList = (ListView) findViewById(R.id.pcList);
        pcList.setAdapter(playerCharCursorAdapter);
    }
}
