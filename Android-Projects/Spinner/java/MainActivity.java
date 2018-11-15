package com.example.infinity.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String month_name[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    boolean first_call = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.months);

        /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.months_name, android.R.layout.simple_spinner_dropdown_item);
        months.setAdapter(adapter);
        */

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, month_name);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!first_call){
                    String text = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(MainActivity.this, text , Toast.LENGTH_SHORT).show();
                }
                first_call = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
    }
}

