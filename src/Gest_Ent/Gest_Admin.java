/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gest_Ent;

import BaseDeDonnées.BD;
import Entite.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HS-PC
 */
public class Gest_Admin {

    BD connexion = new BD();

    public Gest_Admin() {

    }

    public Admin login(String pseudo, String motDePasse) {
        BD connexion = new BD();
        Admin admin = null;

        if (connexion.Connexion()) {

            try {
                String req = "select * from admin where Pseudo = '" + pseudo + "' and MotDePasse = '" + motDePasse + "'";
                ResultSet rs = connexion.stmt.executeQuery(req);

                if (rs.next()) {
                    admin = new Admin(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), "");
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
        return admin;
    }

}
