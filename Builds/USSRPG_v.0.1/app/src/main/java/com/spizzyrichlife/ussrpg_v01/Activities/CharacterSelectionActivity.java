package com.spizzyrichlife.ussrpg_v01.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView nameSpace = (TextView) view.findViewById(R.id.pc_lv_character_name);
                DBHelper.getInstance(CharacterSelectionActivity.this).deleteRow(nameSpace.getText().toString());
                Toast.makeText(CharacterSelectionActivity.this, "Deleting " + nameSpace.getText().toString(), Toast.LENGTH_SHORT).show();
                populateListView();
                return false;
            }
        });
        //TODO: put extras in intent based on which character is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        populateListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.char_select_menu, menu);
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

        //TODO: Fix this getter
//    public PlayerCharacter getPC(int id) {
//        // Get a reference to the database
//        SQLiteDatabase db = getReadableDatabase();
//
//        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
//        String selection = "_id = ?";
//
//        // Define the selection values. The ?'s in the selection
//        String[] selectionArgs = new String[]{String.valueOf(id)};
//
//        // Make the query, getting the cursor object
//        Cursor cursor = db.query(TABLE_NAME_PC, CHARACTER_PREVIEW_COLUMN_SELECTION, selection, selectionArgs, null, null, null, null);
//
//        // With the cursor, create a new game object and return it
//        cursor.moveToFirst();
//
//        String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
//        int xp = cursor.getInt(cursor.getColumnIndex(COL_XP));
//        int hp = cursor.getInt(cursor.getColumnIndex(COL_HP));
//        int sp = cursor.getInt(cursor.getColumnIndex(COL_SP));
//        int cp = cursor.getInt(cursor.getColumnIndex(COL_CP));
//
//        return new PlayerCharacter(id, name, xp, hp, sp, cp);
//    }
        playerCharCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.pc_lv_item_layout, cursor, fromNames, toViews, 0);
        ListView pcList = (ListView) findViewById(R.id.pcList);
        pcList.setAdapter(playerCharCursorAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = DBHelper.getInstance(this).getSearchResults(query);
//            DatabaseUtils.dumpCursor(cursor);
            ((CursorAdapter) listView.getAdapter()).changeCursor(cursor);
        }
    }
}
