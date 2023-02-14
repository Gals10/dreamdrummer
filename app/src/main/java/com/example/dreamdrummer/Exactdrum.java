package com.example.dreamdrummer;

import android.widget.ImageView;

public class Exactdrum extends Drumclass {
    private ImageView drum;
    private String shimosh;
    private String sound;
    public Exactdrum(ImageView drum ,String shimosh, String sound, String name)
    {
        super(name);
        this.drum=drum;
        this.shimosh=shimosh;
        this.sound=sound;
    }

    public ImageView getDrum() {
        return this.drum;
    }

    public void setDrum(ImageView degel) {
        this.drum = drum;
    }

    public String getShimosh() {
        return this.shimosh;
    }

    public void setShimosh(String capitalCity) {
        this.shimosh = shimosh;
    }

    public String getSound() {
        return this.sound;
    }

    public void setSound(String population) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Exactdrum{" +
                "drum=" + drum +
                ", shimosh='" + shimosh + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }
}

