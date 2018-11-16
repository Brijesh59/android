package com.example.infinity.filestorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText sId, sName, course;
    String data;
    String studentName, studentCourse;
    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sId = findViewById(R.id.studentId);
        sName = findViewById(R.id.studentName);
        course = findViewById(R.id.course);
    }

    public void saveData(View v){
        studentId = Integer.parseInt( sId.getText().toString() );
        studentName = sName.getText().toString();
        studentCourse = course.getText().toString();
        data = studentId + " " + studentName + " " + studentCourse ;

        // Store the data to a file in internal storage(sdcard0)
        File sdCard = Environment.getExternalStorageDirectory();
 
        File f = new File(sdCard.getAbsolutePath(), "file1.txt");
        try{
       
            f.createNewFile();

            // FileWriter class is used to write character-oriented data to a file.
            FileWriter fw = new FileWriter(f);
            for(int i = 0; i < data.length(); i++){
                fw.write(data.charAt(i));
            }
            fw.flush();
            fw.close();     

        }
        catch (IOException e){
            Log.d("Error: ", e.toString());
        }
    }

