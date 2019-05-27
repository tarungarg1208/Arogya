package com.example.arogyademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GovernmentHealthSchemesList extends AppCompatActivity {
    String[] schemes;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_health_schemes_list);
        schemes=getResources().getStringArray(R.array.health_schemes);
        listView=findViewById(R.id.ID_GovtHealthSchemes_ListView);
        ArrayAdapter<String> adapterSchemes=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,schemes);
        listView.setAdapter(adapterSchemes);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(GovernmentHealthSchemesList.this,GovernmentHealthSchemesInformationViewer.class);
                intent.putExtra("schemes_pos",position);
                startActivity(intent);
            }
        });

    }
}
