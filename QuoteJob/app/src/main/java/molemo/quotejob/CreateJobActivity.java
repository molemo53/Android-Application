package molemo.quotejob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import molemo.quotejob.model.AddJobResource;
import molemo.quotejob.services.QouteJobServices;
import molemo.quotejob.services.impl.QouteJobServiceImpl;

/**
 * Created by tsemol01 on 2015/12/02.
 */
public class CreateJobActivity extends Activity{

    QouteJobServices service = new QouteJobServiceImpl();

    private EditText customer;
    private EditText vehicle;
    private EditText price;
    private EditText jobName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createjob);


        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // set button
        Button save_button = (Button) findViewById(R.id.buttonSave);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                customer = (EditText) findViewById(R.id.editTextCustomer);
                vehicle = (EditText) findViewById(R.id.editTextVehicle);
                price = (EditText) findViewById(R.id.editTextPrice);
                jobName = (EditText) findViewById(R.id.editTextJobName);

                try {
                    AddJobResource jobRes = new AddJobResource
                            .Builder(customer.getText().toString())
                            .resId(1L)
                            .vehicle(vehicle.getText().toString())
                            .price(Float.parseFloat(price.getText().toString()))
                            .jobName(jobName.getText().toString())
                            .build();


                    String response = service.save(jobRes);

                    customer.getText().clear();
                    vehicle.getText().clear();
                    price.getText().clear();
                    jobName.getText().clear();


                    Toast.makeText(getApplicationContext(),
                            "New Job Saved",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(),
                            "Could not save, Make sure that data is entered correctly",
                            Toast.LENGTH_LONG).show();


                    AddJobResource newResource = null;

                    long id = 3;

                    newResource = service.findById(id);

                    /*if(newResource == null) {

                        Toast.makeText(getApplicationContext(),
                                "GET not success!!!!",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "success!!!!" + newResource.getJobName(),
                                Toast.LENGTH_SHORT).show();
                    }*/
                }


            }
        });
        Button backBtn = (Button) findViewById(R.id.buttonExit);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateJobActivity.this, StartPageActivity.class);
                startActivity(intent);

            }

        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
