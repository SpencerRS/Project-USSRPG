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

<<<<<<< HEAD
=======
    CursorAdapter cursorAdapter = new CursorAdapter(CharacterSelectionActivity.this, cursor, 0) {
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView textView = (TextView) view.findViewById(android.R.id.text1);

            textView.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COL_NAME)));
        }
    };
>>>>>>> master

}
