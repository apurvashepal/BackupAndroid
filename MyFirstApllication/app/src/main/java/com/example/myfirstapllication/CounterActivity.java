package com.example.myfirstapllication;
import java.lang.CharSequence;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {
    Button madd,msubtract;
    TextView mcounter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);

        madd=findViewById(R.id.add);
        msubtract=findViewById(R.id.subtract);
        mcounter =findViewById(R.id.mycounter);
        mcounter.setText("0");
        madd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CounterActivity.this,CounterActivity.class);
                startActivity(intent);
                MediaPlayer ring= MediaPlayer.create(CounterActivity.this,R.raw.one_plus);
                ring.start();
                try{
                 //   Intent intent1=new Intent(CounterActivity.this,CounterActivity.class);
                  //  startActivity(intent1);
                String cs=String.valueOf(mcounter.getText());
                int c=Integer.parseInt(cs.toString());
                c=c+1;
                cs= Integer.toString(c);
                mcounter.setText(cs);}catch (Exception e){
                   System.out.println(e);
               }
            }

        });
        msubtract.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cs=mcounter.getText();
                int c=Integer.parseInt(cs.toString());
                if(c>0) {
                    c = c - 1;
                    cs = Integer.toString(c);
                    mcounter.setText(cs);
                }
                else {
                    cs= Integer.toString(0);
                    mcounter.setText(cs);
                }
            }

        });
    }
}
