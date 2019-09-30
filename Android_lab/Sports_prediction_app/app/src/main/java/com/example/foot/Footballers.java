package com.example.foot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Footballers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footballers);
        ImageView imageView=findViewById(R.id.imageView2);
        ImageView imageView1=findViewById(R.id.imageView4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Footballers.this,Fatt.class);
                startActivity(intent);
            }
        });
       imageView1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Footballers.this,fdef.class);
               startActivity(intent);

           }
       });
    }
}
