package com.example.dreamdrummer;

public class Guitar extends Band {
    private int equ;
    public Guitar (String name, String gender,Integer equ)
    {
        super(name, gender);
        this.equ=equ;
    }

    public int getEqu() {
        return equ;
    }

    public void setEqu(int equ) {
        this.equ = equ;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "equ=" + equ +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
