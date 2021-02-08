/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gest_Ent;

import BaseDeDonnées.BD;
import Entite.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HS-PC
 */
public class Gest_Client {

    BD connexion = new BD();

    public Gest_Client() {

    }

    public boolean AjouterClient(Client client) {
        boolean result = false;
        if (connexion.Connexion()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateNaissStr = sdf.format(client.getDateNaiss());
            String req = "INSERT INTO client VALUES (" + client.getCin() + ","
                    + "'" + client.getNom() + "'"
                    + ",'" + client.getPrenom() + "'"
                    + ",'" + dateNaissStr + "',"
                    + "'" + client.getNumTelephone() + "',"
                    + "'" + client.getAdresse() + "',"
                    + "'" + client.getSexe() + "')";

            try {
                int res = connexion.stmt.executeUpdate(req);
                if (res > 0){
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean SupprimerClient(Client client) {
        boolean result = false;
        if (connexion.Connexion()) {

            String req = "delete  from client where cin = " + client.getCin();

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

    public boolean ModiferClient(Client client) {
        boolean result = false;
        if (connexion.Connexion()) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateNaissStr = sdf.format(client.getDateNaiss());

            String req = "update client set "
                    + "nom= '" + client.getNom() + "'"
                    + ",prenom='" + client.getPrenom() + "'"
                    + ",DateNaiss='" + dateNaissStr + "'"
                    + ",adresse='" + client.getAdresse() + "'"
                    + ",sexe ='" + client.getSexe() + "',NumTelephone='" + client.getNumTelephone() + "'"
                    + " where cin = " + client.getCin();

            try {
                int res = connexion.stmt.executeUpdate(req);

                if (res > 0){
                    result = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Client> AfficheClients() {

        ArrayList<Client> clients = new ArrayList<Client>();

        if (connexion.Connexion()) {
            Client client;
            String req = "select * from client";

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    client = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    clients.add(client);
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

        return clients;

    }

    public Client AfficheClient(String cin) {

        Client client = null;

        if (connexion.Connexion()) {
            String req = "select * from client where cin like '" + cin + "' or nom like '" + cin + "' or prenom like '" + cin + "'";

            try {
                ResultSet rs = connexion.stmt.executeQuery(req);
                while (rs.next()) {

                    client = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));

                }

            } catch (SQLException e) {
                System.out.println("Probleme d'affichage");
                e.printStackTrace();
            }

        }

        return client;

    }

}
