/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObligatorioTren;

/**
 *
 * @author alumno
 */
public class TPObligatorio {

  
    public static void main(String[] args) {
        Tren tren= new Tren();
        Thread[] pasajeros = new Thread[6];
        Thread control= new Thread (new ControlTren(tren));
        control.start();
        for (int i = 0; i < 6; i++) {
            pasajeros[i]= new Thread(new Pasajero(tren));
            pasajeros[i].start();
        }
    }
    
}
