/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fenix
 */
public class Comedor {
    private int tandaP, tandaG;
    private Semaphore comederos, controlador;
    
    public Comedor (){
        this.comederos= new Semaphore (3);
        this.controlador= new Semaphore (1);
        tandaP=0;
        tandaG=0;
    }
    
    public void comerPerro(){
        
    }
    
}
