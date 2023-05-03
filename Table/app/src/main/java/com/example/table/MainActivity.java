package com.example.table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String number=editText.getText().toString();
               int n=Integer.parseInt(number);
               result="";
                for (int i = 1; i <=10 ; i++) {
                    result+=n+ " "+"*"+i+" "+"="+""+n*i+"\n";
                    textView.setText(result);
                }

            }
        });
        Toast.makeText(getApplicationContext(),"made by anshu",Toast.LENGTH_SHORT);
    }
}