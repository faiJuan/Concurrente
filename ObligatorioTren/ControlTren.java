
package ObligatorioTren;


public class ControlTren implements Runnable {

    Tren tren;

    public ControlTren(Tren t) {
        this.tren = t;
    }

    public void run() {
        while (true) {
            try {
                tren.andar();
            } catch (InterruptedException e) {
                System.out.println("asd");
            }
        }
    }
}
