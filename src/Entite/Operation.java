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
public class Operation {

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    private int numOperation;
    private Date dateOperation;
    private String typeOperation;
    private float solde;
    private int numCompte;
    private int code;

    public Operation(int numOperation, Date dateOperation, String typeOperation, float solde, int numCompte, int code) {
        this.numOperation = numOperation;
        this.dateOperation = dateOperation;
        this.typeOperation = typeOperation;
        this.solde = solde;
        this.numCompte = numCompte;
        this.code = code;
    }

    public Operation(String typeOperation, float solde, int numCompte, int code) {
        this.dateOperation = new Date();
        this.typeOperation = typeOperation;
        this.solde = solde;
        this.numCompte = numCompte;
        this.code = code;
    }

    
    
    

    public int getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(int numOperation) {
        this.numOperation = numOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}
