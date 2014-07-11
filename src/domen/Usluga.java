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
public class Usluga implements Serializable, OpstiDomenskiObjekat {

    private int sifraUsluge;
    private String nazivUsluge;

    public Usluga() {
    }

    public Usluga(int sifraUsluge, String nazivUsluge) {
        this.sifraUsluge = sifraUsluge;
        this.nazivUsluge = nazivUsluge;
    }

    public int getSifraUsluge() {
        return sifraUsluge;
    }

    public void setSifraUsluge(int sifraUsluge) {
        this.sifraUsluge = sifraUsluge;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    @Override
    public String toString() {
        return nazivUsluge;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "sifra_usluge, naziv_usluge";
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "";
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
            int sifraUsluge = rs.getInt(1);
            String nazivUsluge = rs.getString(2);
            Usluga u = new Usluga(sifraUsluge, nazivUsluge);
            lista.add(u);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovSortiranja() {
        return "naziv_usluge ASC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
