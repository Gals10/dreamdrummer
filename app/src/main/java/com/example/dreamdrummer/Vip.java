package com.example.dreamdrummer;


public class Vip extends User{

    private Boolean isver;


    public Vip (String email, String password, String username, Boolean isver, Integer points) {
        super(email,password,username, points);
        this.isver=isver;
    }

    public Boolean getIsver() {
        return this.isver;
    }
    public void setIsver(Boolean isver) {
        this.isver = isver;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "isver=" + isver +
                '}';
    }
}