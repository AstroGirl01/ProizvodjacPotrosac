/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proizvodjacpotrosac;

/**
 *
 * @author Kiki
 */
public class ProizvodjacPotrosac {

    public static void main(String[] args) {
        Skladiste skladiste = new Skladiste(10);
        Potrosac potrosac = new Potrosac(skladiste, 4000, 6000);
        Proizvodjac proizvodjac = new Proizvodjac(skladiste, 1000, 2000);
        Izvestac izvestac1 = new Izvestac(skladiste);
        Izvestac izvestac2 = new Izvestac(skladiste);
        Izvestac izvestac3 = new Izvestac(skladiste);
        potrosac.start();
        proizvodjac.start();
        izvestac1.start();
        izvestac2.start();
        izvestac3.start();
        
      
    }
}
