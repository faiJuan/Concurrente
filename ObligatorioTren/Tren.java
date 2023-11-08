/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObligatorioTren;

import java.util.concurrent.Semaphore;

/**
 *
 * @author alumno
 */
public class Tren {
    private int pasajeros, capacidad;
    private Semaphore cliente;
    private Semaphore control;
    private Semaphore salida;
    
    
    public Tren (){
        //agregar capacidad por parametro
        this.capacidad=4;
        this.pasajeros=0;
        cliente= new Semaphore(1);
        control= new Semaphore(0);
        salida= new Semaphore(0);
    }
    
    public void subir() throws InterruptedException{
        cliente.acquire();
        System.out.println(Thread.currentThread().getName()+" se subio");
        pasajeros++;
        if(pasajeros<capacidad){
            cliente.release();
        }else{
            control.release();
        }
    }
    
    public void andar () throws InterruptedException{
        //Para el hilo de control
        control.acquire();
        System.out.println("empezar vuelta");
        Thread.sleep(4000);
        System.out.println("Terminar vuelta");
        salida.release();
        //release de salida es para que empiezen a bajar los pasajeros
    }
    
    public void bajar () throws InterruptedException{
        salida.acquire();
        System.out.println(Thread.currentThread().getName()+" se bajo");
        pasajeros--;
        if(pasajeros>0){
            salida.release();
        }else{
            cliente.release();
        }
    }
}
