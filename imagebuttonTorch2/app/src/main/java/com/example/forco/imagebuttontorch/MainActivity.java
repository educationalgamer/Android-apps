package com.example.forco.imagebuttontorch;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    CameraManager cm;
    private boolean torch=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String cameraId = cm.getCameraIdList()[0];
                    if (torch==true) {
                        cm.setTorchMode(cameraId, false);
                        ((ImageButton) view).setImageResource(R.drawable.x);
                    } else {
                        cm.setTorchMode(cameraId, true);
                        ((ImageButton) view).setImageResource(R.drawable.y);
                    }
                } catch (CameraAccessException e) {

                }
            }
        });

    }
}
