package com.quaere.deepak.quaereshinecity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by deepak sachan on 8/26/2015.
 */
@DatabaseTable(tableName = "UserProfile")
public class UserProfile {
    public static final String TAG = UserProfile.class.getSimpleName();
    public static final String FIELD_ID = "id";
    @DatabaseField(id = true)
    private int id ;
    @DatabaseField
    private String UserName;
    @DatabaseField
    private String UserPassword;

    public UserProfile(String userName, String userPassword) {
        this.UserName = userName;
        this.UserPassword = userPassword;

    }
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String userName){
        this.UserName= userName;
    }
    public String getUserPassword(){
        return UserPassword;
    }
    public void setUserPassword(String userPassword){
        this.UserPassword = userPassword;
    }
}
