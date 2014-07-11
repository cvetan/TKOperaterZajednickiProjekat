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
public class Korisnik implements Serializable, OpstiDomenskiObjekat {

    private String jmbg;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private Adresa adresa;
    private String telefon;
    private String email;
    private double zaduzenje;

    public Korisnik() {
        adresa = new Adresa();
    }

    public Korisnik(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Korisnik(String jmbg, String ime, String prezime, String korisnickoIme, Adresa adresa, String telefon, String email, double zaduzenje) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.zaduzenje = zaduzenje;
    }

    public Korisnik(String jmbg, String ime, String prezime, String korisnickoIme, Adresa adresa, String telefon, String email) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getZaduzenje() {
        return zaduzenje;
    }

    public void setZaduzenje(double zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " [" + korisnickoIme + "]";
    }

    @Override
    public String vratiParametreZaSelect() {
        return "k.jmbg, k.ime, k.prezime, k.korisnicko_ime, k.ulica, k.broj, k.ptt, m.naziv, k.telefon, k.email, k.zaduzenje";
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnik";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "k JOIN mesto m ON k.ptt=m.ptt";
    }

    @Override
    public String vratiParametreZaInsert() {
        return "jmbg, ime, prezime, korisnicko_ime, ulica, broj, ptt, telefon, email";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + jmbg + "', '" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + adresa.getUlica() + "', '" + adresa.getBroj() + "', "
                + adresa.getMesto().getPtt() + ", '" + telefon + "', '" + email + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ime = '" + ime + "', prezime = '" + prezime + "', korisnicko_ime = '" + korisnickoIme + "', ulica = '" + adresa.getUlica() + "', broj = '" + adresa.getBroj()
                + "', ptt = " + adresa.getMesto().getPtt() + ", telefon = '" + telefon + "', email = '" + email + "', zaduzenje = " +zaduzenje;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            String jmbg = rs.getString(1);
            String ime = rs.getString(2);
            String prezime = rs.getString(3);
            String korisnickoIme = rs.getString(4);
            String ulica = rs.getString(5);
            String broj = rs.getString(6);
            int ptt = rs.getInt(7);
            String naziv = rs.getString(8);
            String telefon = rs.getString(9);
            String email = rs.getString(10);
            double zaduzenje = rs.getDouble(11);

            Mesto m = new Mesto(ptt, naziv);
            Adresa a = new Adresa(ulica, broj, m);
            Korisnik k = new Korisnik(jmbg, ime, prezime, korisnickoIme, a, telefon, email, zaduzenje);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        if (!rs.next()) {
            return new Korisnik();
        } else {
            String jmbg = rs.getString(1);
            String ime = rs.getString(2);
            String prezime = rs.getString(3);
            String korisnickoIme = rs.getString(4);
            String ulica = rs.getString(5);
            String broj = rs.getString(6);
            int ptt = rs.getInt(7);
            String naziv = rs.getString(8);
            String telefon = rs.getString(9);
            String email = rs.getString(10);
            double zaduzenje = rs.getDouble(11);

            Mesto m = new Mesto(ptt, naziv);
            Adresa a = new Adresa(ulica, broj, m);
            Korisnik k = new Korisnik(jmbg, ime, prezime, korisnickoIme, a, telefon, email, zaduzenje);
            return k;
        }
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "jmbg = '" + jmbg + "'";
    }

    @Override
    public String[] vratiUsloveZaProveru() {
        String [] uslovi = new String[2];
        uslovi[0] = "jmbg = '" + jmbg + "'";
        uslovi[1] = "korisnicko_ime = '" + korisnickoIme + "'";
        return uslovi;
    }

    @Override
    public String vratiUslovPretrage() {
        return "ime LIKE '%" + korisnickoIme + "%' OR ime LIKE '%" + korisnickoIme + "%' OR prezime LIKE '%" + korisnickoIme + "%'";
    }

    @Override
    public String vratiUslovSortiranja() {
        return "korisnicko_ime ASC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        return "";
    }

}
