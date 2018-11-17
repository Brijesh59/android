package com.example.infinity.basics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText text;
Button button;
CheckBox checkbox;
RadioButton radio;
Spinner spinner;
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.e1);
        button = findViewById(R.id.b1);
        checkbox = findViewById(R.id.c1);
        radio= findViewById(R.id.r1);
        spinner = findViewById(R.id.s1);
        linearLayout = findViewById(R.id.parent);

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked radio" , Toast.LENGTH_SHORT ).show();
            }
        });
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked check" , Toast.LENGTH_SHORT ).show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString().equals("pink"))
                {
                    linearLayout.setBackgroundColor(Color.rgb(255,99,89));
                }


                else if(adapterView.getItemAtPosition(i).toString().equals("blue"))
                {
                    linearLayout.setBackgroundColor(Color.rgb(200,18,200));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Activity2.class);
                i.putExtra("NAME",text.getText().toString());
                i.putExtra("ID",11);
                startActivity(i);

            }
        });
    }


}

