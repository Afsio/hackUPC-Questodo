package com.pecesteam.questodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pecesteam.questodo.sourceClasses.Profile;

/**
 * Created by ARNAU on 09/10/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuestodoDB";

    private static final String TABLE_USER = "user";
    private static final String TABLE_ACHIEVEMENTS = "achievements";
    private static final String TABLE_PROJECTS = "projects";
    private static final String TABLE_TASKS = "tasks";

    private static final String KEY_NAME = "name";
    private static final String KEY_LEVEL = "level";

    private static final String KEY_ACHIDESCRIPTION = "achi_description";
    private static final String KEY_ACHINAME = "achi_name";
    private static final String KEY_ACHIDONE = "achi_done";
    private static final String KEY_ACHIIMAGE = "achi_image";

    private static final String KEY_PROJNAME = "proj_name";

    private static final String KEY_TASKNAME = "task_name";
    private static final String KEY_TASKTYPE = "task_type";
    private static final String KEY_TASKDESCRIPTION = "task_description";
    private static final String KEY_TASKLIST = "task_list";
    private static final String KEY_TASKPROJECT = "task_project";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_NAME + " TEXT PRIMARY KEY,"
                + KEY_LEVEL + " INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ACHIEVEMENTS + "("
                + KEY_ACHINAME + " TEXT PRIMARY KEY," + KEY_ACHIDESCRIPTION + " TEXT,"
                + KEY_ACHIIMAGE + " INTEGER," + KEY_ACHIDONE + " INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PROJECTS + "("
                + KEY_PROJNAME + " TEXT PRIMARY KEY," + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TASKS + "("
                + KEY_TASKNAME + " TEXT PRIMARY KEY," + KEY_TASKDESCRIPTION + " TEXT,"
                + KEY_TASKPROJECT + " TEXT FOREIGN KEY, (" + KEY_TASKPROJECT + ") REFERENCES "
                + TABLE_PROJECTS + "(" + KEY_PROJNAME + ")" + KEY_TASKLIST + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACHIEVEMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        onCreate(db);
    }

    public void addUser(Profile user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_LEVEL, user.getName());

        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public Profile getUser() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] {KEY_NAME, KEY_LEVEL },
                KEY_NAME + "=?", new String[] {}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Profile user = new Profile()
        // return contact
        return contact;
    }
    public int updateUser(Profile user) {}
    public void deleteUser(Profile user) {}
}
