/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan.ramirez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantH, j = 0;
        int numeros[] = new int[50];
        Suma recurso = new Suma();
        Random ran = new Random();
        System.out.println("Indique la cantidad de hilos");
        cantH = entrada.nextInt();
        Thread[] arr = new Thread[cantH];
        for (int i = 0; i < 50; i++) {
            numeros[i] = ran.nextInt(10) + 1;
        }

        int cant = calcularPartes(cantH);

        for (int i = 0; i < cantH; i++) {
            if (i == cantH - 1) {
                arr[i] = new Thread(new HiloSumador(i * cant, 49, numeros, recurso));
                arr[i].start();
            } else {
                arr[i] = new Thread(new HiloSumador(i * cant, cant * (i + 1) - 1, numeros, recurso));
                arr[i].start();
            }
            try {
                arr[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println(recurso.obtenerSuma());
        for (int i = 0; i < 50; i++) {
            j += numeros[i];
        }
        System.out.println(j);
    }

    public static int calcularPartes(int hilos) {
        int aux = 0;
        boolean terminado = false;
        while (!terminado) {
            if (50 % hilos == 0) {
                aux = 50 / hilos;
                terminado = true;
            } else {
                hilos -= 1;
            }
        }
        return aux;
    }

}
