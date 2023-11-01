/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juan.ramirez
 */
public class Buffer {
    private Semaphore hayLugar, hayProducto, controlCola, controlSacar;
    private Cola sinta;
    
    public Buffer (){
        this.hayLugar= new Semaphore (5);
        this.hayProducto= new Semaphore (0);
        this.controlCola= new Semaphore (1);
        this.controlSacar= new Semaphore (1);
        this.sinta= new Cola ();
    }
    
    public void poner (Object elem) throws InterruptedException{
        hayLugar.acquire();
        controlCola.acquire();
        sinta.poner(elem);
        controlCola.release();
        hayProducto.release();
    }
    
    public void sacar () throws InterruptedException{
        hayProducto.acquire();
        controlSacar.acquire();
        sinta.sacar();
        controlSacar.release();
        hayLugar.release();
    }
    
}
