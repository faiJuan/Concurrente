/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto2;

/**
 *
 * @author Fenix
 */
public class Energia implements Runnable {
    private int energia;
    public Energia(){
        this.energia=10;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
        this.modificar();
        }
    }
    
    public synchronized void modificar(){
        if(Thread.currentThread().getName().equals("Sanador")){
            this.energia= energia+3;
            System.out.println("Se aumento la energia en 3");
            System.out.println("Total de energia: "+this.energia);
        }else{
            this.energia= energia-3;
            System.out.println("Se disminuyo la energia en 3");
            System.out.println("Total de energia: "+this.energia);
        }
    }
}
