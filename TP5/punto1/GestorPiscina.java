
package TP5.punto1;


import java.util.concurrent.Semaphore;


public class GestorPiscina {
    private Semaphore capacidad, mutex;
    private int ingresaron;
    public GestorPiscina (int cant){
        this.capacidad= new Semaphore (cant, true);
        this.ingresaron=0;

        this.mutex= new Semaphore (1);
    }
    
    public void ingresarPiscina () throws InterruptedException{
        mutex.acquire();
        ingresaron++;
        mutex.release();
        capacidad.acquire();
        System.out.println(Thread.currentThread().getName()+" ingreso a la piscina");
        //pasa un tiempo
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" salio de la piscina");
        mutex.acquire();
        ingresaron--;
        mutex.release();
        capacidad.release();
        if (ingresaron ==0){
            ingresaron=0;
            System.out.println(Thread.currentThread().getName()+ " soy el ultimo");   
        }
    }
    
}
