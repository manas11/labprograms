package com.example.foot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class cricketerman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketerman);
        final ImageView bats=findViewById(R.id.imageView2);
        final ImageView bowlers=findViewById(R.id.imageView4);
bats.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent intent=new Intent(cricketerman.this,Batsman.class);
    startActivity(intent);
    }
});
bowlers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(cricketerman.this,Bowlers.class);
startActivity(intent);
    }
});
    }
}
