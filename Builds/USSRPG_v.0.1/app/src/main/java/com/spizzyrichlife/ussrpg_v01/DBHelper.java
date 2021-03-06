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
    //Keep Column Strings
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "Name";
    public static final String COL_XP = "XP";
    public static final String COL_HP = "HP";
    public static final String COL_SP = "SP";
    public static final String COL_CP = "CP";

//    public static final String COL_LOCATION_ID = "Location_id";

    //    public static final String COL_<COLUMN_NAME> = "<Column_Name>"
    //                                   ^Repeat as needed^
// Get Character preview (Name, XP, HP, SP, CP)
    public static final String[] CHARACTER_COLUMN_SELECTION = {COL_ID, COL_NAME, COL_XP, COL_HP, COL_SP, COL_CP};

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

    //TODOne: Transition to object-accepting format
    //TODO: Check that name is unique before adding to DB.
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

        // Insert the row into the table
        db.insert(TABLE_NAME_PC, null, values);
    }


    //Gets character previews for PC list view.
    public Cursor getCharacterPreviews() {
        SQLiteDatabase db = this.getReadableDatabase();
//
        Cursor cursor = db.query(TABLE_NAME_PC, // a. table
                CHARACTER_COLUMN_SELECTION, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    //    HOW TO: Search specific info
    public Cursor getSearchResults(String search) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_PC,
                CHARACTER_COLUMN_SELECTION,
                COL_NAME + " LIKE ? OR " + COL_XP + " LIKE ?",
                new String[]{"%" + search + "%", "%" + search + "%"},
                null,
                null,
                null,
                null);
        return cursor;
    }

    // Using this to populate fields in Character View Activity based on which character is clicked.
    public Cursor getCharacterByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_PC,
                CHARACTER_COLUMN_SELECTION,
                COL_NAME + " LIKE ?",
                new String[]{"%" + name + "%"},
                null,
                null,
                null,
                null);
        return cursor;
    }

    //Grabs a character by its _id and returns it as a Player Character Object.
    public PlayerCharacter getActiveCharacter(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_PC,
                CHARACTER_COLUMN_SELECTION,
                COL_ID + " =?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        //TODO: Check that this is pulling the correct info successfully
        PlayerCharacter activeCharacter = new PlayerCharacter(
                cursor.getString(cursor.getColumnIndex(COL_NAME)),
                cursor.getInt(cursor.getColumnIndex(COL_XP)),
                cursor.getInt(cursor.getColumnIndex(COL_HP)),
                cursor.getInt(cursor.getColumnIndex(COL_SP)),
                cursor.getInt(cursor.getColumnIndex(COL_CP)));
        return activeCharacter;
    }

    //Delete a row from the PC table
    public void deleteRow(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_PC, COL_NAME + " = ?", new String[]{name});
    }
}

//TODONot: Fix this getter
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
//    public void seedPCTable() {
//        if (getCharacterPreviews() == null) {
//            SQLiteDatabase db = getWritableDatabase();
//            ContentValues values = new ContentValues();
//            values.put(COL_NAME, "Melkor");
//            values.put(COL_XP, 27);
//            values.put(COL_HP, 10);
//            values.put(COL_SP, 10);
//            values.put(COL_CP, 1);
//            db.insert(TABLE_NAME_PC, null, values);
//        }
//    }
