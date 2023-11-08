package TP6.punto2;

public class Estudiante implements Runnable{
    private ControlBiblioteca biblioteca;
    public Estudiante (ControlBiblioteca biblio){
        this.biblioteca=biblio;
    }

    public void run (){
        try{
            biblioteca.entrarBiblioteca();
            System.out.println(Thread.currentThread().getName()+" entro a la biblioteca");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" salio de la biblioteca");
            biblioteca.salirBiblioteca();
        }catch (InterruptedException e){
            
        }
    }
}
