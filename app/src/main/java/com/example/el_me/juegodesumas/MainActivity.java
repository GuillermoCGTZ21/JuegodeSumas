package com.example.el_me.juegodesumas;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
//Nuestras Variables
    TextView tiempo= (TextView)findViewById(R.id.tiempo) ;
    TextView Num1=(TextView)findViewById(R.id.Num1);
    TextView Num2= (TextView)findViewById(R.id.Num2);
    TextView correcto= (TextView)findViewById(R.id.correcto);
    TextView incorrecto= (TextView)findViewById(R.id.Incorrecto);
    Boolean counterIsActive = false;
    Button start = (Button)findViewById(R.id.BotonStart);
    Button next= (Button)findViewById(R.id.next);
    Button reset= (Button)findViewById(R.id.reset);
    EditText respuesta= (EditText) findViewById(R.id.respuesta);
    CountDownTimer countDownTimer;

// onClick Pal' Reset
    public void reset(View view){
        tiempo.setText("00:30");
        countDownTimer.cancel();
        start.setText("Start");
        counterIsActive = false;
        Num1.setText("");
        Num2.setText("");
        start.setEnabled(true);
        correcto.setText("0");
        incorrecto.setText("0");}
    public void next (View view){     int num1 = (int)Math.random();
        Num1.setText(num1);
        int num2 = (int)Math.random();
        Num2.setText(num2);
        int resultado = num1 + num2;
        String srespuesta=respuesta.getText().toString().trim();

        int nrespuesta=Integer.parseInt(srespuesta);

        if(nrespuesta==resultado){
            String snumcorrectas= correcto.getText().toString().trim();

            Integer numcorrectas= Integer.parseInt(snumcorrectas);
            correcto.setText(numcorrectas+1);

        } else{
            String snumincorrectas= incorrecto.getText().toString().trim();

            Integer numincorrectas= Integer.parseInt(snumincorrectas);
            correcto.setText(numincorrectas+1);

        }

    }

//onClick Pal' Start
    public void start (View view){
    reset.setEnabled(false);
    start.setEnabled(false);
        correcto.setText("0");
        incorrecto.setText("0");
        int num1 = (int)Math.random();
        Num1.setText(num1);
        int num2 = (int)Math.random();
        Num2.setText(num2);


if (!counterIsActive) {

                counterIsActive = true;

                // We set the timer to the number of seconds specified in the seek bar.  We add a tenth
                // of a second (100 milliseconds) to the initial value.
                new CountDownTimer(30000,1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        updateTimer((int) millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        tiempo.setText("00:00");
                        next.setEnabled(false);

                    }


                    public void updateTimer(int secondsLeft) {
            // We get the number of minuts and seconds
            int minutes = (int) secondsLeft / 60;
            int seconds = (int) secondsLeft % 60;

            // If the number of seconds are less than 10, we add a preceding 0 to the
            // seconds string.
            String secondsString = Integer.toString(seconds);
            if (secondsString.length() < 2) {
                secondsString = "0" + secondsString;
            }

            // If the number of minutes are less than 10, we add a preceding 0 to the
            // minutes string
            String minutesString = Integer.toString(minutes);
            if (minutesString.length() < 2) {
                minutesString = "0" + minutesString;
            }

            // We change the text displayed on our user interface, to reflect the time
            // remaining in our timer.
            tiempo.setText(minutesString + ":" + secondsString);
        }
};
}
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}}
