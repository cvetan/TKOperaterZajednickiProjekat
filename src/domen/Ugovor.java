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
public class Ugovor implements Serializable, OpstiDomenskiObjekat {

    private int brojUgovora;
    private Date godina;
    private Date datumPotpisivanja;
    private int ugovornaObaveza;
    private Korisnik korisnik;
    private Tarifa tarifa;

    public Ugovor() {
        korisnik = new Korisnik();
        tarifa = new Tarifa();
    }

    public Ugovor(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Ugovor(int brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public Ugovor(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Ugovor(Date godina) {
        this.godina = godina;
    }

    public Ugovor(int brojUgovora, Date godina, Date datumPotpisivanja, int trajanje, Korisnik korisnik, Tarifa tarifa) {
        this.brojUgovora = brojUgovora;
        this.godina = godina;
        this.datumPotpisivanja = datumPotpisivanja;
        this.ugovornaObaveza = trajanje;
        this.korisnik = korisnik;
        this.tarifa = tarifa;
    }

    public int getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(int brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    }

    public Date getDatumPotpisivanja() {
        return datumPotpisivanja;
    }

    public void setDatumPotpisivanja(Date datumPotpisivanja) {
        this.datumPotpisivanja = datumPotpisivanja;
    }

    public int getUgovornaObaveza() {
        return ugovornaObaveza;
    }

    public void setUgovornaObaveza(int ugovornaObaveza) {
        this.ugovornaObaveza = ugovornaObaveza;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return brojUgovora + "/" + godina;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "*";
    }

    @Override
    public String vratiNazivTabele() {
        return "ugovor";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "";
    }

    @Override
    public String vratiParametreZaInsert() {
        return "broj_ugovora, godina_ugovora, datum_potpisivanja, ugovorna_obaveza, jmbg, sifra_tarife, sifra_usluge";

    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat godinaF = new SimpleDateFormat("yyyy");
        DateFormat datumF = new SimpleDateFormat("yyyy-MM-dd");
        String godinaS = godinaF.format(godina);
        String datumS = datumF.format(datumPotpisivanja);
        return brojUgovora + ", '" + godinaS + "', '" + datumS + "', " + ugovornaObaveza + ", '" + korisnik.getJmbg() + "', " + tarifa.getSifraTarife() + ", " + tarifa.getUsluga().getSifraUsluge();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {

        }
        return null;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        if (!rs.next()) {
            Ugovor u = new Ugovor();
            return u;
        } else {
            int brojUgovora = rs.getInt(1);
            Ugovor u = new Ugovor(brojUgovora);
            return u;
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
        return "broj_ugovora DESC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        DateFormat format = new SimpleDateFormat("yyyy");
        String pretraga = format.format(godina);
        return "godina_ugovora = '" + pretraga + "'";
    }

}
