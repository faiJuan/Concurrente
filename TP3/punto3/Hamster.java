/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

import java.util.Random;

/**
 *
 * @author juan.ramirez
 */
public class Hamster implements Runnable{
    Plato plato= new Plato();
    Rueda rueda= new Rueda();
    Hamaca hamaca= new Hamaca();
    public Hamster(Plato p, Rueda r, Hamaca h) {
        this.hamaca=h;
        this.plato=p;
        this.rueda=r;
    }
    
    public void run(){
        Random ran= new Random();
        String usaronTodo="abc";
        int numero= ran.nextInt(3)+1;
        switch(numero){
            case 1:
                plato.usarPlato();
                
                
        }
    }
}
