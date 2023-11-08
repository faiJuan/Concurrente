/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

/**
 *
 * @author juan.ramirez
 */
public class Cliente implements Runnable{
    private CentroImpresoras centro;
    public Cliente(CentroImpresoras uncentro){
        this.centro= uncentro;
    }
    public void run(){
//        System.out.println(Thread.currentThread().getName()+" esta imprimiendo");
        centro.imprimir();
    }
    
}
