package com.example.arogyademo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class HealthCheckupHome extends AppCompatActivity {
    EditText editTextWeight,editTextHeightFeet,editTextHeightInches,editTextAge,editTextActivity;
    TextView textViewBMIHeading,textViewBMIInfo,textViewBMIBodyType,textViewBMRHeading,textViewBMRInfo,textViewBMRInfoUnit,textViewCalorieHeading,textViewCalorieInfo;
    Button buttonDietPlan;
    RadioButton radioButtonMale,radioButtonFemale;
    float weight,heightFeet,heightInches,age,BMI,BMR_Male,BMR_Female,result,resultf,calorieintake;
    float BMI_float,BMR_float,Calorie_float;
    int activity;
    String stringActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_checkup_home);
        editTextWeight=findViewById(R.id.ID_HealthCheckup_Weight_ET);
        editTextHeightFeet=findViewById(R.id.ID_HealthCheckup_HeightFoot_ET);
        editTextHeightInches=findViewById(R.id.ID_HealthCheckup_HeightInches_ET);
        editTextAge=findViewById(R.id.ID_HealthCheckup_Age_ET);
        editTextActivity=findViewById(R.id.ID_HealthCheckup_Activities_ET);
        textViewBMIHeading=findViewById(R.id.ID_HealthCheckup_BMIHeading_TV);
        textViewBMIInfo=findViewById(R.id.ID_HealthCheckup_BMIInfo_TV);
        textViewBMIBodyType=findViewById(R.id.ID_HealthCheckup_BMIBodyType_TV);
        textViewBMRHeading=findViewById(R.id.ID_HealthCheckup_BMRHeading_TV);
        textViewBMRInfo=findViewById(R.id.ID_HealthCheckup_BMRInfo_TV);
        textViewBMRInfoUnit=findViewById(R.id.ID_HealthCheckup_BMRInfoUnit_TV);
        textViewCalorieHeading=findViewById(R.id.ID_HealthCheckup_Calorie_TV);
        textViewCalorieInfo=findViewById(R.id.ID_HealthCheckup_CalorieInfo_TV);
        buttonDietPlan=findViewById(R.id.ID_HealthCheckup_DietPlan_BTN);
        radioButtonMale=findViewById(R.id.ID_HealthCheckup_Male_RadioButton);
        radioButtonFemale=findViewById(R.id.ID_HealthCheckup_Female_RadioButton);
    }

    public void onClearButtonClicked(View view) {
        editTextWeight.setText("");
        editTextHeightFeet.setText("");
        editTextHeightInches.setText("");
        editTextAge.setText("");
        editTextActivity.setText("");
        textViewBMIHeading.setVisibility(View.INVISIBLE);
        textViewBMIInfo.setVisibility(View.INVISIBLE);
        textViewBMIBodyType.setVisibility(View.INVISIBLE);
        textViewBMRHeading.setVisibility(View.INVISIBLE);
        textViewBMRInfo.setVisibility(View.INVISIBLE);
        textViewCalorieHeading.setVisibility(View.INVISIBLE);
        textViewCalorieInfo.setVisibility(View.INVISIBLE);
        buttonDietPlan.setVisibility(View.INVISIBLE);;
        textViewBMRInfoUnit.setVisibility(View.INVISIBLE);
    }


    public void onCalculateButtonClicked(View view) {
        if (editTextWeight.length() == 0||editTextHeightFeet.length()==0 ||editTextAge.length()==0||editTextActivity.length()==0) {
            if(editTextWeight.length() == 0)
            {
                editTextWeight.setError("Enter Weight");
            }
            else if(editTextHeightFeet.length()==0)
            {
                editTextHeightFeet.setError("Enter the height");
            }
            else if(editTextAge.length()==0)
            {
                editTextAge.setError("Enter the age");
            }
            else if (editTextActivity.length()==0)
            {
                editTextActivity.setError("Enter the activity");
            }

        }


        else{
            if(editTextHeightInches.length()==0)
            {

                editTextHeightInches.setText((String.valueOf(0)));
                weight = Float.parseFloat(editTextWeight.getText().toString());
                heightFeet = Float.parseFloat(editTextHeightFeet.getText().toString());
                heightInches = Float.parseFloat(editTextHeightInches.getText().toString());
                age = Float.parseFloat(editTextAge.getText().toString());
                activity = Integer.parseInt(editTextActivity.getText().toString());
                stringActivity = editTextActivity.getText().toString();

                calculateBMI();
                calculateBMR();
                buttonDietPlan.setVisibility(VISIBLE);
                textViewBMRInfoUnit.setVisibility(VISIBLE);
            }
            else
            {
                weight = Float.parseFloat(editTextWeight.getText().toString());
                heightFeet = Float.parseFloat(editTextHeightFeet.getText().toString());
                heightInches = Float.parseFloat(editTextHeightInches.getText().toString());
                age = Float.parseFloat(editTextAge.getText().toString());
                activity = Integer.parseInt(editTextActivity.getText().toString());
                stringActivity = editTextActivity.getText().toString();

                calculateBMI();
                calculateBMR();
                buttonDietPlan.setVisibility(VISIBLE);
                textViewBMRInfoUnit.setVisibility(VISIBLE);

            }

        }
    }
    public void calculateBMI(){
        float height_inch_total=heightFeet*12+heightInches;
        float height_metre=height_inch_total*0.0254f;

        BMI = weight /(height_metre*height_metre);
        result = (float)(Math.round(BMI * 100.0) / 100.0);
        textViewBMIHeading.setVisibility(VISIBLE);
        textViewBMIInfo.setText(Float.toString(BMI));
        textViewBMIInfo.setTextSize(18);
        textViewBMIInfo.setTypeface(textViewBMIInfo.getTypeface(), Typeface.BOLD);
        textViewBMIInfo.setText(Float.toString(result));
        textViewBMIInfo.setVisibility(VISIBLE);
        textViewBMIHeading.setTextSize(18);
        textViewBMIHeading.setTypeface(textViewBMIHeading.getTypeface(), Typeface.BOLD);
        displayBodyType();

        BMI_float=result;

    }

    public void displayBodyType(){
        if(result<= 18.5){
            textViewBMIBodyType.setVisibility(VISIBLE);
            textViewBMIBodyType.setTextSize(18);
            textViewBMIBodyType.setTypeface(textViewBMIBodyType.getTypeface(), Typeface.BOLD);
            textViewBMIBodyType.setText("(UnderWeight)");
        }
        else if (result >= 18.5 && result <=24.9){
            textViewBMIBodyType.setVisibility(VISIBLE);
            textViewBMIBodyType.setTextSize(18);
            textViewBMIBodyType.setTypeface(textViewBMIBodyType.getTypeface(), Typeface.BOLD);
            textViewBMIBodyType.setText("(NormalWeight)");

        }
        else if (result >= 25.0 && result <= 29.9){
            textViewBMIBodyType.setVisibility(VISIBLE);
            textViewBMIBodyType.setTextSize(18);
            textViewBMIBodyType.setTypeface(textViewBMIBodyType.getTypeface(), Typeface.BOLD);
            textViewBMIBodyType.setText("(OverWeight)");

        }
        else if (result >= 30.0){
            textViewBMIBodyType.setVisibility(VISIBLE);
            textViewBMIBodyType.setTextSize(18);
            textViewBMIBodyType.setTypeface(textViewBMIBodyType.getTypeface(), Typeface.BOLD);
            textViewBMIBodyType.setText("(Obese)");
        }
        else
        {

        }
    }

    public void calculateBMR(){
        if(radioButtonMale.isChecked()) {
            float height_cms=((heightFeet*12)+heightInches)*2.54f;
            BMR_Male=66.47f+(13.7f*weight)+(5f*height_cms)-(6.8f*age);
            result = (Math.round(BMR_Male * 100.0f) / 100.0f);
            resultf = (float) result;
            BMR_float=resultf;//FOR INTENT
            textViewBMRHeading.setVisibility(VISIBLE);
            textViewBMRHeading.setTextSize(18);
            textViewBMRHeading.setTypeface(textViewBMRHeading.getTypeface(), Typeface.BOLD);
            textViewBMRInfo.setVisibility(VISIBLE);
            textViewBMRInfo.setTextSize(18);
            textViewBMRInfo.setTypeface(textViewBMRInfo.getTypeface(), Typeface.BOLD);
            textViewBMRInfo.setText(Float.toString(BMR_Male));
            textViewCalorieHeading.setVisibility(VISIBLE);
            textViewCalorieHeading.setTextSize(18);
            textViewCalorieHeading.setTypeface(textViewCalorieHeading.getTypeface(), Typeface.BOLD);
            textViewCalorieInfo.setVisibility(VISIBLE);
            textViewCalorieInfo.setTextSize(18);
            textViewCalorieInfo.setTypeface(textViewCalorieInfo.getTypeface(), Typeface.BOLD);
            activity = Integer.parseInt(editTextActivity.getText().toString());
            if (activity == 1)
            {
                calorieintake = resultf * (float) 1.2;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else if(activity ==2)
            {
                calorieintake = resultf * (float) 1.375;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));

            }
            else if(activity ==3)
            {
                calorieintake = resultf * (float) 1.55;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));

            }
            else if (activity ==4)
            {
                calorieintake = resultf * (float) 1.725;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else if (activity ==5)
            {
                calorieintake = resultf * (float) 1.9;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(HealthCheckupHome.this);
                alert.setTitle("Activity Rate Error");
                alert.setMessage("Enter valid Activity Rate from 1 to 5 ...");
                alert.setPositiveButton("OK",null);
                alert.show();
            }
        }
        else if (radioButtonFemale.isChecked())
        {
            float height_cms=((heightFeet*12)+heightInches)*2.54f;

            BMR_Female = 655.1f + ( 9.6f * weight ) + ( 1.8f * height_cms )-(4.7f*age);
            result = (Math.round(BMR_Female * 100.0f) / 100.0f);
            resultf = (float)result;
            BMR_float=resultf;//FOR INTENT
            textViewBMRHeading.setVisibility(VISIBLE);
            textViewBMRHeading.setTextSize(18);
            textViewBMRHeading.setTypeface(textViewBMRHeading.getTypeface(), Typeface.BOLD);

            textViewBMRInfo.setVisibility(VISIBLE);
            textViewBMRInfo.setTextSize(18);
            textViewBMRInfo.setTypeface(textViewBMRInfo.getTypeface(), Typeface.BOLD);

            textViewCalorieHeading.setVisibility(VISIBLE);
            textViewCalorieHeading.setTextSize(18);
            textViewCalorieHeading.setTypeface(textViewCalorieHeading.getTypeface(), Typeface.BOLD);

            textViewCalorieInfo.setVisibility(VISIBLE);
            textViewCalorieInfo.setTextSize(18);
            textViewCalorieInfo.setTypeface(textViewCalorieInfo.getTypeface(), Typeface.BOLD);

            BMR_Female = Math.round(BMR_Female);
            textViewBMRInfo.setText(Float.toString(BMR_Female));
            activity = Integer.parseInt(editTextActivity.getText().toString());
            if (activity == 1)
            {
                calorieintake = resultf * (float) 1.2;
                calorieintake = Math.round(calorieintake);
                Log.d("female","value" +calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else if(activity ==2)
            {
                calorieintake = resultf * (float) 1.375;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));

            }
            else if(activity ==3)
            {
                calorieintake = resultf * (float) 1.55;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));

            }
            else if (activity ==4)
            {
                calorieintake = resultf * (float) 1.725;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else if (activity ==5)
            {
                calorieintake = resultf * (float) 1.9;
                calorieintake = Math.round(calorieintake);
                result = (Math.round(calorieintake * 100.0f) / 100.0f);
                resultf = (float)result;
                textViewCalorieInfo.setText(Double.toString(calorieintake));
            }
            else
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(HealthCheckupHome.this);
                alert.setTitle("Activity Rate Error");
                alert.setMessage("Enter valid Activity Rate from 1 to 5 ...");
                alert.setPositiveButton("OK",null);
                alert.show();
            }

        }

    }

    public void onDietPlan(View view) {
        Intent intent = new Intent(HealthCheckupHome.this,DietPlanHome.class);
        Calorie_float=calorieintake;
        //FOR INTENT BMI_float,Calorie_float,BMR_float is used.
        //Toast.makeText(this,""+BMI_float+","+BMR_float+","+Calorie_float,Toast.LENGTH_LONG).show();
        intent.putExtra("BMI",BMI_float);
        intent.putExtra("BMR",BMR_float);
        intent.putExtra("CALORIE",Calorie_float);
        startActivity(intent);
    }
}
