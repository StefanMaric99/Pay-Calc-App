package ca.gbc.comp3074.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberOfHours = findViewById(R.id.numberOfHours);
        final EditText rate = findViewById(R.id.rate);

        final TextView payText = findViewById(R.id.pay);
        final TextView overtimeText = findViewById(R.id.overtime);
        final TextView totalText = findViewById(R.id.total);
        final TextView taxText = findViewById(R.id.tax);

        Button submitBtn = findViewById(R.id.submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hoursInput = Double.parseDouble(numberOfHours.getText().toString());
                double rateInput = Double.parseDouble(rate.getText().toString());

                double pay = hoursInput * rateInput;
                double overtime;

                if (hoursInput <= 40.0) {
                    overtime = 0.0;
                } else {
                    overtime = (hoursInput - 40) * rateInput * 1.5;
                }

                double total = pay + overtime;
                double tax = total * 0.18;

                payText.setText("pay: " + pay);
                overtimeText.setText("overtime: " + overtime);
                totalText.setText("Total: " + total);
                taxText.setText("Taxes: " + tax);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, aboutActivity.class);
            startActivity(intent);
        }
        return  super.onOptionsItemSelected(item);
    }
}