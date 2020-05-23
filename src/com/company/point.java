package com.company;

public class point {
    private boolean value;
    private int x;
    private int y;


    public point(boolean isOne,int _x,int _y){
        value=isOne;
        x=_x;
        y=_y;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isOne() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
