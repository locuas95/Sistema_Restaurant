/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.vendedorDAO;
import dto.PlatosDTO;
import dto.vendedorDTO;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USER
 */
public class Texteo {
private static vendedorDAO aO= new vendedorDAO();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion();
//        validarUsuario();
//        Create();
//        listar();
//        validarUsuario();
          Update();
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
    public static void validarUsuario(){
        
        if(aO.validarUser("cesar", "12345")){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
    public static void Create()
    {
         vendedorDTO dTO= new vendedorDTO(null, null, null, null, null, null);
        int op = aO.create(dTO);
        if(op>0){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
    public static void Update()
    {
        PlatosDTO dTO=new PlatosDTO(1, 12, "cesar", "promo x se");
        dTO.setIdplatos(2);
        int op = aO.update(dTO);
        if(op>0){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
    }
//    public static void Delete()
//    {
//        int x = 2;
//
//        int op = aO.delete(x);
//        if(op>0){
//            System.out.println("si");
//        }else
//        {
//            System.out.println("no");
//        }
//    }
//    public static void listar(){
//        List<vendedorDTO> lista = new ArrayList<>();
//        lista = aO.readAll();
//        for(int i=0; i<lista.size();i++){
//            System.out.println(lista.get(i).getUsuario());
//        }
//    }
    
}
