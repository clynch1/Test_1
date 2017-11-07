package whisc.test_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Connor on 11/6/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TabeData.TableInfo.TABLE_NAME + "(" + TabeData.TableInfo.USER_NAME + "TEXT," + TabeData.TableInfo.USER_PASS + "TEXT );";

    public DatabaseOperations(Context context) {
        super(context, TabeData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Databse Operations", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(DatabaseOperations dop, String name, String pass) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TabeData.TableInfo.USER_NAME, name);
        cv.put(TabeData.TableInfo.USER_PASS, pass);
        long k = SQ.insert(TabeData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations", "One Row Inserted");

    }

}
