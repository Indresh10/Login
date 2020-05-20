package com.indresh.insta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.regex.Pattern;

public class Signup_Activity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    DatePicker d1;
    instadb dbs;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        e1=findViewById(R.id.first);
        e2=findViewById(R.id.last);
        e3=findViewById(R.id.email);
        e4=findViewById(R.id.phone);
        e5=findViewById(R.id.pass);
        e6=findViewById(R.id.repass);
        d1=findViewById(R.id.dates);
        dbs=new instadb();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.YEAR,-18);
        d1.setMaxDate(cal.getTimeInMillis());
        ;
        type= getIntent().getStringExtra("login");
    }

    public void onSign(View v){
        boolean email_pattern=Pattern.matches("[a-zA-z0-9_./]+@[a-z]+\\.+[a-z]{3}$",e3.getText().toString());
        boolean phone_Pattern=Pattern.matches("[a-zA-Z./!@#$%^&*()_]",e4.getText().toString());

        if (e1.getText().toString().equals("")){
        e1.setError("Name Can't Be Blank");
        e1.requestFocus();
        }
        else if (e2.getText().toString().equals("")){
            e2.setError("Name Can't be Blank");
            e2.requestFocus();
        }
        else if (!email_pattern){
            e3.setError("Not a Valid Email Address");
            e3.requestFocus();
        }
        else if (phone_Pattern){
            e4.setError("Not A valid Phone Number");
            e4.requestFocus();
        }
        else if (!e5.getText().toString().equals(e6.getText().toString())){
            e6.setError("Password doesn't with above");
            e6.requestFocus();
        }
        else {
            Toast.makeText(this, "Data Saved Successfully\n now Proceed to Login ", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Welcome_Activity.class);
            i.putExtra("Email",e3.getText().toString());
            startActivity(i);
        }
    }
}

