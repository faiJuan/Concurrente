package TP6.punto2;

public class Estudiante implements Runnable{
    private ControlBiblioteca biblioteca;
    public Estudiante (ControlBiblioteca biblio){
        this.biblioteca=biblio;
    }

    public void run (){
        try{
            biblioteca.usarBiblioteca();
        }catch (InterruptedException e){
            
        }
    }
}
