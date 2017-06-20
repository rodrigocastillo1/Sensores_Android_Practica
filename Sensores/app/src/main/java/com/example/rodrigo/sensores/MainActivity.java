package com.example.rodrigo.sensores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button vibrador;
    Button giroscopio;
    Button proximidad;
    Button acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrador.setOnClickListener(this);
        giroscopio.setOnClickListener(this);
        proximidad.setOnClickListener(this);
        acelerometro.setOnClickListener(this);
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
