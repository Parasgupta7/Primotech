package com.example.paras.primotech;

/**
 * Created by anmol on 1/5/2018.
 */

public class User {


    String uname,pw,email,id,phone,name;

    public User(String id,String name, String uname, String email, String pw,String phone) {


        this.id=id;
        this.name=name;
        this.uname=uname;
        this.email=email;
        this.pw=pw;
        this.phone=phone;
    }

    public User(){

    }

    public User(String uname, String email) {



        this.uname=uname;
        this.email=email;

    }


    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
    public String getPhone() {
        return phone;
    }


}
