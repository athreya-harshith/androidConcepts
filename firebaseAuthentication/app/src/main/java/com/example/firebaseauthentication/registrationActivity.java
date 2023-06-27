package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registrationActivity extends AppCompatActivity {

    TextInputEditText uemail,upassowrd;
    Button registrationBtn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView loginNow ;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(registrationActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        uemail = findViewById(R.id.userEmail);
        upassowrd = findViewById(R.id.userPassword);

        registrationBtn = findViewById(R.id.registrationBtn);

        mAuth= FirebaseAuth.getInstance() ;
        progressBar = findViewById(R.id.progressBar);

        loginNow = findViewById(R.id.loginNow);
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registrationActivity.this,loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email = String.valueOf(uemail.getText());
                password = String.valueOf(upassowrd.getText());

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(registrationActivity.this,"Enter the Email",Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(registrationActivity.this,"Enter the Passoword",Toast.LENGTH_SHORT).show();
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(registrationActivity.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(registrationActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}