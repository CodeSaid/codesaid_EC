package com.codesaid.lib_ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * Created By codesaid
 * On :2020-04-13 20:44
 * Package Name: com.codesaid.lib_ec.database
 * desc:
 */
public class ReleaseOpenHelper extends DaoMaster.OpenHelper{

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
