/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

/**
 *
 * @author juan.ramirez
 */
public class Plato {
    private boolean enUso=false;
    
    public Plato (){
    }
    
    public synchronized void usarPlato(){
        enUso=true;
    }
    public synchronized void comer(){
        System.out.println(Thread.currentThread().getName()+" esta ñom ñom");
        enUso=false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("dejo de ñom ñom");
        }
    }
}
