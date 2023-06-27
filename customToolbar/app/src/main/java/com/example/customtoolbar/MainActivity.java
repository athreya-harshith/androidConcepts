package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.toolBar);

        setSupportActionBar(toolBar);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My toolBar");// it has more priority
        }

        toolBar.setTitle("My toolBar");//it has low priority
        toolBar.setSubtitle("Sub Title");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.tool_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.first)
            Toast.makeText(this,"New File Created",Toast.LENGTH_SHORT).show();
        else if(itemId == R.id.second)
            Toast.makeText(this,"File Opened",Toast.LENGTH_SHORT).show();
        else if (itemId == R.id.third)
            Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();
        else if(itemId == android.R.id.home)//to access the home button created
            Toast.makeText(this,"Home Button",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}