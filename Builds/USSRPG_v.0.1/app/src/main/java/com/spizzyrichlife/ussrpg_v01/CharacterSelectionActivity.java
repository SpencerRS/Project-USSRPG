package com.spizzyrichlife.ussrpg_v01;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CharacterSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);
    }

    Cursor cursor = DBHelper.getInstance(CharacterSelectionActivity.this).getCharacterPreviews();

    CursorAdapter cursorAdapter = new CursorAdapter(CharacterSelectionActivity.this,cursor,0) {
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView textView = (TextView)view.findViewById(android.R.id.text1);

            textView.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COL_NAME)));
        }
    };

    //HOWTO Cursor Adapter
//    //Get cursor
//    Cursor cursor = ExampleSQLiteOpenHelper.getInstance(MainActivity.this).getExampleList();
//
//    //Define CursorAdapter
//    CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,cursor,0) {
//        @Override
//        public View newView(Context context, Cursor cursor, ViewGroup parent) {
//            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
//        }
//
//        @Override
//        public void bindView(View view, Context context, Cursor cursor) {
//            TextView textView = (TextView)view.findViewById(android.R.id.text1);
//
//            textView.setText(cursor.getString(cursor.getColumnIndex(ExampleSQLiteOpenHelper.COL_ITEM_NAME)));
//        }
//    };
//
//    //Set adapter
//    ListView listView = (ListView)findViewById(R.id.example_list_view);
//    listView.setAdapter(cursorAdapter);
}
