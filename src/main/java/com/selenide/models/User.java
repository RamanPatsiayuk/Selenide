package com.selenide.models;

public class User {

    private String login;
    private String password;
    private String domain;

    public User() {
    }

    public User(String login, String password, String domain) {
        this.login = login;
        this.password = password;
        this.domain = domain;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
