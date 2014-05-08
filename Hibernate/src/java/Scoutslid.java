/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jx3
 */
import java.io.Serializable;

public class Scoutslid implements Serializable {

    private int id;
    private String Naam;
    private String Scoutsnaam;
    private String Emailadres;

    public Scoutslid() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public String getScoutsnaam() {
        return Scoutsnaam;
    }

    public void setScoutsnaam(String Scoutsnaam) {
        this.Scoutsnaam = Scoutsnaam;
    }

    public String getEmailadres() {
        return Emailadres;
    }

    public void setEmailadres(String Emailadres) {
        this.Emailadres = Emailadres;
    }

    
}
