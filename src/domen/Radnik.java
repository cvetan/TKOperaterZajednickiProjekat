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
public class Radnik implements Serializable, OpstiDomenskiObjekat {

    private String korisnickoIme;
    private String sifra;

    public Radnik() {
    }

    public Radnik(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "*";
    }

    @Override
    public String vratiNazivTabele() {
        return "radnik";
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
        while (rs.next()) {
            String korisnickoIme = rs.getString(1);
            String sifra = rs.getString(2);
            Radnik r = new Radnik(korisnickoIme, sifra);
            lista.add(r);
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
        return "korisnicko_ime = '" + korisnickoIme + "' AND sifra = '" + sifra + "'";  
    }

    @Override
    public String vratiUslovSortiranja() {
        return "korisnicko_ime ASC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
