package com.ncu.zhuoyuejike.fuli.payrollsystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Star Sky on 2016/8/28.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DatabaseHelper.class.getName();

    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "payroll_db";

   public DatabaseHelper(Context context){
       super(context,DATABASE_NAME,null,DatabaseSchema.DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.i(LOG_TAG,"Upgrading database from version"
//                + oldVersion + "to" + newVersion);
//
//        if (oldVersion > newVersion) {
//            throw new IllegalArgumentException("Database downgrades are not supported at the moment");
//        }
//
//        while(oldVersion < newVersion){
//            try {
//                Method method = MigrationHelper.class.getDeclaredMethod("upgradeDbToVersion" + (oldVersion+1), SQLiteDatabase.class);
//                Object result = method.invoke(null, db);
//                oldVersion = Integer.parseInt(result.toString());
//
//            } catch (NoSuchMethodException e) {
//                String msg = String.format("Database upgrade method upgradeToVersion%d(SQLiteDatabase) definition not found ", newVersion);
//                Log.e(LOG_TAG, msg, e);
//                throw new RuntimeException(e);
//            }  catch (IllegalAccessException e) {
//                String msg = String.format("Database upgrade to version %d failed. The upgrade method is inaccessible ", newVersion);
//                Log.e(LOG_TAG, msg, e);
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e){
//                throw new RuntimeException(e);
//            }
    }
}
