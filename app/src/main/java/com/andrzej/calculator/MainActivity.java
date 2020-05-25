package com.andrzej.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simple = (Button) findViewById(R.id.simpleButton);
        simple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMain = new Intent(MainActivity.this ,
                        SimpleCalculatorActivity.class);
                MainActivity.this.startActivity(intentMain);
            }
        });

        Button advanced = (Button) findViewById(R.id.advancedButton);
        advanced.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMain = new Intent(MainActivity.this ,
                        AdvancedCalculatorActivity.class);
                MainActivity.this.startActivity(intentMain);
            }
        });


    }
}
