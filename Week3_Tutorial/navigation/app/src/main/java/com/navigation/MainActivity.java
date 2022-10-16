package com.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1;
    Button b1;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.t1);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        t1.setText("You clicked button 1");
    }

    public void doSomething(View v){
        t1.setText("You clicked button 2");
    }
}