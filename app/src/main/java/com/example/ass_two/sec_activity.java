package com.example.ass_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class sec_activity extends AppCompatActivity {

    TextView name_txt, ages_txt,genders_txt ,tea_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_activity);

        name_txt=findViewById(R.id.name_txt);
        ages_txt=findViewById(R.id.ages_txt);
        genders_txt=findViewById(R.id.genders_txt);
        tea_txt=findViewById(R.id.tea_txt);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String names = bundle.getString("full_name");
            String ages = bundle.getString("age_txt");
            String genders = bundle.getString("gender_txt");
            String teachs = bundle.getString("teach");
            name_txt.setText("Name :"+names);
            ages_txt.setText("Ages: "+ages);
            genders_txt.setText("Gender: "+genders);
            tea_txt.setText("Degree: "+teachs);



        }
    }
}