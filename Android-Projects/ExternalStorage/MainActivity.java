package com.example.infinity.externalstorage;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;
    String fileName = "myfile";

    boolean externalStoragePermission = false;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.title);
        editText2 = findViewById(R.id.description);
        textView = findViewById(R.id.viewData);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        else{
            externalStoragePermission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int grantResult = grantResults[i];

                if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        externalStoragePermission = true;
                        Toast.makeText(this, "Write Permission Granted", Toast.LENGTH_SHORT).show();
                    } else {
                        externalStoragePermission = false;
                        Toast.makeText(this, "Write Permission Denied", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void saveData(View view) {

        String title = editText1.getText().toString();
        String description = editText2.getText().toString();
        String data = title + " " + description + "\n";

        if(externalStoragePermission){

            File sdCard = Environment.getExternalStorageDirectory();
            File folder = new File(sdCard.getAbsolutePath() + "/MyDocs");
            folder.mkdirs();

            // Create a file in the folder "MyDocs", if not present
            file = new File(folder, fileName);

            try {
                FileOutputStream fos = new FileOutputStream(file, true);
                fos.write(data.getBytes());
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        else{
            Toast.makeText(this, "Write Permission not granted", Toast.LENGTH_SHORT).show();
        }
    }

    public void readData(View view) {
        if(externalStoragePermission){
            try {
                FileInputStream fis = new FileInputStream(file);
                int c;
                StringBuilder data = new StringBuilder();
                while( (c = fis.read()) != -1 ){
                    data.append( (char)c );
                }
                textView.setText(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
