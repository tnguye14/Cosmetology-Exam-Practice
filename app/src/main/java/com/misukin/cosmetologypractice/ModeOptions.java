package com.misukin.cosmetologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeOptions extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_options);

        button1 = (Button) findViewById(R.id.practice);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity1();
            }
        });

        button2 = (Button) findViewById(R.id.test);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }

    public void openActivity1() {
        Intent intent = new Intent(this, Practice1.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Test1.class);
        startActivity(intent);
    }
}