/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juan.ramirez
 */
public class Comedor {

    private Semaphore tandaP, tandaG, platos, mutex;
    private int quierenComerP, quierenComerG, comieronP, comieronG, cantTanda;
    private char turno;

    public Comedor(int cantPlatos, int cantTan) {
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
                mutex.release();
                platos.release();
                mutex.acquire();
                if (comieronP == cantTanda && quierenComerG > 0) {
                    turno = 'g';
                    tandaG.release(cantTanda);
                    comieronP = 0;
                } else if (comieronP >= cantTanda && quierenComerG <= 0) {
                    if (quierenComerP > 0) {
                        tandaP.release(cantTanda);
                        comieronP = 0;
                    } else {
                        this.turno = 'n';
                        comieronP = 0;
                        comieronG = 0;
                    }
                } else if (comieronP < cantTanda && quierenComerP == 0) {
                    tandaP.acquire(cantTanda - comieronP);
                    this.turno = 'n';
                    comieronP = 0;
                    comieronG = 0;
                }
                mutex.release();
            } else {
                tandaP.acquire();
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
                mutex.release();
                platos.release();
                mutex.acquire();
                if (comieronG == cantTanda && quierenComerP > 0) {

                    turno = 'p';
                    tandaP.release(cantTanda);
                    comieronG = 0;

                } else if (comieronG >= cantTanda && quierenComerP <= 0) {
                    if (quierenComerG > 0) {
                        tandaG.release(cantTanda);
                        comieronG = 0;
                    } else {
                        this.turno = 'n';
                        comieronP = 0;
                        comieronG = 0;
                    }
                } else if (comieronG < cantTanda && quierenComerG == 0) {
                    tandaG.acquire(cantTanda - comieronG);
                    this.turno = 'n';
                    comieronP = 0;
                    comieronG = 0;
                }
                mutex.release();
            } else {
                tandaG.acquire();
            }
        }
    }

}
