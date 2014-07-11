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
public class Mesto implements Serializable, OpstiDomenskiObjekat {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return ptt + " " + naziv;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "*";
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
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
            int ptt = rs.getInt(1);
            String naziv = rs.getString(2);
            Mesto mesto = new Mesto(ptt, naziv);
            lista.add(mesto);
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
        return "naziv ASC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
