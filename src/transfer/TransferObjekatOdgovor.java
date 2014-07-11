/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author cvetan
 */
public class TransferObjekatOdgovor implements Serializable {

    private Object odgovor;
    private String rezultat;
    private boolean uspesan;

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public boolean isUspesan() {
        return uspesan;
    }

    public void setUspesan(boolean uspesan) {
        this.uspesan = uspesan;
    }

}
