package com.cxf.wordorder;

public class Car {
    private String par1;
    private String par2;

    public String getPar1() {
        return par1;
    }

    public void setPar1(String par1) {
        this.par1 = par1;
    }

    public String getPar2() {
        return par2;
    }

    public void setPar2(String par2) {
        this.par2 = par2;
    }

    @Override
    public String toString() {
        return "Car{" +
                "par1='" + par1 + '\'' +
                ", par2='" + par2 + '\'' +
                '}';
    }
}
