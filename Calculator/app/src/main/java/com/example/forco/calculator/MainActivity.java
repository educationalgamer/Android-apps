package com.example.forco.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float i1=Float.parseFloat(s1);
                Float i2=Float.parseFloat(s2);
                Float i3=i1+i2;
                String s3=Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(MainActivity.this, s3, Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float i1=Float.parseFloat(s1);
                Float i2=Float.parseFloat(s2);
                Float i3=i1-i2;
                String s3=Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(MainActivity.this, s3, Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float i1=Float.parseFloat(s1);
                Float i2=Float.parseFloat(s2);
                Float i3=i1*i2;
                String s3=Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(MainActivity.this, s3, Toast.LENGTH_SHORT).show();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float i1=Float.parseFloat(s1);
                Float i2=Float.parseFloat(s2);
                Float i3=i1/i2;
                String s3=Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(MainActivity.this, s3, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
