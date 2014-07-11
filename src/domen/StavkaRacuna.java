/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class StavkaRacuna implements Serializable, OpstiDomenskiObjekat {
    
    private int redniBroj;
    private Zaduzenje zaduzenje;
    private Racun racun;
    
    public StavkaRacuna() {
    }
    
    public StavkaRacuna(int redniBroj, Zaduzenje zaduzenje) {
        this.redniBroj = redniBroj;
        this.zaduzenje = zaduzenje;
    }
    
    public StavkaRacuna(int redniBroj, Zaduzenje zaduzenje, Racun racun) {
        this.redniBroj = redniBroj;
        this.zaduzenje = zaduzenje;
        this.racun = racun;
    }
    
    public int getRedniBroj() {
        return redniBroj;
    }
    
    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }
    
    public Zaduzenje getZaduzenje() {
        return zaduzenje;
    }
    
    public void setZaduzenje(Zaduzenje zaduzenje) {
        this.zaduzenje = zaduzenje;
    }
    
    public Racun getRacun() {
        return racun;
    }
    
    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
    @Override
    public String toString() {
        return redniBroj + "." + zaduzenje.getGodina() + "/" + zaduzenje.getMesec() + " - " + zaduzenje.getIznos();
    }
    
    @Override
    public String vratiParametreZaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String vratiNazivTabele() {
        return "stavka_racuna";
    }
    
    @Override
    public String vratiUslovSpajanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String vratiParametreZaInsert() {
        return "redni_broj, broj_racuna, godina_racuna, zaduzenje_id";
    }
    
    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat godinaFormat = new SimpleDateFormat("yyyy");
        return redniBroj + ", " + racun.getBrojRacuna() + ", '" + godinaFormat.format(racun.getGodina()) + "', " + zaduzenje.getZaduzenjeID();
    }
    
    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
