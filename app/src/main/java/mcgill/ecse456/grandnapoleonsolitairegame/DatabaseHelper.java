package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "ScoreTable.db";
    public static final String TABLE_NAME = "ScoreTable";
    public static final String C_ID = "id";
    public static final String C_NAME = "name";
    public static final String C_TIME = "time";
    public static final String C_STEP = "step";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table to store
        String query = "CREATE TABLE " + TABLE_NAME + "(" + C_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C_NAME + " TEXT,"
                + C_TIME + " TEXT,"
                + C_STEP + " TEXT" + ")";
        db.execSQL(query); //execute the sql query
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //Delete the current table
        onCreate(db); //create new one
    }

    // Add a new scoreRecord to database
    public void addScoreRecord(ScoreTable scoreRecord) {
        // set a bunch of value of different column
        ContentValues values = new ContentValues();
        values.put(C_NAME, scoreRecord.get_name()); // Store name to column
        values.put(C_TIME, scoreRecord.get_time());
        values.put(C_STEP, scoreRecord.get_step());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values); // Insert new row to table
        db.close(); //Give memory back to android
    }

    // Delete a scoreRecord from database
    public void deleteScoreRecord() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        return c;
    }
}