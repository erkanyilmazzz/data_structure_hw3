package com.company;

public class Var {
    private char c;
    private double value;

    public Var(){
        c=0;
        value=0;
    }

    public char getC() {
        return c;
    }

    public void setC(char _c) {
        this.c = _c;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double _value) {
        this.value = _value;
    }

    public static boolean  isHere(char c,Var[] arr){
    int i=0;
    for(i=0;i<arr.length;++i){
        if(c==arr[i].getC()){
            return true;
        }
    }

    return false;
    }

    public static double whatValue(char c,Var[] arr){
     int i=0;
        for(i=0;i<arr.length;++i){
            if(c==arr[i].getC()){
                return arr[i].getValue();
            }
        }
     return -1;
    }
}
