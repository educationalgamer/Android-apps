package com.example.forco.multifunctionalapp;

import android.bluetooth.BluetoothAdapter;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    CameraManager cm;
    WifiManager wm;
    BluetoothAdapter ba;
    private boolean camera=false;
    private boolean bluetooth=false;
    private boolean wifi=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((camera==false) || (bluetooth==false) || (wifi==false)){
                    try {
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,true);
                        ba.enable();
                        wm.setWifiEnabled(true);
                        ib.setImageResource(R.drawable.y);
                        wifi=true;
                        camera=true;
                        bluetooth=true;

                    }
                    catch (CameraAccessException e){

                    }
                }
                else {
                    try {
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                        ba.disable();
                        wm.setWifiEnabled(false);
                        ib.setImageResource(R.drawable.x);
                        wifi=false;
                        bluetooth=false;
                        camera=false;
                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
    }
}
