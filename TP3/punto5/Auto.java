/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;


/**
 *
 * @author Fenix
 */
public class Auto extends Vehiculo implements Runnable{
    private Surtidor surtidor;
    private int combustible;
    
    public Auto (String marca, String patente, String modelo, int kilom, Surtidor surti){
        super (marca, patente, modelo, kilom);
        this.surtidor=surti;
        this.combustible=50;
    }
    

//    public synchronized void utilizarSurti () {
//        if(surtidor.tieneCapacidad(15)){
//       
//        surtidor.cargarNarfa(15);
//        System.out.println(Thread.currentThread().getName()+" lleno el tanque");
//        System.out.println(surtidor.getCapacidadActual());
//        
//        }else{
//            System.out.println("El surtidor esta vacio");
//            
//        }
//    
//    }
//    
//    public void run() {
//        
//        for(int i=0;i<3;i++) {
//        try{
//            utilizarSurti();
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            System.out.println("No anda"); 
//        }          
//        }
//        
//    }

    
    public void run() {
        int carga;
        boolean terminado=false;
        do{
            combustible-=10;
            System.out.println(Thread.currentThread().getName()+" combustible: "+this.combustible);
            if(this.combustible<=20){
                carga=surtidor.cargarNarfa();
                this.combustible=carga;
                if(carga==30){
                    System.out.println(Thread.currentThread().getName()+" cargo: "+carga);
                    try {
                       Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        System.out.println("a");
                    }
                }else{
                    System.out.println("combustible insuficiente");
                    terminado=true;
                }
            }
        }while(!terminado);
    }
    
    
    
}
