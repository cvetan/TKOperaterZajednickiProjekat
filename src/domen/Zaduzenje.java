/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class Zaduzenje implements Serializable, OpstiDomenskiObjekat {

    private int zaduzenjeID;
    private Date mesec;
    private Date godina;
    private double iznos;
    private boolean placeno;
    private Ugovor ugovor;

    public Zaduzenje() {
        ugovor = new Ugovor();
    }

    public Zaduzenje(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public Zaduzenje(Date mesec, Date godina, double iznos, Ugovor ugovor) {
        this.mesec = mesec;
        this.godina = godina;
        this.iznos = iznos;
        this.ugovor = ugovor;
    }

    public Zaduzenje(int zaduzenjeID, Date mesec, Date godina, double iznos, Ugovor ugovor) {
        this.zaduzenjeID = zaduzenjeID;
        this.mesec = mesec;
        this.godina = godina;
        this.iznos = iznos;
        this.ugovor = ugovor;
    }

    public Zaduzenje(int zaduzenjeID, Date mesec, Date godina, double iznos, boolean placeno, Ugovor ugovor) {
        this.zaduzenjeID = zaduzenjeID;
        this.mesec = mesec;
        this.godina = godina;
        this.iznos = iznos;
        this.placeno = placeno;
        this.ugovor = ugovor;
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Date getMesec() {
        return mesec;
    }

    public void setMesec(Date mesec) {
        this.mesec = mesec;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    @Override
    public String toString() {
        return mesec + "/" + godina + " - " + iznos;
    }

    @Override
    public String vratiParametreZaSelect() {
        return "zaduzenje_id, mesec_zaduzenja, godina_zaduzenja, iznos, broj_ugovora, godina_ugovora, sifra_tarife, sifra_usluge, naziv_usluge";
    }

    @Override
    public String vratiNazivTabele() {
        return "zaduzenje";
    }

    @Override
    public String vratiUslovSpajanja() {
        return "JOIN ugovor using(broj_ugovora, godina_ugovora) join tarifa using (sifra_tarife, sifra_usluge) join usluga using (sifra_usluge)";
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
        return "placeno = " + placeno;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int zaduzenjeId = rs.getInt(1);
            Date mesec = rs.getDate(2);
            Date godina = rs.getDate(3);
            double iznos = rs.getDouble(4);
            int brojUgovora = rs.getInt(5);
            Date godinaUgovora = rs.getDate(6);
            int sifraTarife = rs.getInt(7);
            int sifraUsluge = rs.getInt(8);
            String nazivUsluge = rs.getString(9);

            Usluga usluga = new Usluga(sifraUsluge, nazivUsluge);
            Tarifa tarifa = new Tarifa(usluga);
            Ugovor ugovor = new Ugovor(tarifa);
            Zaduzenje zaduzenje = new Zaduzenje(zaduzenjeId, mesec, godina, iznos, ugovor);
            lista.add(zaduzenje);
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaduzenje_id = " + zaduzenjeID;
    }

    @Override
    public String[] vratiUsloveZaProveru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovPretrage() {
        return "jmbg = '" + ugovor.getKorisnik().getJmbg() + "' AND placeno = false";
    }

    @Override
    public String vratiUslovSortiranja() {
        return "mesec_zaduzenja DESC";
    }

    @Override
    public String vratiUslovZaPoslednjiElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
