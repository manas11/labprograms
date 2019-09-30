package com.example.foot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Batsman extends AppCompatActivity {
    int a1,a2,a3,a4,a5,a6,a7,clr,a8,a9,a10,a11,a12,a13,a14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batsman);
        final TextView matches= findViewById(R.id.editText2);
        final TextView inn= findViewById(R.id.textView9);

        final TextView runs= findViewById(R.id.textView10);
        final TextView notouts= findViewById(R.id.textView11);
        final TextView hs= findViewById(R.id.textView12);
        final TextView avgr= findViewById(R.id.textView13);
        final TextView bf=findViewById(R.id.textView14);
        final TextView strr=findViewById(R.id.textView15);
        final TextView hund=findViewById(R.id.textView16);

        final TextView fif=findViewById(R.id.textView17);
        final TextView boun=findViewById(R.id.textView18);
        final TextView six=findViewById(R.id.textView19);
        final TextView cla=findViewById(R.id.textView20);
        final TextView ducks=findViewById(R.id.textView21);

        final TextView pruns=findViewById(R.id.pruns);
        final TextView pavg=findViewById(R.id.pavg);
        final TextView pstr=findViewById(R.id.pstr);
        final Button predict =findViewById(R.id.buttonpredict);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1= (int) Double.parseDouble(matches.getText().toString());
                a2= (int) Double.parseDouble(inn.getText().toString());
                a3= (int) Double.parseDouble(runs.getText().toString());
                a4= (int) Double.parseDouble(notouts.getText().toString());
                a5= (int) Double.parseDouble(hs.getText().toString());
                a6= (int) Double.parseDouble(avgr.getText().toString());
                a7= (int) Double.parseDouble(bf.getText().toString());
                a8= (int) Double.parseDouble(strr.getText().toString());
                a9= (int) Double.parseDouble(hund.getText().toString());
                a10= (int) Double.parseDouble(fif.getText().toString());
                a11= (int) Double.parseDouble(boun.getText().toString());
                a12= (int) Double.parseDouble(six.getText().toString());
                a13= (int) Double.parseDouble(cla.getText().toString());
                a14=(int) Double.parseDouble(ducks.getText().toString());

                clr= (int) (-162.748494-(a1*2.100201)+(a2*2.729706)-(a3*3.981122)-(a4*0.083083)+(a5*0.270342)+(a6*1.413872)+(a7*0.171319)+(a8*1.312172)-(a9*9.690364)-(a10*4.103782)+(a14*1.272525)-(a11*0.533934)-(a12*0.221205)+(a13*214.363672));
                pruns.setText(String.valueOf(clr));
                clr= (int) (36.527519-(a1*0.388245)-(a2*0.044966)+(a3*0.155698)+(a4*0.071809)+(a5*0.035221)+(a6*0.160005)-(a7*0.032673)-(a8*0.168021)-(a9*1.326783)-(a10*0.372872)-(a14*0.500695)-(a11*0.128354)-a12*0.188291+(a13*3.207724));
                pavg.setText(String.valueOf(clr));
                clr= (int)(44.198364-(a1*0.038033)-(a2*0.088987)+(a3*0.027944)+(a4*0.024234)+(a5*0.004631)-(a6*0.087260)-(a7*0.018803)+(a8*0.500245)-(a9*1.010814)-(a10*0.464918)-(a14*0.016308)+(a11*0.012730)+(a12*0.078775)+(a13*1.522130));
                pstr.setText(String.valueOf(clr));
            }
        });
    }
}
