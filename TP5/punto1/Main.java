package TP5.punto1;

public class Main {
    public static void main(String[] args) {
        GestorPiscina gestor= new GestorPiscina(4);
        Thread[] clientes= new Thread [15];
        for (int i = 0; i < 15; i++) {
            clientes[i]= new Thread (new Cliente(gestor));
            clientes[i].start();
        }
    }
}
