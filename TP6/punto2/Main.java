package TP6.punto2;

public class Main {
    public static void main(String[] args) {
        ControlBiblioteca biblioteca = new ControlBiblioteca(4);
        Thread [] estudiantes = new Thread [10];
        for (int i = 0; i < 10; i++) {
            estudiantes[i] = new Thread (new Estudiante(biblioteca));
            estudiantes[i].start();
        }
    }
}
