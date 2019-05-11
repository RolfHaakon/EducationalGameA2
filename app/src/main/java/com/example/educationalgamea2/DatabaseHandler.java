package com.example.educationalgamea2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/*
Parts of code from
https://www.javatpoint.com/android-sqlite-tutorial
*/


public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "game";

    // Table name
    private static final String TABLE_SCORE = "score";

    // Score Table Columns names
    private static final String KEY_ID_SCORE = "_id";
    private static final String KEY_SCORE = "score_value";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_SCORE + "("
                + KEY_ID_SCORE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_SCORE + " TEXT" + ")";

        db.execSQL(CREATE_SCORE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);

        // Create tables again
        onCreate(db);
    }

    // Adding new score
    public void addScore(int score) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_SCORE, score); // score value

        // Inserting Values
        db.insert(TABLE_SCORE, null, values);

        db.close();

    }

    // Getting All Scores
    public String[] getAllScores() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SCORE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        int i = 0;

        String[] data = new String[cursor.getCount()];

        while (cursor.moveToNext()) {

            data[i] = cursor.getString(1);

            i = i++;

        }
        cursor.close();
        db.close();
        // return score array
        return data;
    }
















    /*private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "highscoreDB";
    private static final String TABLE_HIGHSCORE = "highscore";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SCORE = "score";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HIGHSCORE_TABLE = "CREATE TABLE " + TABLE_HIGHSCORE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SCORE + " TEXT" + ")";
        db.execSQL(CREATE_HIGHSCORE_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORE);
        // Create tables again
        onCreate(db);
    }
    // code to add the new contact
    void addScore(DbHelper dbHelper) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, dbHelper.getID()); // ID
        values.put(KEY_NAME, dbHelper.getName()); // Name
        values.put(KEY_SCORE, dbHelper.getScore()); // Score

        // Inserting Row
        db.insert(TABLE_HIGHSCORE, null, values);
        //2nd argument is String containing nullColumnHack

        db.close(); // Closing database connection
    }

    String returnString(DbHelper dbHelper) {
        String logasd = dbHelper.getID() +  dbHelper.getName() +
                dbHelper.getScore();
        String selectQuery = "SELECT  * FROM " + TABLE_HIGHSCORE + "LIMIT 5";
        return logasd;


    }

    *//*public void sortTable(DbHelper dbHelper){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        *//**//*values.put(KEY_NAME, dbHelper.getName());

        values.put(KEY_SCORE, dbHelper.getScore());*//**//*
        db.query(TABLE_HIGHSCORE, null, null, null, null, null, KEY_SCORE + " DESC, " + KEY_NAME + " ASC", "5");

    }*//*




    *//*public void addScore(DbHelper dbHelper) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.beginTransaction();
            try {
                ContentValues values = new ContentValues();
                values.put(KEY_NAME, dbHelper.getName());
                values.put(KEY_SCORE, dbHelper.getScore());
                db.insert(TABLE_HIGHSCORE, null, values);

                db.execSQL("DELETE FROM Dbhelper WHERE _id NOT IN"+
                                " (SELECT _id FROM name ORDER BY _score DESC LIMIT 5)");

                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } finally {
            db.close();
        }
    }*//*








    // code to get highscore in a list view
    public List<DbHelper> getAllHighscores() {
        List<DbHelper> highscoreList = new ArrayList<DbHelper>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HIGHSCORE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DbHelper highscore = new DbHelper();
                highscore.setID(Integer.parseInt(cursor.getString(0)));
                highscore.setName(cursor.getString(1));
                highscore.setScore(cursor.getInt(2));
                // Adding contact to list
                highscoreList.add(highscore);
            } while (cursor.moveToNext());
        }

        // return contact list
        return highscoreList;
    }

    DbHelper getPlayerScore(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HIGHSCORE, new String[] { KEY_ID,
                        KEY_NAME, KEY_SCORE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DbHelper Player = new DbHelper(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2));
        // return contact
        return Player;
    }


    *//*public void addhmLeaderboard(SQLiteDatabase db, String rank, String score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_RANK, rank);
        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_NAME3, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }*//*

    *//*public void sortDB () {
        SQLiteDatabase db = this.getReadableDatabase();
        db.query(TABLE_HIGHSCORE, columns, null, null, null,null,KEY_SCORE + " DESC");

    }*//*



*/

}
