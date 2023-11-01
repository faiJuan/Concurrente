/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fenix
 */
public class Taxi {

    private Semaphore scliente;
    private Semaphore staxista;
    private Semaphore ssalida;

    public Taxi() {
        scliente = new Semaphore(1);
        staxista = new Semaphore(0);
        ssalida = new Semaphore(0);
    }

    public void subirTaxi() throws InterruptedException {
        scliente.acquire();
        System.out.println(Thread.currentThread().getName() + " se subio al taxi");
        staxista.release();
    }
    
    public void comenzarViaje () throws InterruptedException{
        staxista.acquire();
        System.out.println("Taxista despierto");
        System.out.println("comenzando viaje");
        Thread.sleep(4000);
        System.out.println("Viaje terminado");
    }
    public void bajarTaxi (){
        
    }

}
