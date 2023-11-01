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
public class Vehiculo {
    private int kilometraje;
    private String patente;
    private String modelo;
    private String marca;
    
    public Vehiculo(String marca, String patente, String modelo, int kilom) {
        this.kilometraje=kilom;
        this.marca=marca;
        this.modelo=modelo;
        this.patente=patente;
    }
    
    public String getMarca(){
        return this.marca;
    }
}
