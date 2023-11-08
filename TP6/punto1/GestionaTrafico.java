package TP6.punto1;

public class GestionaTrafico {
    private boolean turno;

    public GestionaTrafico (){
        this.turno=true;
    }

    public synchronized void entraCoche () throws InterruptedException{
        while (!turno){
            this.wait();
        }
        this.turno=false;
        System.out.println(Thread.currentThread().getName()+" entro al puente");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" salio del puente");
        this.turno=true;
        this.notifyAll();
    }
    
    
}
