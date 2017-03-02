package testapp.example.com.calculatenic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployees extends Activity {

    private ListView empListView;
    private EmployeeDAO empDAO;
    private List<Employee> empList = new ArrayList<>();
    private ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employees);

//        empDAO = new EmployeeDAO(this);
//        empDAO.open();
//        empDAO.addEmployee("Johnny", "Applessed", "123123");
    }

    @Override
    protected void onResume() {
        super.onResume();
        empListView = (ListView) findViewById(R.id.employees_list_view);
        adapter = new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1, empList);
        empListView.setAdapter(adapter);

        empList.clear();
        empDAO = new EmployeeDAO(this);
        empDAO.open();
        empDAO.getEmps(empList);
        adapter.notifyDataSetChanged();

        empListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = empList.get(position);
                Intent intent = new Intent(getApplicationContext(), ViewEmployments.class);
                intent.putExtra(EmployeeDB.EMP_KEY,employee.getNI());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_employees, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_item_go_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.menu_item_add_emp) {
            Intent intent = new Intent(this, AddEmployee.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
