package TP5.punto3;

public class Gato implements Runnable{
    private Comedor2 comedor;
    public Gato (Comedor2 com){
        this.comedor= com;
    }
    public void run (){
        try{
            comedor.comerGato();
        }catch (InterruptedException e){
            System.out.println("asd");
        }
    }
}
