package com.example.rodrigo.sensores;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by CASTI on 19/06/2017.
 */

public class VibradorActivity extends AppCompatActivity{
   Button unaV,repetidas,stop;
    boolean estaVibrando = false;
    Vibrator vibrador;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibracion);
        unaV= (Button) findViewById(R.id.vibrarUna);
        repetidas= (Button) findViewById(R.id.vibrarRepetir);
        stop= (Button) findViewById(R.id.stop);
        vibrador = ((Vibrator) getSystemService(VIBRATOR_SERVICE));
        vibrador.cancel();
    }
    public void vibrarUnaVez (View view){
        if(!vibrador.hasVibrator()){
            Toast.makeText(VibracionActivity.this, "No soporta vibracion",Toast.LENGTH_LONG).show();
            return;
        }
        if(estaVibrando)
            vibrador.cancel();
        vibrador.vibrate(1000);
        estaVibrando=true;
        stop.setEnabled(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                estaVibrando= false;
                stop.setEnabled(false);
            }
        },1000);

    }

    public void vibrarRepetidas (View view){
        if(!vibrador.hasVibrator()){
            Toast.makeText(VibracionActivity.this, "No soporta vibracion",Toast.LENGTH_LONG).show();
            return;
        }
        if(estaVibrando)
            vibrador.cancel();
        long delay = 250;
        long sigueVip = 250;
        long on_off=250;
        int repeat =1;

        vibrador.vibrate(new long[]{delay,sigueVip,on_off,on_off,on_off},repeat);
        estaVibrando=true;
        stop.setEnabled(true);
    }

    public void detener(View view){
        if(!vibrador.hasVibrator()){
            Toast.makeText(VibracionActivity.this, "No soporta vibracion",Toast.LENGTH_LONG).show();
            return;
        }
        if(estaVibrando){
            vibrador.cancel();
            stop.setEnabled(false);
            estaVibrando= false;
        }
    }


}
