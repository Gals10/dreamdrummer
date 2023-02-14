package com.example.dreamdrummer;

public class Piano extends Band {
    private int exp;
    public Piano (String name, String gender, int exp)
    {
        super(name, gender);
        this.exp=exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean checkexp()
    {
        return (this.exp > 1);
    }

    @Override
    public String toString() {
        return "Piano{" +
                "exp=" + exp +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
