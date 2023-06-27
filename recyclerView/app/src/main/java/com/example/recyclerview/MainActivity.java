package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<cardModel> arrlist = new ArrayList<>();
    RecyclerCardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));


        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));


        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        arrlist.add(new cardModel(R.drawable.a,"Cristiano Ronaldo ","Greatest Athlete of ALl time"));
        arrlist.add(new cardModel(R.drawable.b,"Lionel Messi ","Good Soccer Player"));
        arrlist.add(new cardModel(R.drawable.c,"Sachin Tendular ","God of Cricket"));
        arrlist.add(new cardModel(R.drawable.d,"Sunder Pichai","CEO of Alphabet and My fav"));

        adapter = new RecyclerCardAdapter(this,arrlist);
        recyclerView.setAdapter(adapter);

        FloatingActionButton btnOpenDialog= findViewById(R.id.openDialogue);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.update_dialogue);

                EditText editname = dialog.findViewById(R.id.name);
                EditText editdesc = dialog.findViewById(R.id.desc);

                Button actionbtn = dialog.findViewById(R.id.okbtn);

                actionbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",desc="";
                        if(!editname.getText().toString().equals(""))
                        {
                            name = editname.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Enter the Name ",Toast.LENGTH_SHORT).show();
                        }

                        if(!editdesc.getText().toString().equals(""))
                        {
                            desc = editdesc.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Enter the Description ",Toast.LENGTH_SHORT).show();
                        }

                        arrlist.add(new cardModel(name,desc));
                        adapter.notifyItemInserted(arrlist.size()-1);//index where the last item is added

                        recyclerView.scrollToPosition(arrlist.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}