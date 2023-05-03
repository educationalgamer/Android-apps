package com.example.ui;

import static com.example.ui.R.id.linearlayout;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button dark;
    Button light;
    LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dark=findViewById(R.id.btndark);
        light=findViewById(R.id.btnread);
        layout=findViewById(R.id.linearlayout);
            light.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout.setBackgroundResource(R.color.yellow);

                }
            });
               dark.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       layout.setBackgroundResource(R.color.black);
                   }
               });
        Toast.makeText(this, "made by anshu", Toast.LENGTH_SHORT).show();
    }
}