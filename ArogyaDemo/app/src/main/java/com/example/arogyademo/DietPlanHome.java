package com.example.arogyademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DietPlanHome extends AppCompatActivity {
    Float BMI,BMR,calorie_req;
    TextView textViewBMIHeading,textViewGainLose1,textViewGainLose2,textViewCalorie1Value,textViewCalorie2Value,textViewCalorieReq;
    Float calorie1float,calorie2float;
    Button buttonGainLose1,buttonGainLose2;
    int flag;//flag=0 for normal,flag=1 for gain,flag=-1 for lose
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_home);
        BMI=getIntent().getFloatExtra("BMI",0);
        BMR=getIntent().getFloatExtra("BMR",0);
        calorie_req=getIntent().getFloatExtra("CALORIE",0);
        textViewBMIHeading=findViewById(R.id.ID_DietPlan_BMIHeading_TV);
        textViewGainLose1=findViewById(R.id.ID_DietPlan_GainLose1Title_TV);
        textViewGainLose2=findViewById(R.id.ID_DietPlan_GainLose2Title_TV);
        textViewCalorie1Value=findViewById(R.id.ID_DietPlan_Calorie1Value_TV);
        textViewCalorie2Value=findViewById(R.id.ID_DietPlan_Calorie2Value_TV);
        textViewCalorieReq=findViewById(R.id.ID_DietPlan_CalorieReq_TV);
        buttonGainLose1=findViewById(R.id.ID_DietPlan_GainLose1_Button);
        buttonGainLose2=findViewById(R.id.ID_DietPlan_GainLose2_Button);
        if(BMI<= 18.5) {
            //3500 Calorie is equal to 1LB/0.45Kg
            textViewBMIHeading.setText("UNDER-WEIGHT");
            textViewGainLose1.setText("TO GAIN 0.45Kg/Week");
            textViewGainLose2.setText("TO GAIN 0.90Kg/Week");
            calorie1float=calorie_req+500;
            calorie2float=calorie_req+1000;
            flag=1;
            textViewCalorieReq.setText(""+calorie_req);
            textViewCalorie1Value.setText(""+calorie1float);
            textViewCalorie2Value.setText(""+calorie2float);
            buttonGainLose1.setText("Gain .45Kg/Week");
            buttonGainLose2.setText("Gain .90Kg/Week");
        }
        else if (BMI >= 18.5 && BMI <=24.9)
        {
            textViewBMIHeading.setText("NORMAL-WEIGHT");
            textViewGainLose1.setText("TO GAIN 0.45Kg/Week");
            textViewGainLose2.setText("TO LOSE 0.45Kg/Week");
            calorie1float=calorie_req+500;
            calorie2float=calorie_req-500;
            flag=0;
            textViewCalorieReq.setText(""+calorie_req);
            textViewCalorie1Value.setText(""+calorie1float);
            textViewCalorie2Value.setText(""+calorie2float);
            buttonGainLose1.setText("Gain .45Kg/Week");
            buttonGainLose2.setText("Lose .45Kg/Week");
        }
        else if (BMI >= 25.0 && BMI <= 29.9)
        {
            textViewBMIHeading.setText("OVER-WEIGHT");
            textViewGainLose1.setText("TO LOSE 0.45Kg/Week");
            textViewGainLose2.setText("TO LOSE 0.90Kg/Week");
            calorie1float=calorie_req-500;
            calorie2float=calorie_req-1000;
            flag=-1;
            textViewCalorieReq.setText(""+calorie_req);
            textViewCalorie1Value.setText(""+calorie1float);
            textViewCalorie2Value.setText(""+calorie2float);
            buttonGainLose1.setText("Lose .45Kg/Week");
            buttonGainLose2.setText("Lose .90Kg/Week");
        }
        else if ((BMI >= 30.0))
        {
            textViewBMIHeading.setText("OBESE");
            textViewGainLose1.setText("TO LOSE 0.45Kg/Week");
            textViewGainLose2.setText("TO LOSE 0.90Kg/Week");
            calorie1float=calorie_req-500;
            calorie2float=calorie_req-1000;
            flag=-1;
            textViewCalorieReq.setText(""+calorie_req);
            textViewCalorie1Value.setText(""+calorie1float);
            textViewCalorie2Value.setText(""+calorie2float);
            buttonGainLose1.setText("Lose .45Kg/Week");
            buttonGainLose2.setText("Lose .90Kg/Week");
        }

    }

    public void onGainLose1(View view) {
        Intent intent=new Intent(DietPlanHome.this,DietPlannerCalorieCounter.class);
        intent.putExtra("CALORIE",calorie1float);
        startActivity(intent);
    }

    public void onGainLose2(View view) {
        Intent intent=new Intent(DietPlanHome.this,DietPlannerCalorieCounter.class);
        intent.putExtra("CALORIE",calorie2float);
        startActivity(intent);
    }
}
