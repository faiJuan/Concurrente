/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto2;


/**
 *
 * @author juan.ramirez
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Energia ener = new Energia ();
        Thread Sanador= new Thread(ener, "Sanador");
        Thread Oscura= new Thread(ener, "Oscura");
        Sanador.start();
        Oscura.start();
    }
    
    

}
