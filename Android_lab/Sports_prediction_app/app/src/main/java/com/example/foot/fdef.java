package com.example.foot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class fdef extends AppCompatActivity {
    int a1,a2,a3,a4,a5,a6,a7,clr,a8,a9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdef);
        final TextView min= findViewById(R.id.editText2);
        final TextView takl= findViewById(R.id.textView9);

        final TextView inter= findViewById(R.id.textView10);
        final TextView foul= findViewById(R.id.textView11);
        final TextView off= findViewById(R.id.textView12);
        final TextView clear= findViewById(R.id.textView13);
        final TextView dribble=findViewById(R.id.textView14);
        final TextView block=findViewById(R.id.textView15);
        final TextView avg=findViewById(R.id.textView16);

        final TextView pclear=findViewById(R.id.pclear);
        final TextView pinter=findViewById(R.id.pinter);
        final TextView ptack=findViewById(R.id.ptack);

        final Button predict =findViewById(R.id.buttonpredict);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1= (int) Double.parseDouble(min.getText().toString());
                a2= (int) Double.parseDouble(takl.getText().toString());
                a3= (int) Double.parseDouble(inter.getText().toString());
                a4= (int) Double.parseDouble(foul.getText().toString());
                a5= (int) Double.parseDouble(off.getText().toString());
                a6= (int) Double.parseDouble(clear.getText().toString());
                a7= (int) Double.parseDouble(dribble.getText().toString());
                a8= (int) Double.parseDouble(block.getText().toString());
                a9= (int) Double.parseDouble(avg.getText().toString());
                clr= (int) (1.090337-(a1*0.000079)-(a2*0.250877)-(a3*0.125207)+(a4*0.100020)+(a5*0.256761)+(a6*0.333853)+(a7*0.002485)+(a8*0.139616)+(a9*0.250610)+(a9*1.5*0.484642));
                pclear.setText(String.valueOf(clr));
                clr= (int) (-0.288153+(a1*0.000069)-(a2*0.001520)+(a3*0.089345)-(a4*0.001774)-(a5*0.005856)-(a6*0.116321)-(a7*0.005895)-(a8*0.049947)+(a9*0.066999)+(a9*1.5*0.264956));
                pinter.setText(String.valueOf(clr));
                clr= (int) (-0.802184+(a1*0.000010)+(a2*0.252397)+(a3*0.035862)-(a4*0.098246)-(a5*0.250905)-(a6*0.217572)+(a7*0.008380)-(a8*0.089669)+(a9*0.183611)+(a9*1.5*0.250402));
ptack.setText(String.valueOf(clr));
            }
    });
}
}