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
    ArrayList<Employment> employments;

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

    public Boolean addEmployment(String employee, String employer, String nature, Double earnings){
        ContentValues values = new ContentValues();
        values.put(EmploymentContract.COLUMN_NAME_EMPLOYEE, employee);
        values.put(EmploymentContract.COLUMN_NAME_EMPLOYER, employer);
        values.put(EmploymentContract.COLUMN_NAME_NATURE, nature);
        values.put(EmploymentContract.COLUMN_NAME_EARNINGS, earnings);
        long newRowId = db.insert(EmploymentContract.TABLE_NAME_EMPLOYMENT, null, values);
        if (newRowId == -1){
            return false;
        }
        else{
            return true;
        }
    }


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

    public List<Employment> getEmployments(List<Employment> empts, String emp) {

        String selection;
        if (emp != null) {
            selection = EmploymentContract.COLUMN_NAME_EMPLOYEE + " ='" + emp + "'";
        } else {
            selection = null;
        }

        Cursor cursor = db.query(EmploymentContract.TABLE_NAME_EMPLOYMENT, null,selection,null,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String employee = cursor.getString(EmploymentContract.COLUMN_INDEX_EMPLOYEE);
            String employer = cursor.getString(EmploymentContract.COLUMN_INDEX_EMPLOYER);
            String nature = cursor.getString(EmploymentContract.COLUMN_INDEX_NATURE);
            Double earnings = cursor.getDouble(EmploymentContract.COLUMN_INDEX_EARNINGS);
            empts.add(new Employment(employee, employer, nature, earnings));
            cursor.moveToNext();
        }
        return empts;
    }
}
