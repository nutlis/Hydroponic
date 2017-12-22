package com.example.nut.hydroponic.Models;

/**
 * Created by nut on 15/12/2560.
 */

public class Users {
    private String id;
    private String email;

    public Users(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
