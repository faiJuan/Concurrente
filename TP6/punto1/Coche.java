package TP6.punto1;

public class Coche  implements Runnable{
    GestionaTrafico puente;
    public Coche (GestionaTrafico unPuente){
        this.puente=unPuente;
    }

    public void run (){
        try {
            puente.entraCoche();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
