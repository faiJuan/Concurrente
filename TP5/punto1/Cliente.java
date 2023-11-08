package TP5.punto1;

public class Cliente implements Runnable{
    private GestorPiscina gestor;

    public Cliente(GestorPiscina unGestor) {
        this.gestor = unGestor;
    }

    public void run (){
        try {
            gestor.ingresarPiscina();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
