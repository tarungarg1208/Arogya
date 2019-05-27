package com.example.arogyademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HealthTips extends AppCompatActivity {
    String currentUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);
        currentUserId=getIntent().getStringExtra("id");
    }

    public void onBMI(View view) {
        Intent intent=new Intent(HealthTips.this,BMI.class);
        intent.putExtra("id",currentUserId);
        startActivity(intent);
    }

    public void onHealthCheckup(View view) {
        Intent intent=new Intent(HealthTips.this,HealthCheckupHome.class);
        intent.putExtra("id",currentUserId);
        startActivity(intent);
    }

    public void onExercise(View view) {
        Intent intent=new Intent(HealthTips.this,ExerciseSplashScreen.class);
        intent.putExtra("id",currentUserId);
        startActivity(intent);
    }

    public void onOCR(View view) {
        Intent intent=new Intent(HealthTips.this,OCR.class);
        intent.putExtra("id",currentUserId);
        startActivity(intent);
    }
}
