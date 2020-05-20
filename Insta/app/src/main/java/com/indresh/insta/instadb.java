package com.indresh.insta;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class instadb{
    ArrayList<String> email=new ArrayList<String>();
    ArrayList<String> phone=new ArrayList<String>();
    ArrayList<String> pass=new ArrayList<String>();
    public instadb(){
        email.add("hello@hel.com");
        email.add("johndoe@jd.org");
        email.add("new@newest.com");
        phone.add("1234567890");
        phone.add("0987654321");
        phone.add("7865490000");
        pass.add("hel1234");
        pass.add("john1234");
        pass.add("new1234");
    }

    public boolean check_cred(String email,String phone,String pass){
        int j=0;
        for (int i=0;i < this.email.size();i++){
            if ((this.email.get(i).equals(email) || this.phone.get(i).equals(phone)) && this.pass.get(i).equals(pass)){
                    return true;
                }
        }
        return false;
    }
}
