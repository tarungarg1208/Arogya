package com.example.arogyademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class DietPlannerCalorieCounter extends AppCompatActivity {
    TextView textViewCalorieCount,textViewCalorieCountFoodItems;
    Float floatCalorieCount;
    TextView[] textViewCalories=new TextView[17];
    EditText[] editTextQty=new EditText[17];
    int i;
    String temp,stringCalorie,stringQuantity;
    float floatCalorie,tempcal,tempqty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_planner_calorie_counter);

        floatCalorieCount=getIntent().getFloatExtra("CALORIE",0);

        textViewCalorieCount=findViewById(R.id.ID_DietPlanner_CalorieCount_TV);
        textViewCalorieCount.setText(""+floatCalorieCount);

        textViewCalorieCountFoodItems=findViewById(R.id.ID_DietPlanner_CalorieCountFoodItems_TV);
        textViewCalories[0]=findViewById(R.id.ID_DietPlanner_Calorie0_TV);
        textViewCalories[1]=findViewById(R.id.ID_DietPlanner_Calorie1_TV);
        textViewCalories[2]=findViewById(R.id.ID_DietPlanner_Calorie2_TV);
        textViewCalories[3]=findViewById(R.id.ID_DietPlanner_Calorie3_TV);
        textViewCalories[4]=findViewById(R.id.ID_DietPlanner_Calorie4_TV);
        textViewCalories[5]=findViewById(R.id.ID_DietPlanner_Calorie5_TV);
        textViewCalories[6]=findViewById(R.id.ID_DietPlanner_Calorie6_TV);
        textViewCalories[7]=findViewById(R.id.ID_DietPlanner_Calorie7_TV);
        textViewCalories[8]=findViewById(R.id.ID_DietPlanner_Calorie8_TV);
        textViewCalories[9]=findViewById(R.id.ID_DietPlanner_Calorie9_TV);
        textViewCalories[10]=findViewById(R.id.ID_DietPlanner_Calorie10_TV);
        textViewCalories[11]=findViewById(R.id.ID_DietPlanner_Calorie11_TV);
        textViewCalories[12]=findViewById(R.id.ID_DietPlanner_Calorie12_TV);
        textViewCalories[13]=findViewById(R.id.ID_DietPlanner_Calorie13_TV);
        textViewCalories[14]=findViewById(R.id.ID_DietPlanner_Calorie14_TV);
        textViewCalories[15]=findViewById(R.id.ID_DietPlanner_Calorie15_TV);
        textViewCalories[16]=findViewById(R.id.ID_DietPlanner_Calorie16_TV);
        //Qty is Edit Text
        editTextQty[0]=findViewById(R.id.ID_DietPlanner_Qty0_TV);
        editTextQty[1]=findViewById(R.id.ID_DietPlanner_Qty1_TV);
        editTextQty[2]=findViewById(R.id.ID_DietPlanner_Qty2_TV);
        editTextQty[3]=findViewById(R.id.ID_DietPlanner_Qty3_TV);
        editTextQty[4]=findViewById(R.id.ID_DietPlanner_Qty4_TV);
        editTextQty[5]=findViewById(R.id.ID_DietPlanner_Qty5_TV);
        editTextQty[6]=findViewById(R.id.ID_DietPlanner_Qty6_TV);
        editTextQty[7]=findViewById(R.id.ID_DietPlanner_Qty7_TV);
        editTextQty[8]=findViewById(R.id.ID_DietPlanner_Qty8_TV);
        editTextQty[9]=findViewById(R.id.ID_DietPlanner_Qty9_TV);
        editTextQty[10]=findViewById(R.id.ID_DietPlanner_Qty10_TV);
        editTextQty[11]=findViewById(R.id.ID_DietPlanner_Qty11_TV);
        editTextQty[12]=findViewById(R.id.ID_DietPlanner_Qty12_TV);
        editTextQty[13]=findViewById(R.id.ID_DietPlanner_Qty13_TV);
        editTextQty[14]=findViewById(R.id.ID_DietPlanner_Qty14_TV);
        editTextQty[15]=findViewById(R.id.ID_DietPlanner_Qty15_TV);
        editTextQty[16]=findViewById(R.id.ID_DietPlanner_Qty16_TV);
        for(i=0;i<17;i++)
        {
            editTextQty[i].addTextChangedListener(qtyTextWatcher);
        }
    }
    private TextWatcher qtyTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            floatCalorie=0;
            for(i=0;i<17;i++)
            {
                stringCalorie=textViewCalories[i].getText().toString().trim();
                stringQuantity=editTextQty[i].getText().toString().trim();
                if(stringCalorie.equals(""))
                {
                    tempcal=0;
                }
                else
                {
                    tempcal=Float.parseFloat(textViewCalories[i].getText().toString().trim());
                }
                if(stringQuantity.equals(""))
                {
                    tempqty=0;
                }
                else
                {
                    tempqty=Float.parseFloat(editTextQty[i].getText().toString().trim());
                }
                floatCalorie=floatCalorie+(tempcal*tempqty);
            }
            textViewCalorieCountFoodItems.setText(String.valueOf(floatCalorie));
        }
    };
}
