/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto1;



/**
 *
 * @author juan.ramirez
 */
public class Main {
    public static void main(String [] args){
        VerificarCuenta vc=new VerificarCuenta();
        Thread luis = new Thread (vc, "Luis");
        Thread manuel = new Thread (vc, "Manuel");
        luis.start();
        manuel.start();
    }
}
