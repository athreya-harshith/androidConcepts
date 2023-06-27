package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result = findViewById(R.id.result);
        EditText heightFt = findViewById(R.id.heightFt);
        EditText heightin = findViewById(R.id.heightin);
        EditText weight = findViewById(R.id.weight);
        Button calculate = findViewById(R.id.calculate);

        LinearLayout llmain = findViewById(R.id.llmain);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int htFt = Integer.parseInt(heightFt.getText().toString());
                int htin = Integer.parseInt(heightin.getText().toString());
                int wt= Integer.parseInt(weight.getText().toString());

                int hin = (htFt * 12)+htin;

                double hcm = (hin*2.53);

                double totalm = hcm /100;

                double bmi = wt/(totalm*totalm);

                if(bmi > 25)
                {
                    result.setText("Your are over Weight");
                    heightFt.setText("");
                    heightin.setText("");
                    weight.setText("");
                    llmain.setBackgroundColor(getResources().getColor(R.color.teal_200));
                }
                else if(bmi < 18)
                {
                    result.setText("Your are Under Weight");
                    heightFt.setText("");
                    heightin.setText("");
                    weight.setText("");
                }
                else
                {
                    result.setText("Your are Healthy");
                    heightFt.setText("");
                    heightin.setText("");
                    weight.setText("");
                }


            }
        });

    }
}