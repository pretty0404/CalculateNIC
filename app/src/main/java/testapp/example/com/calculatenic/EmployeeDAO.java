package testapp.example.com.calculatenic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pretty Rehal on 28/02/2017.
 */

public class EmployeeDAO {
    private EmployeeDB dbh;
    private SQLiteDatabase db;
    private ArrayList<Employee> employees;

    public EmployeeDAO(Context context){
        dbh = new EmployeeDB(context);
    }

    public void open(){
        db = dbh.getWritableDatabase();
    }

    public Boolean addEmployee(String firstname, String lastname, String ni){
        ContentValues values = new ContentValues();
        values.put(EmployeeContract.column_first_name, firstname);
        values.put(EmployeeContract.column_last_name, lastname);
        values.put(EmployeeContract.column_ni_number, ni);
        long newRowID = db.insert(EmployeeContract.table_name_employee,null,values);
        if (newRowID == -1){
            return false;
        }
        else{
            return true;
        }
    }//end addEmployee

    public List<Employee> getEmps(List<Employee> employees){
        Cursor cursor = db.query(EmployeeContract.table_name_employee, null, null, null, null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String firstName = cursor.getString(EmployeeContract.column_index_firstname);
            String lastName = cursor.getString(EmployeeContract.column_index_lastname);
            String ni = cursor.getString(EmployeeContract.column_index_ninumber);
            employees.add(new Employee(firstName, lastName, ni));
            cursor.moveToNext();
        }
        return employees;
    }
}
