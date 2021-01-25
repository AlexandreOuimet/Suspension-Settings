package com.example.suspension.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SUSPENSION_SETTINGS = "SUSPENSION_SETTINGS";
    public static final String COLUMN_FORK_REBOUND = "FORK_REBOUND";
    public static final String COLUMN_FORK_COMPRESSION = "FORK_COMPRESSION";
    public static final String COLUMN_SHOCK_REBOUND = "SHOCK_REBOUND";
    public static final String COLUMN_SHOCK_LOW_COMP = "SHOCK_LOW_COMP";
    public static final String COLUMN_SHOCK_HIGH_COMP = "SHOCK_HIGH_COMP";
    public static final String COLUMN_SETTING_NAME = "SETTING_NAME";
    public static final String ID_INTEGER = "ID INTEGER";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "suspension.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableStatement = "CREATE TABLE " + SUSPENSION_SETTINGS + " (" + ID_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FORK_REBOUND + " INTEGER, " + COLUMN_FORK_COMPRESSION + " INTEGER, " + COLUMN_SHOCK_REBOUND + " INTEGER," +
                " " + COLUMN_SHOCK_LOW_COMP + " INTEGER, " + COLUMN_SHOCK_HIGH_COMP +
                " INTEGER, " + COLUMN_SETTING_NAME + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(DataModel dataModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SETTING_NAME, dataModel.getSettingName());
        cv.put(COLUMN_FORK_REBOUND, dataModel.getForkRebound());
        cv.put(COLUMN_FORK_COMPRESSION, dataModel.getForkCompression());
        cv.put(COLUMN_SHOCK_REBOUND, dataModel.getShockRebound());
        cv.put(COLUMN_SHOCK_LOW_COMP, dataModel.getShockLowCompression());
        cv.put(COLUMN_SHOCK_HIGH_COMP, dataModel.getShockHighCompression());

        long insert = db.insert(SUSPENSION_SETTINGS, null, cv);
        return insert != -1;
    }

    public List<DataModel> getSuspensionSettings(){
        List<DataModel> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + SUSPENSION_SETTINGS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            // if their are results, I want to loop through them.
            do {
                int id = cursor.getInt(0);
                int fRebound = cursor.getInt(1);
                int fCompression = cursor.getInt(2);
                int sRebound = cursor.getInt(3);
                int sLowComp = cursor.getInt(4);
                int sHighComp = cursor.getInt(5);
                String settingName = cursor.getString(6);

                DataModel dataModel = new DataModel(id, fRebound, fCompression, sRebound, sLowComp, sHighComp, settingName);
                returnList.add(dataModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return returnList;
    }
}
