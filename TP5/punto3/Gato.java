package TP5.punto3;

public class Gato implements Runnable{
    private Comedor comedor;
    public Gato (Comedor com){
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
