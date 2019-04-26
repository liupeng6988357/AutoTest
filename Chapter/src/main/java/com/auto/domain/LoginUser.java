package com.auto.domain;

public class LoginUser {

    private int caseid;
    private String username;
    private String password;
    private int state;

    public int getCaseid() {
        return caseid;
    }

    public void setCaseid(int caseid) {
        this.caseid = caseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
