package com.example.infinity.customalertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNormalAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setMessage("This will delete the file permanently");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do what so ever, here lets simply toast a message
                Toast.makeText(MainActivity.this, "File Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    public void showAlertDialogList(View view) {
        final String cities[] = {"Jalandhar", "Phagwara", "Ludhiyana"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select your city");
        builder.setItems(cities, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do what so ever, here lets simply toast a the selected city
                Toast.makeText(MainActivity.this, cities[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

        /*
        Note:
        1. while using AlertDialog as list, Message must not be set, else list will not appear.
        2. there is no use of setting positive and negative button while using AlertDialog as list, because
            whenever a list item is selected, dialog disappears automatically
        */
    }

    public void showAlertDialogSingleChoice(View view) {
        final String cities[] = {"Jalandhar", "Phagwara", "Ludhiyana"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Your City");
        builder.setSingleChoiceItems(cities, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, cities[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Select", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do what so ever, here lets simply toast a message
                Toast.makeText(MainActivity.this, "City Selected", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();

        /*
        Note:
        1. while using AlertDialog as singleChoice, Message must not be set, else choices will not appear.
        */
    }

    public void showAlertDialogMultiChoice(View view) {
        final String cities[] = {"Jalandhar", "Phagwara", "Ludhiyana"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Your Cities");
        builder.setMultiChoiceItems(cities, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this, cities[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Select", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do what so ever, here lets simply toast a message
                Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();

        /*
        Note:
        1. while using AlertDialog as MultiChoice, Message must not be set, else choices will not appear.
        */
    }

    public void showCustomAlertDialog(View v) {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_alert, (ViewGroup)findViewById(R.id.linearLayout));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do what so ever, here lets simply toast a message
                Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

}
