package com.example.infinity.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String months[] = {"January", "February", "March"}; // data source

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView1);

        /* Dyanamically  feeding data to listview using adapter*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);
        listView.setAdapter(adapter);

        // Adapter classes add the content from data source
        // (such as string array, array, database etc) to ListView

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String text = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
