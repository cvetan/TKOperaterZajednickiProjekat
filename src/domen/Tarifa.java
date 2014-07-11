/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class Tarifa implements Serializable, OpstiDomenskiObjekat {

    private int sifraTarife;
    private String nazivTarife;
    private double pretplata;
    private Usluga usluga;

    public Tarifa() {
        usluga = new Usluga();
    }

    public Tarifa(Usluga usluga) {
        this.usluga = usluga;
    }

    public Tarifa(int sifraTarife, String nazivTarife, double pretplata, Usluga usluga) {
        this.sifraTarife = sifraTarife;
        this.nazivTarife = nazivTarife;
        this.pretplata = pretplata;
        this.usluga = usluga;
    }

    public int getSifraTarife() {
        return sifraTarife;
    }

    public void setSifraTarife(int sifraTarife) {
        this.sifraTarife = sifraTarife;
    }

    public String getNazivTarife() {
        return nazivTarife;
    }

    public void setNazivTarife(String nazivTarife) {
        this.nazivTarife = nazivTarife;
    }

    public double getPretplata() {
        return pretplata;
    }

    public void setPretplata(double pretplata) {
        this.pretplata = pretplata;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public String toString() {
        return nazivTarife + " - " + pretplata;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "t.sifra_tarife, t.sifra_usluge, t.naziv_tarife, t.pretplata, u.naziv_usluge";
    }

    @Override
    public String vratiNazivTabele() {
        return "tarifa";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "t JOIN usluga u ON t.sifra_usluge = u.sifra_usluge";
    }

    @Override
    public String vratiParametreZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()) {
            int sifraTarife = rs.getInt(1);
            int sifraUsluge = rs.getInt(2);
            String nazivTarife = rs.getString(3);
            double pretplata = rs.getDouble(4);
            String nazivUsluge = rs.getString(5);
            Usluga u = new Usluga(sifraUsluge, nazivUsluge);
            Tarifa t = new Tarifa(sifraTarife, nazivTarife, pretplata, u);
            lista.add(t);
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] vratiUsloveZaProveru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovPretrage() {
        return "t.sifra_usluge = " + usluga.getSifraUsluge();
    }

    @Override
    public String vratiUslovSortiranja() {
        return "pretplata ASC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
