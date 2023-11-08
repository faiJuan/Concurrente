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
public class Pasajero implements Runnable {

    Tren tren;

    public Pasajero(Tren t) {
        tren=t;
    }

    public void run() {
        while (true) {
            try {
                tren.subir();
                //le da el pie al control para que de la vuelta
                tren.bajar();
            } catch (InterruptedException e) {
                System.out.println("asd");
            }
        }
    }
}
