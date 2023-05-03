package com.example.forco.imagebuttontorch;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    BluetoothAdapter ba;
private boolean bl=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ib=(ImageButton)findViewById(R.id.imageButton);
        ba=BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bl==false){
                    ba.enable();
                    ib.setImageResource(R.drawable.x);
                    bl=true;
                }
                else {
                    ba.disable();
                    ib.setImageResource(R.drawable.y);
                    bl=false;
                }
            }
        });
    }
}
