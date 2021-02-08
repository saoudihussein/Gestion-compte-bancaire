/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gest_Ent;

import BaseDeDonnées.BD;
import Entite.Admin;
import Entite.Employe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author HS-PC
 */
public class Gest_Employe {

    BD connexion = new BD();

    public Gest_Employe() {

    }

    public boolean AjouterEmploye(Employe employe) {
        boolean result = false;
        if (connexion.Connexion()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateNaissStr = sdf.format(employe.getDateNaiss());

            String req = "INSERT INTO employe (`Cin`, `Nom`, `Prenom`, `DateNaiss`, `NumTelephone`, `Adresse`, sexe, `Pseudo`, `MotDePasse`)  VALUES ('" + employe.getCin() + "',"
                    + "'" + employe.getNom() + "'"
                    + ",'" + employe.getPrenom() + "'"
                    + ",'" + dateNaissStr + "',"
                    + "'" + employe.getNumTelephone() + "',"
                    + "'" + employe.getAdresse() + "',"
                    + "'" + employe.getSexe() + "',"
                    + "'" + employe.getPseudo() + "',"
                    + "'" + employe.getMotDePasse() + "')";

            try {

                int res = connexion.stmt.executeUpdate(req);
                if (res > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    public boolean SupprimerEmploye(Employe employe) {
        boolean result = false;
        if (connexion.Connexion()) {

            String req = "delete  from employe where cin = " + employe.getCin();

            try {
                int res = connexion.stmt.executeUpdate(req);
                if (res > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean ModiferEmploye(Employe employe) {
        boolean result = false;
        if (connexion.Connexion()) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateNaissStr = sdf.format(employe.getDateNaiss());

            String req = "update employe set "
                    + "nom= '" + employe.getNom() + "'"
                    + ",prenom='" + employe.getPrenom() + "'"
                    + ",DateNaiss='" + dateNaissStr + "'"
                    + ",adresse='" + employe.getAdresse() + "'"
                    + ",sexe ='" + employe.getSexe() + "',NumTelephone='" + employe.getNumTelephone() + "'"
                    + " where cin = " + employe.getCin();

            try {
                int res = connexion.stmt.executeUpdate(req);
                if (res > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Employe> AfficheEmployes() {

        ArrayList<Employe> employes = new ArrayList<Employe>();

        if (connexion.Connexion()) {
            Employe employe;
            String req = "select * from employe";

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    employe = new Employe(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                    employes.add(employe);
                }

            } catch (SQLException e) {
                System.out.println("Erreur lors de la suppression!");
                e.printStackTrace();
            }

        }

        return employes;

    }

    public Employe Afficheemploye(String cin) {

        Employe employe = null;

        if (connexion.Connexion()) {
            String req = "select * from employe where cin like '" + cin + "' or nom like '" + cin + "' or prenom like '" + cin + "' or code like '" + cin + "'";

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    employe = new Employe(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));

                }

            } catch (SQLException e) {
                System.out.println("Probleme d'affichage");
                e.printStackTrace();
            }

        }

        return employe;

    }

    public Employe login(String pseudo, String motDePasse) {
        BD connexion = new BD();
        Employe employe = null;

        if (connexion.Connexion()) {

            try {
                String req = "select * from employe where Pseudo = '" + pseudo + "' and MotDePasse = '" + motDePasse + "'";
                ResultSet rs = connexion.stmt.executeQuery(req);

                if (rs.next()) {
                    employe = new Employe(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
        return employe;
    }
}
