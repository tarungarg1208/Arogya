package com.example.arogyademo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class RecoverPassword extends AppCompatActivity {
    EditText editTextEmail;
    FirebaseAuth mAuth;
    String stringEmail;
    Button buttonRecoverPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.ID_RP_Email_ET);
        editTextEmail.addTextChangedListener(EmailTextWatcher);
        buttonRecoverPassword=findViewById(R.id.ID_RP_RecoverPassword_BT);
        buttonRecoverPassword.setEnabled(false);

    }

    public void onRecoverPassword(View view) {
        stringEmail = editTextEmail.getText().toString().trim();
        mAuth.sendPasswordResetEmail(stringEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RecoverPassword.this, "Password Verification Link Sent to Your Email Address", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RecoverPassword.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private TextWatcher EmailTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String temp=editTextEmail.getText().toString().trim();
            if(!(temp.length()==0))
            {
                buttonRecoverPassword.setEnabled(true);
            }
            else
            {
                buttonRecoverPassword.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
