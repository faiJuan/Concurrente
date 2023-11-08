/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juan.ramirez
 */
public class Impresora {
    private boolean ocupado;
    private Semaphore mutex;
    public Impresora(){
        this.ocupado=false;
        this.mutex= new Semaphore (1);
    }
    
    public boolean imprimir () throws InterruptedException{
        boolean pudeImp=false;
        mutex.acquire();
        if(!ocupado){
            ocupado=true;
            mutex.release();
            this.imprime();
            mutex.acquire();
            ocupado=false;
            mutex.release();
            pudeImp=true;
        }
        else{
            mutex.release();
            //System.out.println("impresora ocupada");
        }
        return pudeImp;
    }
    
    private void imprime(){
        System.out.println(Thread.currentThread().getName()+"esta imprimiendo");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println("no pudo :c");
        }
        System.out.println(Thread.currentThread().getName()+" termino");
    }
}
