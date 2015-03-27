/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe métier RV(Rendez-vous) : contenant les attributs : id, jour, id_Client, id_Creneau pour un rv
 * @author Alysee
 */
public class RV {
    
    private int id;
    private Date jour;
    private int id_Client;
    private int id_Creneaux;

    /*
        Ascesseurs des attributs
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public int getIdClient() {
        return id_Client;
    }

    public void setIdClient(int id_Client) {
        this.id_Client = id_Client;
    }

    public int getIdCreneaux() {
        return id_Creneaux;
    }

    public void setIdCreneaux(int id_Creneaux) {
        this.id_Creneaux = id_Creneaux;
    }

    /*
        Constructeur avec l'id
    */
    public RV(int id, Date jour, int id_Client, int id_Creneaux) {
        this.id = id;
        this.jour = jour;
        this.id_Client = id_Client;
        this.id_Creneaux = id_Creneaux;
    }

    /*
        Constructeur sans l'id
    */
    public RV(Date jour, int id_Client, int id_Creneaux) {
        this.jour = jour;
        this.id_Client = id_Client;
        this.id_Creneaux = id_Creneaux;
    }

    /**
     * Méthode toString : Pour qu'on puisse afficher le jour du rendez-vous
     * @return le jour du rendez-vous
     */
   @Override
    public String toString() {
        return new SimpleDateFormat("yyyy-MM-dd").format(this.getJour());
    }
   
}
