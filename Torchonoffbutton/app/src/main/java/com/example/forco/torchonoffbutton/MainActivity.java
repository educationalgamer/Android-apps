package com.example.forco.torchonoffbutton;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        cm=(CameraManager) getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s1=cm.getCameraIdList()[0];
                    cm.setTorchMode(s1,true);
                }
                catch (CameraAccessException e){

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s2 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s2, false);
                } catch (CameraAccessException e) {
                }
            }

        });
    }
}
