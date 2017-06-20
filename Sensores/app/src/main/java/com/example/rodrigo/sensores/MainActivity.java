package com.example.rodrigo.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button vibrador;
    Button giroscopio;
    Button proximidad;
    Button acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrador= (Button) findViewById(R.id.vibrador);
        giroscopio= (Button) findViewById(R.id.giroscopio);
        proximidad= (Button) findViewById(R.id.proximidad);
        acelerometro= (Button) findViewById(R.id.acelerometro);
        salida = (TextView) findViewById(R.id.salida);
        
        vibrador.setOnClickListener(this);
        giroscopio.setOnClickListener(this);
        proximidad.setOnClickListener(this);
        acelerometro.setOnClickListener(this);
        
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor: listaSensores) {
            log(sensor.getName());
        }   
    }
    
     private void log(String string) {
        salida.append(string + "\n");
    }
    
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.vibrador:
                Intent intent = new Intent(this, VibradorActivity.class);
                startActivity(intent);
                break;

            case R.id.acelerometro:
                Intent i = new Intent(this, AcelerometroActivity.class);
                startActivity(i);
                break;
            case R.id.giroscopio:
                Intent inte = new Intent(this, GiroscopioActivity.class);
                startActivity(inte);
                break;

            case R.id.proximidad:
                Intent in = new Intent(this, ProximidadActivity.class);
                startActivity(in);
                break;
        }
    }
}
