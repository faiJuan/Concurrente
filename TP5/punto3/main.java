package TP5.punto3;

public class main {
    public static void main(String[] args) {
        Comedor2 comedor= new Comedor2(2, 3);
        Thread [] perros= new Thread[7];
        Thread [] gatos = new Thread [7];
        

        for (int i = 0; i < 7 ; i++) {
            gatos[i]= new Thread(new Gato(comedor), "gato "+i);
            gatos[i].start();
        }
        for (int i = 0; i < 7; i++) {
            perros [i]= new Thread(new Perro(comedor), "perro "+i);
            perros[i].start();
        }
        
    }
}
