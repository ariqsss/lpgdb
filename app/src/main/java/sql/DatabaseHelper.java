package sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lpgdb.User;

import java.util.ArrayList;
import java.util.List;

import model.Penjualanmodel;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_ROLE = "user_role";
    //////////////////////////////
    // User table name
    private static final String TABLE_PENJUALAN = "penjualan";

    // User Table Columns names
    private static final String COLUMN_PENJUALAN_ID = "penjualan_id";
    private static final String COLUMN_PENJUALAN_NAMA = "penjualan_nama";
    private static final String COLUMN_PENJUALAN_STATUS = "penjualan_status";
    private static final String COLUMN_PENJUALAN_ALAMAT = "penjualan_alamat";
    private static final String COLUMN_PENJUALAN_JUMLAH = "penjualan_jumlah";
    private static final String COLUMN_PENJUALAN_TANGGAL = "penjualan_tanggal";
    private static final String COLUMN_PENJUALAN_PANGKALAN = "penjualan_pangkalan";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT,"  + COLUMN_USER_ROLE + " TEXT" + ")";

    private String CREATE_PENJUALAN_TABLE= "CREATE TABLE " + TABLE_PENJUALAN + "("
            +COLUMN_PENJUALAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_PENJUALAN_NAMA + " TEXT,"
            + COLUMN_PENJUALAN_STATUS +" TEXT,"
            + COLUMN_PENJUALAN_ALAMAT + " TEXT,"
            + COLUMN_PENJUALAN_JUMLAH + " TEXT,"
            + COLUMN_PENJUALAN_TANGGAL + " TEXT,"
            +COLUMN_PENJUALAN_PANGKALAN + " TEXT,"
            + "FOREIGN KEY"+"("+COLUMN_PENJUALAN_PANGKALAN+")"+" REFERENCES " + TABLE_USER +"("+COLUMN_USER_ID+")"+")";


    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_PENJUALAN_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUsername());

        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        values.put(COLUMN_USER_ROLE, user.getRole());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addPenjualan(Penjualanmodel penjualanmodel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_PENJUALAN_NAMA,penjualanmodel.getNama());
        values.put(COLUMN_PENJUALAN_STATUS,penjualanmodel.getStatus());
        values.put(COLUMN_PENJUALAN_ALAMAT,penjualanmodel.getAlamat());
        values.put(COLUMN_PENJUALAN_JUMLAH,penjualanmodel.getJumlah());
        values.put(COLUMN_PENJUALAN_TANGGAL,penjualanmodel.getTanggal());
        values.put(COLUMN_PENJUALAN_PANGKALAN,penjualanmodel.getPangkalan());


        // Inserting Row
        db.insert(TABLE_PENJUALAN, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,

                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUsername());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param name
     * @return true/false
     */

    public int checkUser(String name) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?";

        // selection argument
        String[] selectionArgs = {name};

        // query user table with condition


        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return 1;
        }

        return 0;
    }

    /**
     * This method to check user exist or not
     *
     * @param name
     * @param password
     * @return true/false
     */
    public int checkUser(String name, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?" ;

        // selection arguments
        String[] selectionArgs = {name, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        String value = null;
        String selectQuery = "SELECT user_role FROM user WHERE user_name = '" + name + "'";
        Cursor cursor2 = db.rawQuery(selectQuery, null);
        if(cursor2.moveToFirst()){
             value = cursor2.getString(cursor2.getColumnIndex("user_role"));
       }
        cursor.close();
      cursor2.close();
        db.close();
        if (cursorCount > 0) {
           if(value.equals("pangkalan")){
               return 1;
           }
            if(value.equals("agen")){
               return 2;
           }
            else{return 0;}

        }

        return 0;
    }
}