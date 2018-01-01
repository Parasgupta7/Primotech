package com.example.paras.primotech;

/**
 * Created by anmol on 1/1/2018.
 */

class User {

    private String username, email, gender;
    int id;

    public User(int id, String username, String email, String gender) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }
}
