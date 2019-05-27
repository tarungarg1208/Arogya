package com.example.arogyademo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FlashCardFunctionality extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_functionality);
        viewPager=findViewById(R.id.ID_FlashCard_ViewPager);
        ImageAdapter_ScrollImages adapter=new ImageAdapter_ScrollImages(this);
        viewPager.setAdapter(adapter);
    }
}
