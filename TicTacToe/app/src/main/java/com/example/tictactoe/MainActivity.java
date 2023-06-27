package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean winner;
    int flag = 0,cnt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private  void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.bnt2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

    }

    public void Check(View v)
    {

        Button click = (Button) v;

        if(click.getText() == "")
        {
            if(flag == 0)
            {
                click.setText("X");
                flag = 1;
                cnt++;
            }
            else
            {
                click.setText("O");
                flag = 0;
                cnt++;
            }

            if(cnt>4)
            {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();


                if((b1.equals(b2) && b2.equals(b3) && !b1.equals("")))
                {
                    winner = decide(b1);
                    tost(winner);

                }
                else if( (b4.equals(b5) && b5.equals(b6) && !b4.equals("")))
                {
                    winner = decide(b4);
                    tost(winner);
                } else if ( (b7.equals(b8) && b8.equals(b9) && !b7.equals("")))
                {
                    winner = decide(b7);
                    tost(winner);
                }
                else if ((b1.equals(b5) && b5.equals(b9) && !b1.equals("")))
                {
                    winner = decide(b1);
                    tost(winner);
                }
                else if ( (b3.equals(b5) && b5.equals(b7) && !b3.equals("")))
                {
                    winner = decide(b3);
                    tost(winner);
                } else if ((b1.equals(b4) && b4.equals(b7) && !b1.equals("")))
                {
                    winner = decide(b1);
                    tost(winner);
                }
                else if ((b2.equals(b5) && b5.equals(b8) && !b2.equals("")))
                {
                    winner = decide(b2);
                    tost(winner);
                }
                else if ((b3.equals(b6) && b6.equals(b9) && !b3.equals("")))
                {
                    winner = decide(b3);
                    tost(winner);
                }
                else if (cnt == 9)
                {
                    Toast.makeText(getApplicationContext(),"Its a Draw Game ",Toast.LENGTH_LONG).show();
                    btn1.setText("");
                    btn2.setText("");
                    btn3.setText("");

                    btn4.setText("");
                    btn5.setText("");
                    btn6.setText("");

                    btn7.setText("");
                    btn8.setText("");
                    btn9.setText("");
                    cnt=0;
                    flag = 0;
                }
            }

        }


    }

    private  boolean decide(String b)
    {
        if(b.equals("X"))
            return true;
        else
            return  false;
    }

    private void tost(boolean win)
    {
        if(win)
            Toast.makeText(getApplicationContext(),"X wins First Player is Winner",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"O wins Second Player is Winner",Toast.LENGTH_LONG).show();

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");

        btn4.setText("");
        btn5.setText("");
        btn6.setText("");

        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        cnt=0;
        flag = 0;
    }
}