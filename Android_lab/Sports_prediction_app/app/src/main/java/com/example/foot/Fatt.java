package com.example.foot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fatt extends AppCompatActivity {

    int val,a1,a2,a3,a4,a5,a6,a7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatt);
final TextView age= findViewById(R.id.editText2);
        final TextView mins= findViewById(R.id.textView9);

        final TextView goalsscored= findViewById(R.id.textView10);
        final TextView Assists= findViewById(R.id.textView11);
        final TextView Penalty= findViewById(R.id.textView12);
        final TextView sot= findViewById(R.id.textView13);
        final TextView p=findViewById(R.id.textView14);
        final TextView cl=findViewById(R.id.textView16);

        final Button predict =findViewById(R.id.buttonpredict);
final TextView pgoals=findViewById(R.id.GP);

predict.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        p.setVisibility(View.VISIBLE);
        a1= (int) Double.parseDouble(age.getText().toString());
        a2= (int) Double.parseDouble(mins.getText().toString());
        a3= (int) Double.parseDouble(goalsscored.getText().toString());
        a4= (int) Double.parseDouble(Assists.getText().toString());
        a5= (int) Double.parseDouble(Penalty.getText().toString());
        a6= (int) Double.parseDouble(sot.getText().toString());
        a7= (int) Double.parseDouble(cl.getText().toString());
      val= (int) (-1.226266-(a1*0.090807)-(a2*0.000355)+(a3*0.076965)+(a4*0.066951)+(a5*0.241875)-(a6*0.034154)+(a7*7.555800));
      int ve=val;
     pgoals.setText(String.valueOf(ve));
    }
});

    }
}
