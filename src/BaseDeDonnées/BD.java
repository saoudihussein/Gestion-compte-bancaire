/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author HS-PC
 */
public class BD {

    public Connection C;
    public Statement stmt;

    public BD() {

    }

    public boolean Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            C = DriverManager.getConnection("jdbc:mysql://localhost:3306/compte_bancaire", "root", "");
            stmt = C.createStatement();
            return true;
        } catch (Exception e) {
            System.out.println("Erreur de connexion base de données");
            e.printStackTrace();
            return false;
        }
    }

}
