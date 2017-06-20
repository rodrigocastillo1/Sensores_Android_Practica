package com.example.rodrigo.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProximidadActivity extends AppCompatActivity implements SensorEventListener{

    LinearLayout lin_lay;
    SensorManager sen_man;
    Sensor sensor;
    TextView info, contador;
    int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i=0;
        setContentView(R.layout.proximidad_layout);
        lin_lay = (LinearLayout)findViewById(R.id.layout_prox);
        info = (TextView)findViewById(R.id.texto_prox);
        contador = (TextView)findViewById(R.id.prox_contador);
        sen_man = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sen_man.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sen_man.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Para el sensor de proximidad, el arreglo value, sólo tiene información
        //en la posición 0, y esta es la distancia a la que hay un objeto del sensor
        String distancia = String.valueOf(event.values[0]);
        i++;
        contador.setText("Entrada: "+i);
        info.setText("Distancia: "+distancia);
        float dis_value = Float.parseFloat(distancia);

        if(dis_value <= 3){
            lin_lay.setBackgroundColor(Color.GRAY);
        }else{
            lin_lay.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Nos permite medir cuando la precisión del sensor cambia.
        //En este momento no vamos a uilizarla
    }
}
