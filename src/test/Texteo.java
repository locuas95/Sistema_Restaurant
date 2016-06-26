/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import util.Conexion;
import java.sql.*;
/**
 *
 * @author USER
 */
public class Texteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion();
    }
    public static void Conexion()
    {
        Connection c= Conexion.getConexion();
        if(c!=null)
        {
            System.out.println("existe conexion");
        }
        else
        {
            System.out.println("no hubo Conexion");
        }
    }
    
}
