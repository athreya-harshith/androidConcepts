package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrName = new ArrayList<>();

    Spinner spinner ;

    ArrayList<String> arrid = new ArrayList<>();

    AutoCompleteTextView actxtview;

    ArrayList<String> arrLang = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        arrName.add("New York");
        arrName.add("Chicago");
        arrName.add("Newark");
        arrName.add("Dulles");
        arrName.add("Massachusetts");
        arrName.add("Madrid");
        arrName.add("Spain");
        arrName.add("Croatia");
        arrName.add("Sweden");
        arrName.add("Germany");
        arrName.add("Manchester");
        arrName.add("Washington");
        arrName.add("California");
        arrName.add("Bengaluru");
        arrName.add("New York");
        arrName.add("Chicago");
        arrName.add("Newark");
        arrName.add("Dulles");
        arrName.add("Massachusetts");
        arrName.add("Madrid");
        arrName.add("Spain");
        arrName.add("Croatia");
        arrName.add("Sweden");
        arrName.add("Germany");
        arrName.add("Manchester");
        arrName.add("Washington");
        arrName.add("California");
        arrName.add("Bengaluru");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrName);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Clicked on "+i+"th positon",Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.spinner);

        arrid.add("AAdhar Card");
        arrid.add("PAN Card");
        arrid.add("DL ");
        arrid.add("Credit Card");

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrid);
        spinner.setAdapter(spinAdapter);

        actxtview = findViewById(R.id.autoCompleteTv);

        arrLang.add("C");
        arrLang.add("C++");
        arrLang.add("Java");
        arrLang.add("PHP");
        arrLang.add("Java Script");

        ArrayAdapter<String> actxt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrLang);

        actxtview.setAdapter(actxt);
        actxtview.setThreshold(1);
    }
}