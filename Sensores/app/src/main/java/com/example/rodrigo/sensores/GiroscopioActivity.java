package com.example.rodrigo.sensores;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import co.gofynd.gravityview.GravityView;

public class GiroscopioActivity extends AppCompatActivity {

    GravityView gravityView;
    ImageView vista_imagen;
    boolean is_supported;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giroscopio_layout);
        vista_imagen = (ImageView)findViewById(R.id.imagen);
        gravityView = GravityView.getInstance(this)
                .setImage(vista_imagen, R.drawable.land_image)
                .center();

        is_supported = gravityView.deviceSupported();
        if(!is_supported){
            Toast.makeText(this, "La aplicación no es soportada. No se tiene giroscopio", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }
    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }

    public void irInfo(View v){
        Intent i = new Intent(this, GiroscopioInfo.class);
        startActivity(i);
    }
}
