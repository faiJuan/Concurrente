package TP6.punto4;

public class Almacen {
    private int limite, cantProducto;
    public Almacen (int lim){
        this.limite=lim;
        this.cantProducto=0;
    }

    public synchronized void ponerProducto () throws InterruptedException{
        while(cantProducto>=limite){
            System.out.println("Almacen lleno");
            this.wait(); 
        }

        cantProducto++;
        
        System.out.println(Thread.currentThread().getName()+" agrego producto, total producto: "+cantProducto);
    }

    public synchronized void sacarProducto () throws InterruptedException {
        while (cantProducto<=0){
            System.out.println("almacen sin productos");
            this.wait();
        }
        cantProducto--;
        System.out.println(Thread.currentThread().getName()+" saco producto, total producto: "+cantProducto);
        
    }

}
