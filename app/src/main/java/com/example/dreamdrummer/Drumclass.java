package com.example.dreamdrummer;


public class Drumclass
{

    private String name;

    public Drumclass( String name)
    {
        this.name=name;
    }

    public String  getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drumclass{" +
                "name='" + name + '\'' +
                '}';
    }
}