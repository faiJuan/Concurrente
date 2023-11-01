/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto1;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author juan.ramirez
 */
public class GestorPiscina {
    private Semaphore capacidad;
    public GestorPiscina (int cant){
        this.capacidad= new Semaphore (cant, true);
    }
    
    public void ingresarPiscina () throws InterruptedException{
        capacidad.acquire();
        Random tiempo= new Random ();
        System.out.println(Thread.currentThread().getName()+" ingreso a la piscina");
        //pasa un tiempo
        Thread.sleep((tiempo.nextInt()-5)*500);
            
    }
    public void salir () throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" salio de la piscina");
        capacidad.release();
    }
    
}
