package testapp.example.com.calculatenic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pretty Rehal on 28/02/2017.
 */

public class EmployeeDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String type = "text";
    private static final String comma = ",";
    public static final String DATABASE_NAME = "employees.db";
    private static final String CREATE_EMPLOYEES = "CREATE TABLE EMPLOYEESTABLE (first_name TEXT, last_name TEXT, ni_number TEXT);";// + EmployeeContract.table_name_employee + " (" + EmployeeContract.column_first_name + type  + comma + EmployeeContract.column_last_name + type + comma + EmployeeContract.column_ni_number + type + ")";
    private static final String DELETE_EMPLOYEES = "DROP TABLE IF EXISTS " + EmployeeContract.table_name_employee;

    public EmployeeDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEES);//create all employees
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_EMPLOYEES);//delete all employees
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }




}
