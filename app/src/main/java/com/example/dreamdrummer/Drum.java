package com.example.dreamdrummer;

public class Drum extends Band {
    private Integer sticks;
    public Drum (String name, String gender, Integer sticks)
    {
        super(name, gender);
        this.sticks=sticks;
    }

    public Integer getSticks() {
        return sticks;
    }

    public void setSticks(int sticks) {
        this.sticks = sticks;
    }
    public boolean Checksticks()
    {
        return (this.sticks > 2);
    }

    @Override
    public String toString() {
        return "Drum{" +
                "sticks=" + sticks +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
