package com.example.forco.togglemultifunctional;

import android.bluetooth.BluetoothAdapter;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
ToggleButton tb;
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

        tb=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    try{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,true);
                        ba.enable();
                        wm.setWifiEnabled(true);
                        wifi=true;
                        camera=true;
                        bluetooth=true;

                    }
                    catch (CameraAccessException e){

                    }

                }
                else {
                    try{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                        ba.enable();
                        wm.setWifiEnabled(false);
                        wifi=true;
                        camera=true;
                        bluetooth=true;

                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
    }
}
