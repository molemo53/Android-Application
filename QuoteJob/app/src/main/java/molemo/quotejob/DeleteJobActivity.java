package molemo.quotejob;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import molemo.quotejob.domain.AddJob;
import molemo.quotejob.model.AddJobResource;
import molemo.quotejob.services.QouteJobServices;
import molemo.quotejob.services.impl.QouteJobServiceImpl;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class DeleteJobActivity extends AppCompatActivity {

    QouteJobServices service = new QouteJobServiceImpl();

    AddJobResource jobRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletejob);


        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        EditText myTextBox = (EditText) findViewById(R.id.editTextDeleteId);

        myTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                EditText customerName = (EditText) findViewById(R.id.editTextCustomer);
                customerName.getText().clear();

                EditText vehicleName = (EditText) findViewById(R.id.editTextVehicle);
                vehicleName.getText().clear();

                jobRes = null;

                try {

                    EditText id = ((EditText) findViewById(R.id.editTextDeleteId));

                    if (!(id.getText().toString().isEmpty())) { // || (id.getText().toString().length() != 0)

                        jobRes = service.findById(Long.parseLong(id.getText().toString()));

                        if (jobRes != null) {
                            EditText customer = (EditText) findViewById(R.id.editTextCustomer);
                            customer.setText(jobRes.getCustomer());

                            EditText car = (EditText) findViewById(R.id.editTextVehicle);
                            car.setText(jobRes.getVehicle());
                        }
                    }

                } catch (Exception e) {

                    Toast.makeText(DeleteJobActivity.this, " does not exist\n"
                            , Toast.LENGTH_SHORT).show();
                }
            }

        });


        Button jobDelete = (Button) findViewById(R.id.buttonDeleteHome);

        jobDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DeleteJobActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete Job?");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        EditText id = ((EditText) findViewById(R.id.editTextDeleteId));
                        if (!(id.getText().toString().isEmpty())) {
                            try {

                                AddJob jobDel = new AddJob.Builder(jobRes.getCustomer())
                                        .id(jobRes.getResId())
                                        .vehicle(jobRes.getVehicle())
                                        .price(jobRes.getPrice())
                                        .jobName(jobRes.getJobName())
                                        .build();

                                String response = service.delete(jobDel);

                                Toast.makeText(getApplicationContext(), "Deleted" + "\n"
                                                + jobDel.getId() + "\n" + jobRes.getCustomer(),
                                        Toast.LENGTH_LONG).show();

                                jobRes = null;

                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Could Not Delete", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Canceled Transaction", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();

            }
        });


        Button backBtn = (Button) findViewById(R.id.buttonExit);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteJobActivity.this, StartPageActivity.class);
                startActivity(intent);

            }

        });




    }

}
