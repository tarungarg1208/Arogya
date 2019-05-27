package com.example.arogyademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MedicineSearch extends AppCompatActivity {
    ListView listViewMedicines;
    String currentUserId;
    String[] medicines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_search);

        currentUserId=getIntent().getStringExtra("id");
        medicines=getResources().getStringArray(R.array.medicine_name);
        listViewMedicines=findViewById(R.id.ID_MedicineSearch_Medicines_ListView);
        ArrayAdapter<String> adapterMedicines=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,medicines);
        listViewMedicines.setAdapter(adapterMedicines);
        listViewMedicines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MedicineSearch.this,MedicineSearchInformationViewer.class);
                intent.putExtra("id",currentUserId);
                intent.putExtra("medicine_pos",position);
                startActivity(intent);
            }
        });
    }
}
