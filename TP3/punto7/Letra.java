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
public class Letra implements Runnable {
    private char letra;
    private int cantidad;
    Recurso impresion;
    public Letra(char a, int cant,Recurso imp){
        this.letra=a;
        this.cantidad=cant;
        this.impresion=imp;
    }
    public void run(){
        while (true){
            if(this.letra==impresion.obtenerTurno()){
                impresion.imprimirLetra(cantidad, letra);
                impresion.cambiarTurno(this.letra);
            }else{
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    System.out.println("No anda");
                }
            }
        }
    }
}
