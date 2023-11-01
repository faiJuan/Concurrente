package TP5.punto3;

public class main {
    public static void main(String[] args) {
        Comedor comedor= new Comedor(3, 6);
        Thread [] perros= new Thread[14];
        Thread [] gatos = new Thread [10];
        
        for (int i = 0; i < 14; i++) {
            perros [i]= new Thread(new Perro(comedor), "perro "+i);
            perros[i].start();
        }
        for (int i = 0; i < 10 ; i++) {
            gatos[i]= new Thread(new Gato(comedor), "gato "+i);
            gatos[i].start();
        }
    }
}
