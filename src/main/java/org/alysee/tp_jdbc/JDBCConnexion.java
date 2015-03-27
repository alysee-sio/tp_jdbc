/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Classe JDBCConnexion : Lien entre l'application et la base en local
 * @author Alysee
 */
public class JDBCConnexion {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // Driver pour avoir la connexion
    private static final String DB_URL = "jdbc:mysql://localhost:8889/tp_jdbc"; // Adresse de ma base de données
    static final String USER = "root"; // nom utilisateur de la base
    static final String PASS = "root"; // mot de passe de la base

    private static Connection connection; 
    private static JDBCConnexion jdbcConnexion;

    /**
     * Principe du singleton utilisé 
     * Construteur
     */
    private JDBCConnexion() {
        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Si la conenxion n'existe pas alors on la créé, sinon on retourne celle déjà créé
     * @return une connextion
     */
    public static Connection getConnection (){
        if (JDBCConnexion.connection == null){
            JDBCConnexion.jdbcConnexion = new JDBCConnexion();
        }
        return JDBCConnexion.connection;
    }
}
