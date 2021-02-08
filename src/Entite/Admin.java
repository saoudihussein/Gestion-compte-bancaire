/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author HS-PC
 */
public class Admin extends Personne{
    
    private int code;

    public Admin( String Cin,int code, String Nom, String Prenom, Date DateNaiss, String NumTelephone, String Adresse, String sexe) {
        super(Cin, Nom, Prenom, DateNaiss, NumTelephone, Adresse, sexe);
        this.code = code;
    }

    

    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    
    
}
