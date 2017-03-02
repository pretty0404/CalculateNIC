package testapp.example.com.calculatenic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployments extends Activity {

    private ListView emptListView;
    private EmployeeDAO empDAO;
    private List<Employment> emptList = new ArrayList<>();
    private ArrayAdapter<Employment> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employments);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String employee = intent.getStringExtra(EmployeeDB.EMP_KEY);

        emptListView = (ListView) findViewById(R.id.employments_list_view);
        adapter = new ArrayAdapter<Employment>(this,android.R.layout.simple_list_item_1, emptList);
        emptListView.setAdapter(adapter);

        emptList.clear();
        empDAO = new EmployeeDAO(this);
        empDAO.open();
        empDAO.getEmployments(emptList, employee);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_employments, menu);
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
