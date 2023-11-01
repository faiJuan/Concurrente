/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

/**
 *
 * @author Fenix
 */
public class Suma {
    private int suma;
    public Suma (){
        this.suma=0;
    }
    public synchronized void setSuma (int sumatoria){
        this.suma+=sumatoria;
    }
    public int obtenerSuma(){
        return this.suma;
    }
}
