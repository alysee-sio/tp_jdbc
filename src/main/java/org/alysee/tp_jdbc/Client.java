/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

/**
 * Classe métier Client : contenant les attributs : id, version, titre, nom et prénom pour un client
 * @author Alysee
 */
public class Client {
    

    private int id;
    private int version;
    private String titre;
    private String nom;
    private String prenom;

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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /*
        Constructeur avec l'id
    */
    public Client(int id, int version, String titre, String nom, String prenom) {
        this.id = id;
        this.version = version;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    /*
        Constructeur sans l'id
    */
    public Client(int version, String titre, String nom, String prenom) {
        this.version = version;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    /**
     * Méthode toString : Pour qu'on puisse afficher le titre, le nom et prénom du client
     * @return 
     */
    @Override
    public String toString() {
        return this.getTitre()+ " " + this.getNom()+ " " + this.getPrenom();
    }
    
}
