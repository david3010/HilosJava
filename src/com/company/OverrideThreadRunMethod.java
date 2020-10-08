package com.company;

public class OverrideThreadRunMethod extends Thread {
    boolean enEjecucion = false;
    public void run(){
        enEjecucion = true;
        System.out.println("I am in run() method");
        enEjecucion = false;
    }
}
