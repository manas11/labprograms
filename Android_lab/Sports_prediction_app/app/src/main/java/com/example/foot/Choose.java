package com.example.foot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
      final ImageView foot=findViewById(R.id.imageView);
        final ImageView cric=findViewById(R.id.imageView3);
foot.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Choose.this,Footballers.class);
        startActivity(intent);
    }
});
cric.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Choose.this,cricketerman.class);
        startActivity(intent);
    }
});
    }
}
