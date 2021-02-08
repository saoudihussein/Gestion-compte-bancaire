/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gest_Ent;

import BaseDeDonnées.BD;
import Entite.*;
import Interface.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HS-PC
 */
public class Gest_Compte {

    BD connexion = new BD();

    public Gest_Compte() {

    }

    public boolean AjouterCompte(Compte compte) {
        boolean result = false;
        if (connexion.Connexion()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateCrtCmptStr = sdf.format(compte.getDateCreation());
            String req = "INSERT INTO compte VALUES (null,"
                    + "'" + dateCrtCmptStr + "',"
                    + +compte.getSolde() + "," + "'"
                    + compte.getClient().getCin() + "')";

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

    public boolean SupprimerClient(int numCompte) {
        boolean result = false;
        if (connexion.Connexion()) {

            String req = "delete  from compte where NumCompte = " + numCompte;

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

    public boolean Retraits(Compte compte, float solde) {
        boolean result = false;
        if (connexion.Connexion()) {
            Operation operation = new Operation("Retraits", solde, compte.getNumCopte(), Login.code);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateOp = sdf.format(operation.getDateOperation());

            String reqUp = "update compte set solde=solde - " + solde + " where numCompte = " + compte.getNumCopte();
            Gest_Operation gest_Operation = new Gest_Operation();
            gest_Operation.AjouterOpe(operation, solde, compte);

            try {
                int resUp = connexion.stmt.executeUpdate(reqUp);
                if (resUp > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return result;
    }

    public boolean Versements(Compte compte, float solde) {
        boolean result = false;
        if (connexion.Connexion()) {
            Operation operation = new Operation("Versements", solde, compte.getNumCopte(), Login.code);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateOp = sdf.format(operation.getDateOperation());

            String reqUp = "update compte set solde=solde + " + solde + " where numCompte = " + compte.getNumCopte();
            Gest_Operation gest_Operation = new Gest_Operation();
            gest_Operation.AjouterOpe(operation, solde, compte);

            try {
                int resUp = connexion.stmt.executeUpdate(reqUp);
                if (resUp > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return result;
    }

    public boolean transfert(Compte compte1, float solde, Compte compte2) {

        if (Retraits(compte1, solde) && Versements(compte2, solde)) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<Compte> AfficheComptes() {

        ArrayList<Compte> comptes = new ArrayList<Compte>();

        if (connexion.Connexion()) {
            String req = "select * from compte C,Client Cl where C.cin = Cl.cin";

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    Client client = new Client(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    Compte compte = new Compte(rs.getInt(1), rs.getDate(2), rs.getFloat(3), client);
                    comptes.add(compte);
                }

            } catch (SQLException e) {
                System.out.println("Erreur lors de la suppression!");
                e.printStackTrace();
            }

        }

        return comptes;

    }

    public Compte AfficheCompte(String rech) {

        Compte compte = null;

        if (connexion.Connexion()) {
            String req = "select * from compte C,Client Cl where C.cin = Cl.cin and C.cin like " + rech + " or NumCompte = " + Integer.parseInt(rech);

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    Client client = new Client(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    compte = new Compte(rs.getInt(1), rs.getDate(2), rs.getFloat(3), client);

                }

            } catch (SQLException e) {

                System.out.println(e.toString());
            }

        }

        return compte;

    }

}
