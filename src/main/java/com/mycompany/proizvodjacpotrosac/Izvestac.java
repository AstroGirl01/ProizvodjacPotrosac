package com.mycompany.proizvodjacpotrosac;

import java.util.Arrays;
import java.util.Random;

public class Izvestac extends Thread {
    private static int statId = 0; 
    private int id = ++statId;     
    private Skladiste skladiste;  
    private static int red = 1;
    private static final Object lock = new Object();

  
    public Izvestac(Skladiste skladiste) {
        this.skladiste = skladiste;
    }

    private void ProcitajSkladiste () throws InterruptedException {
        synchronized (lock) {
            while (red!= id) {
                System.out.println("Izvestac " + id + " proverava ciji je red izvestac" + red);
                lock.wait();
        }
        int[] stanjeSkladista = skladiste.Procitaj();
        System.out.println("Izvestac " + id + " prikazuje stanje skladista: " + Arrays.toString(stanjeSkladista));
        Random rand = new Random();
        red = rand.nextInt(2)+1 ; 
        sleep(10000);
        lock.notifyAll();
        }
    }
    public void run() {
        System.out.println("Izvestac " + id + " je zapoceo proveru skladista.");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.ProcitajSkladiste();
            }
        } catch (InterruptedException e) {
            System.out.println("Izvestac " + id + " je zavrsio.");
        }
    }
}