package com.example.foot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bowlers extends AppCompatActivity {
int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowlers);
        final TextView matches = findViewById(R.id.editText2);
        final TextView inn = findViewById(R.id.textView9);

        final TextView oversbowled = findViewById(R.id.textView10);
        final TextView runs = findViewById(R.id.textView11);
        final TextView wickets = findViewById(R.id.textView12);
        final TextView avg = findViewById(R.id.textView13);
        final TextView eco = findViewById(R.id.textView14);
        final TextView  strike= findViewById(R.id.textView15);
        final TextView currentyear = findViewById(R.id.textView16);

        final TextView fourwicket = findViewById(R.id.textView17);
        final TextView boun = findViewById(R.id.textView18);
        final TextView six = findViewById(R.id.textView19);
        final TextView cla = findViewById(R.id.textView20);
        final TextView fivehauls = findViewById(R.id.textView21);

        final TextView pwicket = findViewById(R.id.pwicket);
        final TextView peco = findViewById(R.id.peco);
        final TextView pstr = findViewById(R.id.pstr);
        final Button predict = findViewById(R.id.buttonpredict);
final TextView maidens=findViewById(R.id.textView22);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1 = (int) Double.parseDouble(matches.getText().toString());
                a2 = (int) Double.parseDouble(inn.getText().toString());
                a3 = (int) Double.parseDouble(oversbowled.getText().toString());
                a5 = (int) Double.parseDouble(runs.getText().toString());
                a6 = (int) Double.parseDouble(wickets.getText().toString());
                a7 = (int) Double.parseDouble(avg.getText().toString());
                a8 = (int) Double.parseDouble(eco.getText().toString());
                a9 = (int) Double.parseDouble(strike.getText().toString());
                a10 = (int) Double.parseDouble(currentyear.getText().toString());
                a11 = (int) Double.parseDouble(fourwicket.getText().toString());
                a13 = (int) Double.parseDouble(cla.getText().toString());
                a12 = (int) Double.parseDouble(fivehauls.getText().toString());
a4=(int) Double.parseDouble(maidens.getText().toString());
                clr = (int) (-8.186553 - (a1 * 0.210336) + (a2 * 0.253626) - (a3 * 0.002328) +(a4 *0.017004) - (a5 * 0.001885) + (a6 * 0.060385) - (a7 * 0.011834) + (a8 * 0.096391) + (a9 * 0.032303) - (a10 * 0.359710) + (a11 * 0.034147) + (a12 * 0.003879) + (a13 * 9.401929));
                pwicket.setText(String.valueOf(clr));
                clr = (int) (-42.916327 - (a1 * 0.022480) + (a2 * 0.059436) - (a3 * 0.015609) + (a4 * 0.003284) + (a5 * 0.002010) + (a6 * 0.0066835) - (a7 * 0.019861) + (a8 * 0.261930) + (a9 * 0.009623) - (a10 * 0.043366) + (a11 * 0.029170) + (a12 * 0.023377) - a13 * 0.075450);
                peco.setText(String.valueOf(clr));

            }
        });
    }}
