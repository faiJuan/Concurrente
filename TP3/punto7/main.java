/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto7;

/**
 *
 * @author Fenix
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args){
        Recurso impresion= new Recurso ();
        Letra a= new Letra ('A', 3, impresion);
        Letra b= new Letra ('B', 2, impresion);
        Letra c= new Letra ('C', 3, impresion);
        Thread h1= new Thread (a);
        Thread h2= new Thread (b);
        Thread h3= new Thread (c);
        h1.start();
        h2.start();
        h3.start();
    }
    
}
