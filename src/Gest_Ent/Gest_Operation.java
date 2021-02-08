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
public class Gest_Operation {

    BD connexion = new BD();

    public Gest_Operation() {

    }

    public boolean AjouterOpe(Operation operation, float solde, Compte compte) {
        boolean result = true;
        if (connexion.Connexion()) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateOp = sdf.format(operation.getDateOperation());
            String req = "";
            if (Login.isAdmin) {
                req = "INSERT INTO operation VALUES (null,'" + dateOp + "','" + operation.getTypeOperation() + "', " + solde + "," + compte.getNumCopte() + ",null," + operation.getCode() + ")";
            } else {
                req = "INSERT INTO operation VALUES (null,'" + dateOp + "','" + operation.getTypeOperation() + "', " + solde + "," + compte.getNumCopte() + "," + operation.getCode() + ",null)";
            }

            try {
                int res = connexion.stmt.executeUpdate(req);
                if (res > 0) {
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                result = false;

            }
        }
        return result;

    }

    public ArrayList<Operation> AfficheOperations(int numCompte) {

        ArrayList<Operation> operations = new ArrayList<Operation>();

        
        
        if (connexion.Connexion()) {
            String req = "SELECT O.`numOperation`,O.`dateOperation`,O.`typeOperation`,O.`Solde`,C.`NumCompte`,O.codeEmp ,O.`codeAdm`\n"
                    + "FROM compte C,`operation` O WHERE O.`Numcompte` = C.`NumCompte`  and O.`Numcompte`=" + numCompte;

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                Operation operation ;
                while (rs.next()) {
                    if (rs.getInt(6) != 0) {
                        operation = new Operation(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6));
                    } else {
                        operation = new Operation(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(7));
                    }

                    
                    operations.add(operation);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return operations;

    }

    public Compte AfficheCompte(String rech) {

        Compte compte = null;

        if (connexion.Connexion()) {
            String req = "select * from compte where cin like " + rech + "or NumCompte = " + rech;

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    Client client = new Client(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    compte = new Compte(rs.getInt(1), rs.getDate(2), rs.getFloat(3), client);

                }

            } catch (SQLException e) {
                System.out.println("Probleme d'affichage");
                e.printStackTrace();
            }

        }

        return compte;

    }

}
