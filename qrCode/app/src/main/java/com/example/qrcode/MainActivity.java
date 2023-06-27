package com.example.qrcode;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    TextInputEditText qrText;
    Button qrBtn, scanBtn;
    ImageView qrImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrText = findViewById(R.id.qrContent);
        qrBtn = findViewById(R.id.generateBtn);
        qrImg = findViewById(R.id.qrImg);

        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gnerateQR();
            }
        });

        scanBtn = findViewById(R.id.scanBtn);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }
        });


    }

    private  void scanCode()
    {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Volume up to turn on the flash");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(CaptActivity.class);
        qrLauncher.launch(scanOptions);
    }
    ActivityResultLauncher<ScanOptions> qrLauncher  = registerForActivityResult(new ScanContract(), new ActivityResultCallback<ScanIntentResult>() {
        @Override
        public void onActivityResult(ScanIntentResult result) {
            if(result.getContents() != null)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Result");
                builder.setMessage(result.getContents());
                builder.setPositiveButton("OK ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        }
    });
    private void gnerateQR()
    {
        String text = String.valueOf(qrText.getText());

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            if(TextUtils.isEmpty(text))
            {
                Toast.makeText(getApplicationContext(),"Enter the valid String to Generate QR",Toast.LENGTH_SHORT).show();
                return;
            }
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,750,750);//gives the matrix value
            // we must convert that to bitmap value to view as image
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();

            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

            qrImg.setImageBitmap(bitmap);

        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }
}