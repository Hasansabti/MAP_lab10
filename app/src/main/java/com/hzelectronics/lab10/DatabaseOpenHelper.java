package com.hzelectronics.lab10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    public DatabaseOpenHelper(Context context) {
        super(context, "lab10.db", null, null, 1);
    }
}
