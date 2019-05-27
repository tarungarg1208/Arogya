package com.example.arogyademo;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MedicineSearchInformationViewer extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final int REQUESTSPEECH = 101;
    TextView textViewMedicineName;
    TextView textViewMedicineInfo;
    ImageView imageViewTextToSpeech;
    int medicine_pos;
    String currentUserId;
    String[] medicineName, medicineInfo;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_search_information_viewer);
        textViewMedicineName = findViewById(R.id.ID_MedicineSearchInfoViewer_MedicineName_ET);
        textViewMedicineInfo = findViewById(R.id.ID_MedicineSearchInfoViewer_MedicineInfo_ET);
        imageViewTextToSpeech = findViewById(R.id.ID_MedicineSearchInfoViewer_TextToSpeech_IV);
        currentUserId = getIntent().getStringExtra("id");
        medicine_pos = getIntent().getIntExtra("medicine_pos", 0);
        medicineName = getResources().getStringArray(R.array.medicine_name);
        medicineInfo = getResources().getStringArray(R.array.medicine_info);
        textViewMedicineName.setText(medicineName[medicine_pos]);
        textViewMedicineInfo.setText(medicineInfo[medicine_pos]);
    }
    public void onTextToSpeech(View view) {
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, REQUESTSPEECH);
        Snackbar.make(view, "Listen(Check The Volume is Up)", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTSPEECH && resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
            textToSpeech = new TextToSpeech(this, this);
        } else {
            Intent installationIntent = new Intent();
            installationIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(installationIntent);
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int languageStatus = textToSpeech.setLanguage(Locale.UK);
            if (languageStatus == TextToSpeech.LANG_MISSING_DATA || languageStatus == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language not Supported", Toast.LENGTH_SHORT).show();
            } else {
                String data = textViewMedicineInfo.getText().toString().trim();
                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                if (speechStatus == TextToSpeech.ERROR) {
                    Toast.makeText(this, "Error while Speech ", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }


    public void onTextToSpeechMute(View view) {
        if (textToSpeech == null) {
            Snackbar.make(view, "First Click the Hear Button", Snackbar.LENGTH_LONG).show();
        } else {
            if (textToSpeech.isSpeaking()) {
                textToSpeech.stop();
            } else {
                Toast.makeText(this, "Not Speaking", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
