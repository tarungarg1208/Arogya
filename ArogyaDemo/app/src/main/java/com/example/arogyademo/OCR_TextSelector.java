package com.example.arogyademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OCR_TextSelector extends AppCompatActivity {
    EditText editTextStringToBeSearched;
    EditText editTextStringFromOCR;
    String stringfromocr;
    String stringtobesearched;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr__text_selector);
        editTextStringFromOCR=findViewById(R.id.ID_OCRTextSelector_StringFromOCR_TV);
        editTextStringToBeSearched=findViewById(R.id.ID_OCRTextSelector_StringToBeSearched_ET);
        stringfromocr=getIntent().getStringExtra("string");
        editTextStringFromOCR.setText(stringfromocr);
    }

    public void onSearch(View view) {
        stringtobesearched=editTextStringToBeSearched.getText().toString().trim();
        String url="https://www.google.com/search?q="+stringtobesearched;
        Intent intent=new Intent(OCR_TextSelector.this,OCR_WebVIew.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
