/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

/**
 * Classe métier Creneau : contenant les attributs : id, version, heure de debut et de fin, minutes de debue et de fin et l'id d'un médecin
 * @author Alysee
 */
public class Creneau {
    
    private int id;
    private int version;
    private int heuredeb;
    private int heurefin;
    private int minutedeb;
    private int minutefin;
    private int id_medecin;

    /*
        Ascesseurs
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getHeuredeb() {
        return heuredeb;
    }

    public void setHeuredeb(int heuredeb) {
        this.heuredeb = heuredeb;
    }

    public int getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(int heurefin) {
        this.heurefin = heurefin;
    }

    public int getMinutedeb() {
        return minutedeb;
    }

    public void setMinutedeb(int minutedeb) {
        this.minutedeb = minutedeb;
    }

    public int getMinutefin() {
        return minutefin;
    }

    public void setMinutefin(int minutefin) {
        this.minutefin = minutefin;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    /*
        Constructeur avec l'id
    */
    public Creneau(int id, int version, int heuredeb, int minutedeb, int heurefin, int minutefin, int id_medecin) {
        this.id = id;
        this.version = version;
        this.heuredeb = heuredeb;
        this.heurefin = heurefin;
        this.minutedeb = minutedeb;
        this.minutefin = minutefin;
        this.id_medecin = id_medecin;
    }

    /*
        Constructeur sans l'id
    */
    public Creneau(int version, int heuredeb, int minutedeb, int heurefin, int minutefin, int id_medecin) {
        this.version = version;
        this.heuredeb = heuredeb;
        this.heurefin = heurefin;
        this.minutedeb = minutedeb;
        this.minutefin = minutefin;
        this.id_medecin = id_medecin;
    }
    
    /**
     * Méthode toString : Pour qu'on puisse afficher l'heure de début et de fin et les minutes de début et de fin
     * @return l'heure global du créneau
     */
    @Override
    public String toString() {
        return this.getHeuredeb()+ ":" + this.getMinutedeb()+ "-" + this.getHeurefin()+ ":" + this.getMinutefin();
    }
    
}
