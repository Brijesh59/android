package com.example.infinity.elements_selector;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout parent;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox1 = findViewById(R.id.chBox1);
        checkBox2 = findViewById(R.id.chBox2);
        checkBox3 = findViewById(R.id.chBox3);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                // get the id of selected radio button using getCheckedRadioButtonId
                selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String selectedRadioBtnText = selectedRadioButton.getText().toString();

                Toast.makeText(MainActivity.this, "Edit Text: " + text + "\nRadio Button: " + selectedRadioBtnText, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void changeBackground(View v){
        if(checkBox1.isChecked()){
            parent.setBackgroundColor(Color.rgb(255,182,193));
        }
        else if(checkBox2.isChecked()){
            parent.setBackgroundColor(Color.rgb(255,255,51));
        }
        else if(checkBox3.isChecked()){
            parent.setBackgroundColor(Color.rgb(255,0,0));
        }
        else {
            parent.setBackgroundColor(Color.rgb(255,255,255));
        }

        /*
        CheckBox chBox = (CheckBox) v;
        if(chBox.isChecked()){
            Toast.makeText(this, chBox.getText() + " Selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, chBox.getText() + " De Selected", Toast.LENGTH_SHORT).show();
        }
        */
    }
}
