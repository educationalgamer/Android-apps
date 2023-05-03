package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private CardView web;
private CardView camera;
private TextView webbutton;
private TextView camerabutton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.cardweb);
        camera=findViewById(R.id.camera);
        webbutton=findViewById(R.id.webbutton);
        camerabutton=findViewById(R.id.camerabutton);

        webbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://educationalgamer.blogspot.com/"));
                startActivity(intent);
            }
        });
       camerabutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivity(intent);
           }
       });

    }
}