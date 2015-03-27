/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire contenant toutes les requetes utilisées pour la lecture, écriture, suppression et mise à jour.
 * @author Alysee
 */
public class Requetes {


    /**
     * Liste de tous les médecins
     * @return la liste des médecins
     */
    public List<Medecin> listeDesMedecins (){
        Statement stmt = null;
        String sql;
        sql = "SELECT * FROM MEDECINS";
        List<Medecin> listeMedecins;
        listeMedecins = new ArrayList<Medecin>();

        try {
            stmt = JDBCConnexion.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id  = rs.getInt("ID");
                int version = rs.getInt("VERSION");
                String titre = rs.getString("TITRE");
                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");

                Medecin medecin = new Medecin(id, version, titre, nom, prenom);
                listeMedecins.add(medecin);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeMedecins;
    }

    /**
     * Liste des créneaux horaires d'un médecin
     * @param medecin
     * @return la liste des créneaux d'un médecin
     */
    public List<Creneau> listeDesCreneauxDunMedecin (Medecin medecin){
        Statement stmt = null;
        String sql;
        sql = "SELECT DISTINCT cr.* FROM CRENEAUX AS cr WHERE cr.id_medecin = " + medecin.getId() ;
        List<Creneau> listeCreneauDunMedecin;
        listeCreneauDunMedecin = new ArrayList<Creneau>();

        try {
            stmt = JDBCConnexion.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id          = rs.getInt("ID");
                int version     = rs.getInt("VERSION");
                int hdebut      = rs.getInt("HDEBUT");
                int hfin        = rs.getInt("HFIN");
                int mdebut      = rs.getInt("MDEBUT");
                int mfin        = rs.getInt("MFIN");
                int id_medecin  = rs.getInt("ID_MEDECIN");

                Creneau cr = new Creneau(id, version, hdebut, mdebut, hfin, mfin, id_medecin);
                listeCreneauDunMedecin.add(cr);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCreneauDunMedecin;
    }

    /**
     * Liste des clients d'un médecin
     * @param medecin
     * @return la liste de tous les clients concernant un médecin
     */
    public List<Client> listeDesClientsDunMedecin (Medecin medecin){
        Statement stmt = null;
        String sql;
        sql = "SELECT DISTINCT cl.* FROM CLIENTS AS cl INNER JOIN RV as rv ON cl.id = rv.id_client INNER JOIN CRENEAUX AS cr ON rv.id_creneau = cr.id WHERE cr.id_medecin = "+ medecin.getId() ;
        List<Client> listeClientDunMedecin;
        listeClientDunMedecin = new ArrayList<Client>();

        try {
            stmt = JDBCConnexion.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id          = rs.getInt("ID");
                int version     = rs.getInt("VERSION");
                String titre      = rs.getString("TITRE");
                String nom        = rs.getString("NOM");
                String prenom      = rs.getString("PRENOM");


                Client cl = new Client(id, version, titre, nom, prenom);
                listeClientDunMedecin.add(cl);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeClientDunMedecin;

    }

    /**
     * Liste des rendez-vous d'un creneau pour un médecin
     * @param creneau
     * @return la liste des rendez-vous pour un créneau
     */
    public List<RV> listeDesRVDunCreneau (Creneau creneau){
        Statement stmt = null;
        String sql;
        sql = "SELECT * FROM RV AS rv WHERE rv.id_creneau = "+ creneau.getId() ;
        List<RV> listeRVDunCreneau;
        listeRVDunCreneau = new ArrayList<RV>();

        try {
            stmt = JDBCConnexion.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                int id  = rs.getInt("ID");
                Date jour = new Date(rs.getDate("JOUR").getTime());
                int id_Client = rs.getInt("ID_CLIENT");
                int id_Creneau = rs.getInt("ID_CRENEAU");

                RV rv = new RV(id, jour, id_Client, id_Creneau);
                listeRVDunCreneau.add(rv);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeRVDunCreneau;
    }

    /**
     * Liste des clients
     * @return la liste de tous les clients
     */
    public List<Client> listeDesClients (){
        Statement stmt = null;
        String sql;
        sql = "SELECT * FROM CLIENTS";
        List<Client> listeClients;
        listeClients = new ArrayList<Client>();

        try {
            stmt = JDBCConnexion.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id          = rs.getInt("ID");
                int version     = rs.getInt("VERSION");
                String titre      = rs.getString("TITRE");
                String nom        = rs.getString("NOM");
                String prenom      = rs.getString("PRENOM");


                Client cl = new Client(id, version, titre, nom, prenom);
                listeClients.add(cl);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeClients;

    }
    
    /**
     * Mise à jour d'un médecin
     * @param medecin 
     */
    public void majMedecin(Medecin medecin){
        Statement stmt = null;
        String sql;
       
        sql = " UPDATE MEDECINS SET nom = '" + medecin.getLastName() + "', prenom = '" + medecin.getFirstName() + "' where id = '" + medecin.getId() + "'";
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserer un médecin
     * @param medecin
     * @return true, si le médecin est inseré
     */
    public boolean insererMedecin(Medecin medecin){
        Statement stmt = null;
        String sql;
        sql = "INSERT INTO MEDECINS (version, titre, nom, prenom) VALUES ('" + medecin.getVersion() + "', '" + medecin.getTitre() + "', '" + medecin.getLastName() + "', '" + medecin.getFirstName() + "');" ;
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Inserer un client
     * @param client
     * @return true, si le client est inséré
     */
    public boolean insererClient(Client client){
        Statement stmt = null;
        String sql;
        sql = "INSERT INTO CLIENTS (version, titre, nom, prenom) VALUES ('" + client.getVersion() + "', '" + client.getTitre() + "', '" + client.getNom() + "', '" + client.getPrenom() + "');" ;
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Inserer un créneau
     * @param creneau
     * @return true, si le créneau est inséré
     */
    public boolean insererCreneau(Creneau creneau){
        Statement stmt = null;
        String sql;
        sql = "INSERT INTO CRENEAUX (version, hdebut, mdebut, hfin, mfin, id_medecin) VALUES (" + creneau.getVersion() + ", " + creneau.getHeuredeb() + ", " + creneau.getMinutedeb()+ ", " + creneau.getHeurefin()+ ", " + creneau.getMinutefin()+ ", " + creneau.getId_medecin()+ ");" ;
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Suppression d'un créneau
     * @param creneau 
     */
    public void supprimerCreneau(Creneau creneau){

        Statement stmt  = null;
            String sql;
            sql = "DELETE FROM CRENEAUX WHERE id = " + creneau.getId();
            try {
                stmt = JDBCConnexion.getConnection().createStatement();
                stmt.executeUpdate(sql);
                stmt.close();

             } catch (SQLException e) {
            e.printStackTrace();
            }

    }

    /**
     * Suppression d'un client
     * @param client 
     */
    public void supprimerClient (Client client){
        Statement stmt  = null;
        String sql;
        sql = "DELETE FROM CLIENTS WHERE id = " + client.getId();
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

         } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    /**
     * Suppression d'un médecin
     * @param medecin 
     */ 
    public void supprimerMedecin(Medecin medecin){
        Statement stmt  = null;
        String sql;
        sql = "DELETE FROM MEDECINS WHERE id = " + medecin.getId();
        try {
            stmt = JDBCConnexion.getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

         } catch (SQLException e) {
        e.printStackTrace();
        }
    }

}