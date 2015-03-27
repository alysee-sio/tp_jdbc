/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

/**
 * Classe métier Medecin : contenant les attributs : id, version, titre, nom et prénom pour un médecin
 * @author Alysee
 */
public class Medecin {
    
    private int id;
    private int version;
    private String titre;
    private String lastName;
    private String firstName;

    /*
        Ascesseurs
    */
    public int getId() {
        return id;
    }
    private void setId(int id) {
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
    private void setTitre(String titre) {
        this.titre = titre;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
        Constructeur avec l'id
    */
    public Medecin(int id, int version, String titre, String lastName, String firstName) {
        this.id = id;
        this.version = version;
        this.titre = titre;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /*
        Constructeur sans l'id
    */
    public Medecin(int version, String titre, String lastName, String firstName) {
        this.version = version;
        this.titre = titre;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Méthode toString : Pour qu'on puisse afficher le titre, le nom et prénom du médecin
     * @return le titre, le nom et le prénom d'un médecin
     */
    @Override
    public String toString() {
        return this.getTitre() + " " + this.getLastName() + " " + this.getFirstName();
    }
}
