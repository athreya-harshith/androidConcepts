package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial,btnShare,btnMessage,btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnShare = findViewById(R.id.btnShare);
        btnMessage = findViewById(R.id.btnMessage);
        btnEmail = findViewById(R.id.btnEmail);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919980654912"));
                startActivity(iDial);

            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto: "+Uri.encode("99806549142")));
                iMsg.putExtra("sms_body","hello this is a sample message");
                startActivity(iMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"1rn20cs051.harshithpathreya@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Sample Subject");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Hello 20cs051 u alive ????");
                startActivity(Intent.createChooser(iEmail,"Mail Via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Some link or text to be shared here ....>>>>>>>!!!!");
                startActivity(Intent.createChooser(iShare,"Share Through"));
            }
        });
    }
}