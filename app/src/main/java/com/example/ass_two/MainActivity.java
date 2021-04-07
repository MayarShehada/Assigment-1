package com.example.ass_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText full_name,age_txt;
    RadioButton male_radio , female_radio;
    Spinner spinner;
    String teacher="null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        full_name=findViewById(R.id.full_name);
        age_txt=findViewById(R.id.age_txt);
        male_radio=findViewById(R.id.male_radio);
        female_radio=findViewById(R.id.female_radio);
        spinner =findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        populateSpinner();

    }

    private void populateSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("School");
        data.add("Diploma");
        data.add("Bachelor");
        data.add("Master");
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void save_OnClick(View view)
    {
        String full_names = full_name.getText().toString();
        String ages = age_txt.getText().toString();
        String gender="";


        if(male_radio.isChecked())
        {
            gender="Male";

        }else
        {
            gender="Female";
        }
        AdapterView.OnItemSelectedListener te = spinner.getOnItemSelectedListener();


        Intent intent = new Intent(this,sec_activity.class);


        intent.putExtra("full_name",full_names);
        intent.putExtra("age_txt",ages);
        intent.putExtra("gender_txt",gender);
        intent.putExtra("teach",teacher);

        startActivity(intent);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        teacher = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}