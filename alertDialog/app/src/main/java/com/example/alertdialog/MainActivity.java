package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //single button alert Dialog

//        AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
//        alert.setTitle("Terms $ Conditions");
//        alert.setMessage("Are You sure you want to continue");
//        alert.setIcon(R.drawable.baseline_info_24);
//
//        alert.setButton("Yes I've Read" ,new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this,"Yes you can proceed now",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alert.show();


        AlertDialog.Builder delete = new AlertDialog.Builder(MainActivity.this);
        delete.setTitle("Delete ?");
        delete.setMessage("Are you sure you want to delete ");
        delete.setIcon(R.drawable.baseline_delete_24);

        delete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Resource Deleted ..",Toast.LENGTH_SHORT).show();
            }
        });

        delete.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Not deleted ",Toast.LENGTH_SHORT).show();
            }
        });

        delete.show();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exit = new AlertDialog.Builder(MainActivity.this);
        exit.setTitle("Exit ?");
        exit.setMessage("Are you sure you want to exit");

        exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Exited ",Toast.LENGTH_SHORT).show();
                MainActivity.super.onBackPressed();//if this executed then this activity will be popped out of stack
            }
        });

        exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Not Exited",Toast.LENGTH_SHORT).show();
            }
        });

        exit.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Operation Cancelled ",Toast.LENGTH_SHORT).show();
            }
        });

        exit.show();
//        super.onBackPressed();//if this executed then this activity will be popped out of stack
    }
}