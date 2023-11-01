/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto1;

/**
 *
 * @author juan.ramirez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread[] hilos= new Thread[4];
        SynchronizedObjectCounter recurso= new SynchronizedObjectCounter();
        for (int i = 0; i < 4; i++) {
            hilos[i]= new Thread (new Hilos(recurso));
            hilos[i].start();
        }
    }
    
}
