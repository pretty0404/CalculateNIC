package testapp.example.com.calculatenic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployment extends Activity {

    EmployeeDAO empDAO;
    EditText employeeNI;
    EditText employer;
    EditText nature;
    EditText earnings;
    Button addEmployment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employment);
    }

    @Override
    protected void onResume(){
        super.onResume();
        empDAO = new EmployeeDAO(this);
        empDAO.open();
        findViews();
        setListeners();
    }

    public void findViews(){
        addEmployment = (Button) findViewById(R.id.addemptbtn);
        employeeNI = (EditText) findViewById(R.id.employeenumber);
        employer = (EditText) findViewById(R.id.employerfield);
        nature = (EditText) findViewById(R.id.nature);
        earnings = (EditText) findViewById(R.id.earnings);
    }

    public void setListeners(){
        addEmployment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empDAO.addEmployment(employeeNI.getText().toString(), employer.getText().toString(), nature.getText().toString(), Double.parseDouble(earnings.getText().toString()))){
                    Toast.makeText(AddEmployment.this, "Employment Added Successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddEmployment.this, "Employment NOT added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_employment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_item_go_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
