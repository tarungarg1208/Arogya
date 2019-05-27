package com.example.arogyademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GovernmentHealthSchemesInformationViewer extends AppCompatActivity {
    int schemes_pos;
    TextView textViewSchemeName,textViewSchemeInfo;
    String[] scheme_name,scheme_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_health_schemes_information_viewer);

        schemes_pos = getIntent().getIntExtra("schemes_pos", 0);

        textViewSchemeName=findViewById(R.id.ID_GovtHealthSchemesInfoViewer_SchemeName_TV);
        textViewSchemeInfo=findViewById(R.id.ID_GovtHealthSchemesInfoViewer_SchemeInfo_TV);
        scheme_name = getResources().getStringArray(R.array.health_schemes);
        scheme_info = getResources().getStringArray(R.array.health_schemes_info);
        textViewSchemeName.setText(scheme_name[schemes_pos]);
        textViewSchemeInfo.setText(scheme_info[schemes_pos]);
    }
}
