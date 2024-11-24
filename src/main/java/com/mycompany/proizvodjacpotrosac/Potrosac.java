package com.mycompany.proizvodjacpotrosac;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Potrosac extends Thread {
    private static int statId = 0;
    private int id=++statId;

    private Skladiste skladiste;
    private int brojac = 0;
    private int minTime ; 
    private int maxTime ;

    private int trajanje = minTime + (int)Math.random()*(maxTime - minTime);

    public Potrosac(Skladiste skladiste, int minTime, int maxTime)
    {
        this.skladiste = skladiste;
        this.minTime = minTime;
        this.maxTime = maxTime;
 }

    public void run(){
        System.out.println("Potrosac "+id+" je krenuo sa koriscenjem");
        try{
        while(!interrupted()){

            int trajanje = minTime + (int)Math.random()*(maxTime - minTime);
            sleep(trajanje);

            int proizvod = skladiste.Uzmi();

        System.out.println("Uzet je proizvod" + proizvod);
        }
            } catch (InterruptedException ex) {
                System.out.println("Potrosac "+id+ " je zavrsio sa radom");

                }




 }





}
