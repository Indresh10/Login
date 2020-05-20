package com.indresh.insta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class facebook_Activity extends AppCompatActivity {
    String Email;
    instadb dbs;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_facebook);
        Email=getIntent().getStringExtra("Email");
        dbs=new instadb();
        e1=findViewById(R.id.uname1);
        e2=findViewById(R.id.passd1);
        e1.setText(Email);
    }

    @Override
    protected void onStart() {
        super.onStart();
        e1.setText(Email);
        e2.setText("");
    }

    public void onSign(View v){
        Intent i = new Intent(this,Signup_Activity.class);
        startActivity(i);
        i.putExtra("login","FB");

    }

    public void onLog(View v){
        boolean success=dbs.check_cred(e1.getText().toString(),e1.getText().toString(),e2.getText().toString());
        if (success){
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Welcome_Activity.class);
            i.putExtra("Email",e1.getText().toString());
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Check Your email/phone and Password", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
        }
    }
}
