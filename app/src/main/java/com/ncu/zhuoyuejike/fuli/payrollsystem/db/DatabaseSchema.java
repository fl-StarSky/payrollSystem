package com.ncu.zhuoyuejike.fuli.payrollsystem.db;

import android.provider.BaseColumns;

/**
 * 设计数据库模式
 */
public class DatabaseSchema {

    public static final int DATABASE_VERSION = 1;

    private DatabaseSchema(){}


    public interface CommonColumns extends BaseColumns{
        public static final String COLUMN_UID           = "uid";
        public static final String COLUMN_CREATED_AT    = "created_at"; //创建
        public static final String COLUMN_MODIFIED_AT   = "modified_at";    //修改
    }
}
