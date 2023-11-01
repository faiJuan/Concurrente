/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto7;

/**
 *
 * @author juan.ramirez
 */
public class Recurso {
    private char turno;
    public Recurso(){
        this.turno='A';
    }
    public void imprimirLetra(int cant,char letra){
        for(int i=0; i<cant; i++){
            System.out.print(letra);
        }
    }
    
    public synchronized char obtenerTurno(){
        return turno;
    }
    public synchronized void cambiarTurno(char tur){
        
        switch (tur) {
            case 'A':
                this.turno='B';
                break;
            case 'B':
                this.turno='C';
                break;
            case 'C':
                this.turno='A';
                break;
        }
    }
}
