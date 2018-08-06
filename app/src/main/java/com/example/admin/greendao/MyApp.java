package com.example.admin.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import greendao.DaoMaster;
import greendao.DaoSession;

public class MyApp extends Application {
    public static MyApp instances;
    private DaoMaster.DevOpenHelper mUser;
    private SQLiteDatabase mDatabase;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }

    public static MyApp getInstances() {
        return instances;
    }

    private void setDatabase() {
        mUser = new DaoMaster.DevOpenHelper(MyApp.this, "user", null);
        mDatabase = mUser.getWritableDatabase();
        mDaoMaster = new DaoMaster(mDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
