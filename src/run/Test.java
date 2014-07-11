/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import domen.Adresa;
import domen.Korisnik;
import domen.Mesto;
import domen.Racun;
import java.util.Date;

/**
 *
 * @author cvetan
 */
public class Test {

    public static void main(String[] args) {
        Racun r = new Racun(new Date());
        String upit = "SELECT " + r.vratiParametreZaSelect() + " FROM " +  r.vratiNazivTabele() + " " + r.vratiUslovSpajanja() + " WHERE " + r.vratiUslovZaPoslednjiElement() + " ORDER BY "
                    + r.vratiUslovSortiranja() + " LIMIT 1";
        System.out.println(upit);
    }
}
