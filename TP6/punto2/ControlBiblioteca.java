package TP6.punto2;

public class ControlBiblioteca {

    private int cantidad;
    private int contador;
    public ControlBiblioteca (int cant){
        this.cantidad=cant;
        this.contador=0;
    }

    public synchronized void entrarBiblioteca () throws InterruptedException{
        while (contador>=cantidad){
            this.wait();
        }
        contador++;   
    }

    public synchronized void salirBiblioteca () throws InterruptedException{
        if(contador >= cantidad){
            contador--;
            this.notifyAll();
        }else{
            contador--;
        }
    }

    

}
