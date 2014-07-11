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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class Racun implements Serializable, OpstiDomenskiObjekat {

    private int brojRacuna;
    private Date godina;
    private Date datumPlacanja;
    private double ukupanIznos;
    private Korisnik korisnik;
    private List<StavkaRacuna> listaStavki;

    public Racun() {
        korisnik = new Korisnik();
        listaStavki = new ArrayList<>();
    }

    public Racun(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Racun(Date godina) {
        this.godina = godina;
    }

    public Racun(int brojRacuna, Date godina, Date datumPlacanja, Korisnik korisnik) {
        this.brojRacuna = brojRacuna;
        this.godina = godina;
        this.datumPlacanja = datumPlacanja;
        this.korisnik = korisnik;
    }

    public Racun(int brojRacuna, Date godina, Date datumPlacanja, double ukupanIznos, Korisnik korisnik, List<StavkaRacuna> listaStavki) {
        this.brojRacuna = brojRacuna;
        this.godina = godina;
        this.datumPlacanja = datumPlacanja;
        this.ukupanIznos = ukupanIznos;
        this.korisnik = korisnik;
        this.listaStavki = listaStavki;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    }

    public Date getDatumPlacanja() {
        return datumPlacanja;
    }

    public void setDatumPlacanja(Date datumPlacanja) {
        this.datumPlacanja = datumPlacanja;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String toString() {
        return brojRacuna + "/" + godina;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "broj_racuna, godina_racuna, jmbg";
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "";
    }

    @Override
    public String vratiParametreZaInsert() {
        return "broj_racuna, godina_racuna, datum_placanja, ukupan_iznos, jmbg";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat godinaFormat = new SimpleDateFormat("yyyy");
        DateFormat datumFormat = new SimpleDateFormat("yyyy-MM-dd");
        return brojRacuna + ", '" + godinaFormat.format(godina) + "', '" + datumFormat.format(datumPlacanja) + "', " + ukupanIznos + ", '" + korisnik.getJmbg() + "'";
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
        if (!rs.next()) {
            return new Racun();
        } else {
            int brojRacuna = rs.getInt(1);
            Racun r = new Racun(brojRacuna);
            return r;
        }
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
        return "broj_racuna DESC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        DateFormat godinaFormat = new SimpleDateFormat("yyyy");
        return "godina_racuna = '" + godinaFormat.format(godina) + "'";
    }

}
