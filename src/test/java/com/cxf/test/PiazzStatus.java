package com.cxf.test;

public enum PiazzStatus {
    ORDERED("test", 001), READY("test", 001), DELIVERED("test", 001);

    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private PiazzStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.name + " , " + this.code;
    }

    public static void main(String[] args) {
        System.out.println(PiazzStatus.DELIVERED.getName());
        System.out.println(PiazzStatus.DELIVERED.toString());
    }
}
