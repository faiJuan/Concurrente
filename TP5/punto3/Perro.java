package TP5.punto3;

public class Perro implements Runnable{
    private Comedor comedor;
    public Perro (Comedor com){
        this.comedor= com;
    }
    public void run (){
        try {
            comedor.comerPerro();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
