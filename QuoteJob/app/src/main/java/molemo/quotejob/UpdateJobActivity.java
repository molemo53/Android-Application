package molemo.quotejob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tsemol01 on 2015/12/29.
 */
public class UpdateJobActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayjob);

        Button backBtn = (Button) findViewById(R.id.buttonExit);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateJobActivity.this, StartPageActivity.class);
                startActivity(intent);

            }

        });
    }
}
