package molemo.quotejob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class StartPageActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);

        Button newJOb = (Button) findViewById(R.id.buttonNewJOb);

        newJOb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this, CreateJobActivity.class);
                startActivity(intent);

            }
        });

        Button updateJob = (Button) findViewById(R.id.buttonUpdateJob);

        updateJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this,UpdateJobActivity.class );
                startActivity(intent);
            }

        });
        Button deleteJOb = (Button) findViewById(R.id.buttonDeleteHome);

        deleteJOb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this, DeleteJobActivity.class);
                startActivity(intent);
            }

        });


        Button readJob = (Button) findViewById(R.id.buttonDisplayJob);

        readJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPageActivity.this, ReadJobActivity.class);
                startActivity(intent);
            }

        });

    }
}
