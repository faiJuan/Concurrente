/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto1;

/**
 *
 * @author Fenix
 */
public class Hilos implements Runnable {
    SynchronizedObjectCounter recurso;
    
    public Hilos(SynchronizedObjectCounter rec){
        recurso=rec;
        
    }
    
    public void run() {
        for (int i = 0; i < 4; i++) {
            recurso.increment();
        }
        recurso.decrement();
        System.out.println(recurso.value());
    }
    
    
}
