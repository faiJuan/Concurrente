/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;

/**
 *
 * @author Fenix
 */
public class Surtidor {
    private int capacidadMax;
    public Surtidor(){
        capacidadMax=100;
    }
    
    public boolean tieneCapacidad(int cap){
        return capacidadMax>cap;
    }
    
    public synchronized int cargarNarfa(){
        int carga =0;
        if(capacidadMax>=30){
        capacidadMax-=30;
        carga=30;
        }
        return carga;
    }
    
    public int getCapacidadActual(){
        return capacidadMax;
    }
       
}
