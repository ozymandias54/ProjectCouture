/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;


public class TestConnection {

    
    public static void main(String[] args) {
        Connection connect=Connectdb.getInstance();
        if(connect!=null)
            System.out.println("connection reussi");
        else
            System.out.println("pas de connection");
    }
    
}