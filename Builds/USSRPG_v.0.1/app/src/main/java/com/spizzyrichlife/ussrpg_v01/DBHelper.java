package com.spizzyrichlife.ussrpg_v01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SpizzyRich on 8/30/16.
 */

public class DBHelper extends SQLiteOpenHelper {
    //TODOne: Set up Database using DB Helper how to.

    //Set up Database.
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "USSRPG";
    //Set up Player Characters Table
    public static final String TABLE_NAME_PC = "Player_Characters";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "Name";
    public static final String COL_XP = "XP";
    public static final String COL_HP = "HP";
    public static final String COL_SP = "SP";
    public static final String COL_CP = "CP";
//    public static final String COL_LOCATION_ID = "Location_id";

    //    public static final String COL_<COLUMN_NAME> = "<Column_Name>"
    //                                   ^Repeat as needed^
// Get Character preview (Name, HP, SP, XP)
    public static final String[] CHARACTER_PREVIEW_COLUMN_SELECTION = {COL_ID, COL_NAME, COL_XP, COL_HP, COL_SP, COL_CP};

    //Create Player Character Table
    private static final String CREATE_PC_TABLE =
            "CREATE TABLE " + TABLE_NAME_PC +
                    " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_XP + " INTEGER, " +
                    COL_HP + " INTEGER, " +
                    COL_SP + " INTEGER, " +
                    COL_CP + " INTEGER " +
//                   COL_LOCATION_ID +" INTEGER )";
                    ")";

    private static DBHelper mInstance;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static DBHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBHelper(context.getApplicationContext());
        }
        return mInstance;
    }

//    private DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    //TODO: Figure out why ^this is broken^
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PC_TABLE);
//          ^Repeat as needed^

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PC);
        this.onCreate(db);
    }

    //TODO: Transition to object-accepting format
//    public void createPC (PlayerCharacter newPC){
    public void createPC(PlayerCharacter newPC) {
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values and add the columns to the values
        ContentValues values = new ContentValues();
        values.put(COL_NAME, newPC.getName());
        values.put(COL_XP, newPC.getXp());
        values.put(COL_HP, newPC.getHp());
        values.put(COL_SP, newPC.getSp());
        values.put(COL_CP, newPC.getCp());

        // Insert the row into the games table
        db.insert(TABLE_NAME_PC, null, values);
    }

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

    // Adds an example character to PC table on create if there are none.
    public void seedPCTable() {
        //TODO: Add if statement to test if there is already data in the table
        if (getCharacterPreviews() == null) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_NAME, "Melkor");
            values.put(COL_XP, 27);
            values.put(COL_HP, 10);
            values.put(COL_SP, 10);
            values.put(COL_CP, 1);
            db.insert(TABLE_NAME_PC, null, values);
        }
    }

    public Cursor getCharacterPreviews() {
        SQLiteDatabase db = this.getReadableDatabase();
//
        Cursor cursor = db.query(TABLE_NAME_PC, // a. table
                CHARACTER_PREVIEW_COLUMN_SELECTION, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }



//    TODO: Add searches
//    HOW TO Read from the database
//    public Cursor getExampleList() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME, // a. table
//                COLUMN_SELECTION, // b. column names
//                null, // c. selections
//                null, // d. selections args
//                null, // e. group by
//                null, // f. having
//                null, // g. order by
//                null); // h. limit
//        return cursor;
//    }

//    HOW TO: Search specific info
//    public String getDescriptionById(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME,
//                new String[]{COL_ < COLUMN_NAME >},
//                COL_ID + " = ?",
//                new String[]{String.valueOf(id)},
//                null,
//                null,
//                null,
//                null);
//
//        if (cursor.moveToFirst()) {
//            return cursor.getString(cursor.getColumnIndex(COL_ < COLUMN_NAME >));
//        } else {
//            return "No Description Found";
//        }
//    }

}
