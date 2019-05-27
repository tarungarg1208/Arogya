package com.example.arogyademo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonorAndDonee extends AppCompatActivity {
    DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;
    char charArraycurrentUserId[];
    String pathUserId;
    String currentUserId;
    Data_DonorAndDonee data_donorAndDonee;
    RadioButton radioButtonDonor,radioButtonAcceptor;
    RadioButton radioButtonFinancial,radioButtonOrgan,radioButtonMedicine;
    EditText editTextAddInfo;
    String stringRequestType,stringAidType,stringAddInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_and_donee);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        currentUserId = sharedPreferences.getString("id", null);
        //FIREBASE
        charArraycurrentUserId = currentUserId.toCharArray();
        for (int i = 0; i < currentUserId.length(); i++) {
            if (charArraycurrentUserId[i] == '.') {
                charArraycurrentUserId[i] = ':';
            }
        }
        pathUserId = String.valueOf(charArraycurrentUserId);//
        databaseReference= FirebaseDatabase.getInstance().getReference();
        //ACTUAL CODING
        radioButtonDonor=findViewById(R.id.ID_DonorAndDonee_Donor_RadioButton);
        radioButtonAcceptor=findViewById(R.id.ID_DonorAndDonee_Acceptor_RadioButton);
        radioButtonFinancial=findViewById(R.id.ID_DonorAndDonee_Financial_RadioButton);
        radioButtonOrgan=findViewById(R.id.ID_DonorAndDonee_Organ_RadioButton);
        radioButtonMedicine=findViewById(R.id.ID_DonorAndDonee_Medicine_RadioButton);
        editTextAddInfo=findViewById(R.id.ID_DonorAndDonee_AddInfo_TV);
    }

    public void onRequestTypeRadioButtonClicked(View view) {
        if(radioButtonDonor.isChecked())
        {
            stringRequestType="DONOR";
        }
        if(radioButtonAcceptor.isChecked())
        {
            stringRequestType="ACCEPTOR";
        }
    }

    public void onAidTypeRadioButtonClicked(View view) {
        if(radioButtonFinancial.isChecked())
        {
            stringAidType="FINANCIAL";
        }
        if(radioButtonOrgan.isChecked())
        {
            stringAidType="ORGAN";
        }
        if(radioButtonMedicine.isChecked())
        {
            stringAidType="MEDICINE";
        }
    }

    public void onSubmit(View view) {
        stringAddInfo=editTextAddInfo.getText().toString().trim();
        if(stringAddInfo==null||stringAidType==null||stringRequestType==null)
        {
            Toast.makeText(DonorAndDonee.this,"All Fields are Mandatory",Toast.LENGTH_LONG).show();
        }
        else if(stringAddInfo.equals(""))
        {
            Toast.makeText(DonorAndDonee.this,"All Fields are Mandatory",Toast.LENGTH_LONG).show();
        }
        else
        {
            data_donorAndDonee=new Data_DonorAndDonee(currentUserId,stringRequestType,stringAidType,stringAddInfo);
            //DATABASE TASK
            databaseReference.child("donation").child(pathUserId).setValue(data_donorAndDonee)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(DonorAndDonee.this,"Request Submitted Successfully",Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(DonorAndDonee.this,"Try Again...",Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }
}
