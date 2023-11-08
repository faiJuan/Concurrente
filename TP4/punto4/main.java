/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

/**
 *
 * @author juan.ramirez
 */
public class main {

    public static void main(String[] args) {
        CentroImpresoras centro= new CentroImpresoras();
        Thread[] clientes = new Thread[6];
        for (int i = 0; i < 6; i++) {
            clientes[i]= new Thread(new Cliente(centro));
            clientes[i].start();
        }
    }
    
}
