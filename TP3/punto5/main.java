/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;

/**
 *
 * @author juan.ramirez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args){
        Thread[] autos= new Thread[5];
        //Auto a1= new Auto("audi", "asd", "TT", 123);
        Surtidor surti= new Surtidor ();
        for (int i = 0; i < 5; i++) {
            autos[i]=new Thread ((Runnable) new Auto("audi", "asd", "TT", 123, surti));
            autos[i].start();
        }
    }
    
}
