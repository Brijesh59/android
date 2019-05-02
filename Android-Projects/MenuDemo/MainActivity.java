package com.example.infinity.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        
        registerForContextMenu(btn2); // Do not forget to register the button for contextMenu

        /* ========================================================================
                           1 - PopupMenu Start
           ======================================================================== */  
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop = new PopupMenu(getApplicationContext(), view);
                pop.getMenuInflater().inflate(R.menu.menu, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.about:
                                Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            default: return false;
                        }
                        return true;
                    }
                });
                pop.show();
            }
        });
        /* Popup Menu End */
    }
    
    
    /* ========================================================================
                           2 - OptionMenu Start
       ======================================================================== */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about :
                Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.product:
                Toast.makeText(this, "Product Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.developers:
                Toast.makeText(this, "Developers Selected", Toast.LENGTH_SHORT).show();
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }
    /* OptionsMenu End */
    

    /* ========================================================================
                         3 - ContextMenu Start
       ======================================================================== */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
                Toast.makeText(this, "Context About", Toast.LENGTH_SHORT).show();
                break;
            default: return super.onContextItemSelected(item);
        }
        return true;
    }
    /* ContextMenu End */
}


