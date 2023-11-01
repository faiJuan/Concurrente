/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fenix
 */
public class GestorImpresoras {
    private Semaphore impresora1;
    private Semaphore impresora2;
//    private Semaphore impresora3;
//    private Semaphore impresora4;
    private Semaphore controlador;
    private boolean i1=true,i2=true;
    
    public GestorImpresoras (){
        this.impresora1=new Semaphore(1);
        this.impresora2=new Semaphore(1);
//        this.impresora3=new Semaphore(1);
//        this.impresora4=new Semaphore(1);
    }
    
    public void imprimir () throws InterruptedException{
        impresora1.acquire();
        System.out.println("se esta imprimiendo");
        
        
    }
}
