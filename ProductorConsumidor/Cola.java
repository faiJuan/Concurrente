/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidor;

/**
 *
 * @author juan.ramirez
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola (){
        this.frente=null;
        this.fin=null;
    }
    
    public boolean poner (Object nuevoElem){
        
        Nodo nuevo = new Nodo (nuevoElem, null);
        if (esVacia()){
            this.frente=nuevo;
        }else{
            this.fin.setEnlace(nuevo);
        }
        this.fin=nuevo;
        
        return true;
    }
    
    public boolean sacar (){
        boolean exito=true;
        if (this.frente==null){
            exito=false;
        }else {
            this.frente=this.frente.getEnlace();
            if(this.frente==null){
                this.fin=null;
            }
        }
        return exito;
    }
    
    public Object obtenerFrente () {
        Object elem=null;
        if (!esVacia()){
            elem=this.frente.getElem();
        }
        return elem;
    }
    
    public boolean esVacia (){
        return this.frente==null;
    }
    
    public void vaciar (){
        this.fin=null;
        this.frente=null;
    }
    
    public Cola clone (){
        Cola clon = new Cola ();
        Nodo aux1 = this.frente;
        if (!esVacia()){
            clon.frente = new Nodo (aux1.getElem(), null);
            Nodo aux2= clon.frente;
            
            while (aux1.getEnlace()!=null){
                aux1=aux1.getEnlace();
                aux2.setEnlace(new Nodo (aux1.getElem(), null));
                aux2=aux2.getEnlace();
            }
            clon.fin=this.fin;
        }
        return clon;
    }
    
    public String toString (){
        String s;
        if (esVacia()){
            s="Cola vacia";
        }else {
            Nodo aux=this.frente;
            s="[";
            while (aux.getEnlace()!=null){
                s=s+aux.getElem()+"-";
                aux=aux.getEnlace();
            }
            s=s+"]";
        }
        return s;
    }
    
}
