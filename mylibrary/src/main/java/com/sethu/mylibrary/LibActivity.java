package com.sethu.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        TextView textView=(TextView)findViewById(R.id.textView1);
        String joke=getIntent().getStringExtra("joke");
        textView.setText(joke);
    }
}
