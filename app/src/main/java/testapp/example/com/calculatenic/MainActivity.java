package testapp.example.com.calculatenic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    Button addEmployee;
    Button addEmployment;
    Button viewEmployee;
    Button viewEmployment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByID();
        setListeners();
    }

    public void findViewsByID() {
        addEmployee = (Button) findViewById(R.id.addEmployee);
        addEmployment = (Button) findViewById(R.id.addEmployment);
        viewEmployee = (Button) findViewById(R.id.viewEmployees);
        viewEmployment = (Button) findViewById(R.id.viewEmployments);
    }

    public void setListeners() {
        addEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEmp = new Intent(MainActivity.this, AddEmployee.class);
                startActivity(addEmp);
            }
        });
        viewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewEmps = new Intent(MainActivity.this, ViewEmployees.class);
                startActivity(viewEmps);
            }
        });
    }

}
