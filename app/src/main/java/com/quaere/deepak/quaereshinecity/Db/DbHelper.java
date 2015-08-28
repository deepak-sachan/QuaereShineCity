package com.quaere.deepak.quaereshinecity.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.quaere.deepak.quaereshinecity.DbTable.UserProfile;

import java.sql.SQLException;

/**
 * Created by deepak sachan on 8/26/2015.
 */
public class DbHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "myshinecity.db";
    private static final int DATABASE_VERSION = 6;

    private Dao<UserProfile,Integer> userProfiles = null;
    private RuntimeExceptionDao<UserProfile,Integer> StringRuntimeExceptionDao= null;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource cs) {
        try {
            TableUtils.createTable(cs, UserProfile.class);
        } catch (SQLException e) {
            Log.e(TAG, "create table ..........");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource cs, int i, int i1) {
        try {
            TableUtils.dropTable(cs, UserProfile.class, true);
        } catch (SQLException e) {
            Log.e(TAG,"drop table .........");
        }
    }

    public Dao<UserProfile,Integer> geUserProfilesDao() throws SQLException{
        if(userProfiles == null){
            userProfiles = getDao(UserProfile.class);
        }
        return userProfiles;
    }


    @Override
    public void close() {
        super.close();
        userProfiles=null;
    }
}

