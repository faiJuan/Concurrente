/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

/**
 *
 * @author juan.ramirez
 */
public class HiloSumador implements Runnable{
    private int inicio;
    private int fin;
    private int[] aSumar;
    private Suma recurso;
   
    public HiloSumador(int i, int j, int[] arr,Suma recur){
        inicio=i;
        fin=j;
        aSumar=arr;
        this.recurso=recur;
    }

    
    public void run() {
        int suma=0;
        for(int i=this.inicio; i<=this.fin; i++){
        
           suma+=aSumar[i];
        }
        recurso.setSuma(suma);  
    }  
}
