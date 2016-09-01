package com.spizzyrichlife.ussrpg_v01;

/**
 * Created by SpizzyRich on 8/30/16.
 */

public class DBHelper {
    //TODO: Set up Database using DB Helper how to.

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "USSRPG";
    public static final String TABLE_NAME_PC = "Player_Characters";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "Name";
    public static final String COL_XP = "XP";
    public static final String COL_HP = "HP";
    public static final String COL_SP = "SP";
    public static final String COL_CP = "CP";
    public static final String COL_LOCATION_ID = "Location_id";
    //                                   ^Repeat as needed^

//    public static final String[] COLUMN_SELECTION = {COL_<COLUMN_NAME>, COL_<COLUMN_NAME>};
    //                                            ^ Add columns to get seperated by commas^

    private static final String CREATE_PC_TABLE =
            "CREATE TABLE " + TABLE_NAME_PC +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_XP + " INTEGER " +
                    COL_HP + " INTEGER " +
                    COL_SP + " INTEGER " +
                    COL_CP + " INTEGER " +
                    COL_LOCATION_ID +" INTEGER )";

    private static DBHelper mInstance;

//    public static DBHelper getInstance(Context context) {
//        if (mInstance == null) {
//            mInstance = new DBHelper(context.getApplicationContext());
//        }
//        return mInstance;
//    }
//
//    private DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_ < TABLE_NAME >);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        this.onCreate(db);
//    }
//
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
//
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

//HOW TO: Set up a DB helper
//private static final int DATABASE_VERSION = 1;
//    public static final String DATABASE_NAME = "<Database Name>";
//    public static final String TABLE_NAME = "<Table Name>";
//
//    public static final String COL_ID = "_id";
//    public static final String COL_<COLUMN_NAME> = "<Column Name>";
//    //                                   ^Repeat as needed^
//
//    public static final String[] COLUMN_SELECTION = {COL_<COLUMN_NAME>, COL_<COLUMN_NAME>};
//    //                                            ^ Add columns to get seperated by commas^
//
//    private static final String CREATE_<TABLE_NAME>=
//            "CREATE TABLE "+TABLE_NAME+
//            "("+
//    COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
//    COL_<COLUMN_NAME>+" <DATA TYPE>, "+
//    COL_<OTHER_COLUMNES>+" TEXT )";
//
//    private static <DBHelperClassName>mInstance;
//
//    public static <DBHelperClassName> getInstance(Context context) {
//        if (mInstance == null) {
//            mInstance = new <DBHelperClassName> (context.getApplicationContext());
//        }
//        return mInstance;
//    }
//
//    private DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_<TABLE_NAME>);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        this.onCreate(db);
//    }
//
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
//
//    public String getDescriptionById(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME,
//                new String[]{COL_<COLUMN_NAME>},
//                COL_ID + " = ?",
//                new String[]{String.valueOf(id)},
//                null,
//                null,
//                null,
//                null);
//
//        if (cursor.moveToFirst()) {
//            return cursor.getString(cursor.getColumnIndex(COL_<COLUMN_NAME>));
//        } else {
//            return "No Description Found";
//        }
//    }
}
