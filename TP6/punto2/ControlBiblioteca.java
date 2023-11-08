package TP6.punto2;

public class ControlBiblioteca {

    private int cantidad;
    private int contador;
    public ControlBiblioteca (int cant){
        this.cantidad=cant;
        this.contador=0;
    }

    public synchronized void usarBiblioteca () throws InterruptedException{
        contador++;
        while (contador>=cantidad){
            this.wait();
        }
        this.usar();    
        if(contador >= cantidad){
            contador--;
            this.notifyAll();
        }else{
            contador--;
        }
        
    }

    private void usar() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" entro en la biblioteca");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" salio de la biblioteca");
    }

}
