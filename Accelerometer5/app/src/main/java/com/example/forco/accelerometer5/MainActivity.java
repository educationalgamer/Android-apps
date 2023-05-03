package com.example.forco.accelerometer5;

import android.bluetooth.BluetoothAdapter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    Vibrator v1;
    WifiManager wm;
   CameraManager cm;
   BluetoothAdapter ba;
    private boolean camera=false;
    private boolean bluetooth=false;
    private boolean wifi=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.y);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if(x1!=0|| Build.VERSION.SDK_INT>24||(camera=false)||(bluetooth=false)||(wifi=false))
        {
            mp.start();
            v1.vibrate(7000);
            try {
                String s1 = cm.getCameraIdList()[0];

                ba.enable();
                wm.setWifiEnabled(true);
                cm.setTorchMode(s1, true);
                wifi = true;
                camera = true;
                bluetooth = true;
            } catch (CameraAccessException e){
            }
        }
        else
        {
            mp.pause();
            v1.vibrate(7000);
            try {
                String s1=cm.getCameraIdList()[0];
                ba.disable();
                wm.setWifiEnabled(false);
                cm.setTorchMode(s1, false);
                wifi=false;
                bluetooth=false;
                camera=false;
            }
            catch (CameraAccessException e)
            {

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
