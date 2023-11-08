package TP5.punto3;

import java.util.concurrent.Semaphore;

public class Comedor2 {
    private Semaphore tandaP, tandaG, platos, mutex, parop, parog;
    private int quierenComerP, quierenComerG, comieronP, comieronG, cantTanda;
    private char turno;

    public Comedor2(int cantPlatos, int cantTan) {
        this.platos = new Semaphore(cantPlatos);
        this.tandaP = new Semaphore(0);
        this.tandaG = new Semaphore(0);
        this.quierenComerG = 0;
        this.quierenComerP = 0;
        this.comieronP = 0;
        this.comieronG = 0;
        this.cantTanda = cantTan;
        this.turno = 'n';
        this.mutex = new Semaphore(1);
        this.parop= new Semaphore (0);
        this.parog= new Semaphore (0);
    }

    public void comerPerro() throws InterruptedException {
        boolean comio = false;
        mutex.acquire();
        if (turno == 'n') {
            turno = 'p';
            tandaP.release(cantTanda);
        }
        quierenComerP++;
        mutex.release();

        while (!comio) {
            if (turno == 'p') {
                tandaP.acquire();
                platos.acquire();
                mutex.acquire();
                quierenComerP--;
                mutex.release();
                //comer
                System.out.println(Thread.currentThread().getName() + " entro a comer");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " salio de comer");
                mutex.acquire();
                comieronP++;
                comio = true;
                platos.release();
                mutex.release();
                //platos.release();
                this.desicionPerro();
            } else {
                parop.acquire();
            }
        }
    }

    public void comerGato() throws InterruptedException {
        boolean comio = false;
        mutex.acquire();
        if (turno == 'n') {
            turno = 'g';
            tandaG.release(cantTanda);
        }
        quierenComerG++;
        mutex.release();

        while (!comio) {
            if (turno == 'g') {
                tandaG.acquire();
                platos.acquire();
                mutex.acquire();
                quierenComerG--;
                mutex.release();
                //comer
                System.out.println(Thread.currentThread().getName() + " entro a comer");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " salio de comer");
                mutex.acquire();
                comieronG++;
                comio = true;
                platos.release();
                mutex.release();
                //platos.release();
                this.desicionGato();
            } else {
                parog.acquire();
            }
        }

        
    }

    private synchronized void desicionPerro () throws InterruptedException {
        if (comieronP <= cantTanda && quierenComerG > 0) {
                    turno = 'g';
                    tandaG.release(cantTanda);
                    parog.release(cantTanda);
                    comieronP = 0;
                } else if (comieronP == cantTanda && quierenComerG == 0) {
                    if (quierenComerP > 0) {
                        tandaP.release(cantTanda);
                        parop.release(cantTanda);
                        comieronP = 0;
                    } else {
                        this.turno = 'n';
                        comieronP = 0;
                        comieronG = 0;
                    }
                } else if (comieronP < cantTanda && quierenComerP == 0) {
                    tandaP.acquire(cantTanda - comieronP);
                    parop.acquire(cantTanda-comieronP);
                    this.turno = 'n';
                    comieronP = 0;
                    comieronG = 0;
                } else if (comieronP < cantTanda && quierenComerG > 0 && quierenComerP==0){
                    turno = 'g';
                    tandaG.release(cantTanda);
                    parog.release(cantTanda);
                    comieronP = 0;
                    tandaP.acquire(cantTanda - comieronP);
                    //parop.acquire(cantTanda-comieronP);
                }

    }

    private synchronized void desicionGato () throws InterruptedException {
        if (comieronG <= cantTanda && quierenComerP > 0) {
                    turno = 'p';
                    tandaP.release(cantTanda);
                    parop.release(cantTanda);
                    comieronG = 0;

                } else if (comieronG == cantTanda && quierenComerP == 0) {
                    if (quierenComerG > 0) {
                        tandaG.release(cantTanda);
                        parog.release(cantTanda);
                        comieronG = 0;
                    } else {
                        this.turno = 'n';
                        comieronP = 0;
                        comieronG = 0;
                    }
                } else if (comieronG < cantTanda && quierenComerG == 0) {
                    tandaG.acquire(cantTanda - comieronG);
                    parog.acquire(cantTanda - comieronG);
                    this.turno = 'n';
                    comieronP = 0;
                    comieronG = 0;
                
                } else if (comieronG < cantTanda && quierenComerG > 0 && quierenComerG==0){
                    turno = 'p';
                    tandaP.release(cantTanda);
                    parop.release(cantTanda);
                    comieronG = 0;
                    tandaG.acquire(cantTanda - comieronP);
                    //parog.acquire(cantTanda-comieronP);
                }
                mutex.release();
    }

}