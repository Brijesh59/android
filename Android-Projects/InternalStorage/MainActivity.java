package com.example.infinity.internalstorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView textView;
    String fileName = "myfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.title);
        editText2 = findViewById(R.id.description);
        textView = findViewById(R.id.viewData);
    }

    public void saveData(View view) {
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_APPEND);
            String data = editText1.getText().toString() + " " + editText2.getText().toString() + "\n";
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData(View view) {
        try {
            FileInputStream fis = openFileInput(fileName);
            int c;
            StringBuilder data = new StringBuilder();
            while( (c = fis.read()) != -1 ){
                data.append( (char)c );
            }
            textView.setText(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
