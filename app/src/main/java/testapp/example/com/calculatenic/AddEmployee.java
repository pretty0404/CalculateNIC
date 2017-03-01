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

public class AddEmployee extends Activity{

    private EmployeeDAO employeeDAO;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText niField;
    private Button enterbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        //setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_employee, menu);
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();
        employeeDAO = new EmployeeDAO(this);
        employeeDAO.open();
        firstNameField = (EditText) findViewById(R.id.enterfirst);
        lastNameField = (EditText) findViewById(R.id.enterlast);
        niField = (EditText) findViewById(R.id.enterNI);
        setListeners();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menu_item_go_home){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected


    public void setListeners(){
        enterbutton = (Button) findViewById(R.id.enterbutton);
        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //employeeDAO.addEmployee(firstNameField.getText().toString(), lastNameField.getText().toString(), niField.getText().toString());
                if(employeeDAO.addEmployee(firstNameField.getText().toString(), lastNameField.getText().toString(), niField.getText().toString())){
                    Toast.makeText(AddEmployee.this, "Employee Added Successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddEmployee.this, "Employee NOT added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
