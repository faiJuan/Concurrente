/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan.ramirez
 */
public class CentroImpresoras {
    private Impresora[] impresoras= new Impresora[3];
    public CentroImpresoras(){
        for (int i = 0; i < 3; i++) {
            impresoras[i]= new Impresora();
        }
    }
    
    public void imprimir(){
        boolean usaImp=false;
        int i=0;
        while(!usaImp){
            
            try {
                usaImp=impresoras[i].imprimir();
            } catch (InterruptedException ex) {
                Logger.getLogger(CentroImpresoras.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
            if(i==3){
                i=0;
            }
        }
    }
}
