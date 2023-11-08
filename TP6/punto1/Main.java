package TP6.punto1;



public class Main {
   
    public static void main(String [] args){
        GestionaTrafico puente=new GestionaTrafico();
        Thread autos[] = new Thread [6];
        for (int i = 0; i < 6; i++) {
            autos[i]=new Thread (new Coche (puente));
            autos[i].start();
        }
    }
    
}
