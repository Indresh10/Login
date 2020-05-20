package com.indresh.insta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome_Activity extends AppCompatActivity {
    TextView t;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t=findViewById(R.id.textView);
        Email=getIntent().getStringExtra("Email");
        t.append(" " + Email);
    }

}
