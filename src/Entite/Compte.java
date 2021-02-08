/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author HS-PC
 */
public class Compte {

    private int numCopte;
    private Date dateCreation;
    private float solde;
    private Client client;

    public Compte(float solde, Client client) {
        this.solde = solde;
        this.dateCreation = new Date();
        this.client = client;

    }

    public Compte(int numCopte, Date dateCreation, float solde, Client client) {
        this.numCopte = numCopte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public int getNumCopte() {
        return numCopte;
    }

    public void setNumCopte(int numCopte) {
        this.numCopte = numCopte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
