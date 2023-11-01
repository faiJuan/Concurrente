/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

/**
 *
 * @author Fenix
 */
public class Rueda {
    private boolean enUso=false;
    
    public Rueda (){
    }
    
    public boolean getUso(){
        return enUso;
    }
    public void usarPlato(){
        enUso=true;
    }
    
    public synchronized void comer(){
        System.out.println(Thread.currentThread().getName()+" esta corriendo");
        enUso=false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("dejo de correr");
        }
    }
}
