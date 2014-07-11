/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author cvetan
 */
public interface OpstiDomenskiObjekat {

    public String vratiParametreZaSelect();

    public String vratiNazivTabele();

    public String vratiUslovSpajanja();

    public String vratiParametreZaInsert();

    public String vratiVrednostiZaInsert();

    public String vratiVrednostiZaUpdate();

    public List<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception;
    
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) throws Exception;

    public String vratiPrimarniKljuc();

    public String[] vratiUsloveZaProveru();

    public String vratiUslovPretrage();

    public String vratiUslovSortiranja();

    public String vratiUslovZaPoslednjiElement();

}
