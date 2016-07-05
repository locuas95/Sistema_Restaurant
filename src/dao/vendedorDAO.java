/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.vendedorDTO;
import interfaces.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.*;

/**
 *
 * @author USER
 */
public class vendedorDAO implements Operaciones<vendedorDTO>{
    private Connection cx;
    private ResultSet rs;
    private PreparedStatement ps;
    private final String SQL_VALIDAR="SELECT *FROM vendedor WHERE usuario=? AND contraseña=? ";
    private final String SQL_CREATE="INSERT INTO usuario(idusuario, usuario,contraseña) VALUES(NULL ,? ,?)";
    private final String SQL_UPDATE="UPDATE usuario SET  usuario=?, contraseña=? WHERE  idusuario=?";
    private final String SQL_DELETE="DELETE FROM usuario WHERE idusuario=?";
//    private final String SQL_READ="SELECT *FROM usuario WHERE idusuario=?";
    private final String SQL_READALL="SELECT *FROM usuario";
     public boolean validarUser(String usuario, String contraseña){
        boolean op = false;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDAR);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();            
            if(rs.next()){
                op = true;
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User: "+e);
        } finally{
           Conexion.cerrar();
        }
        return op;
    }

    @Override
    public int create(vendedorDTO e) {
        int op = 0;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_CREATE);
            ps.setString(1, e.getUsuario());
            ps.setString(2, e.getContraseña());
           op = ps.executeUpdate();                    
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Create: "+a);
        } finally{
           Conexion.cerrar();
        }
        return op;        
    }

    @Override
    public int update(vendedorDTO e) {
         int op = 0;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, e.getUsuario());
            ps.setString(2, e.getContraseña());
            ps.setInt(3, e.getIdVendedor());
           op = ps.executeUpdate();                    
        } catch (Exception b) {
            JOptionPane.showMessageDialog(null, "Update: "+b);
        } finally{
           Conexion.cerrar();
        }
        return op;   
    }

    @Override
    public int delete(Object key) {
    int op = 0;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_DELETE);
            ps.setObject(1, key);
           op = ps.executeUpdate();                    
        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, "Delet: "+c);
        } finally{
           Conexion.cerrar();
        }
        return op;     }

    @Override
    public List<vendedorDTO> readAll() {
        List<vendedorDTO> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                vendedorDTO dTO = new vendedorDTO();
               dTO.setIdVendedor(rs.getInt("idusuario"));
                dTO.setUsuario(rs.getString("usuario"));
                dTO.setContraseña(rs.getString("contraseña"));
                
                lista.add(dTO);
            }
            
        } catch (Exception g) {
            JOptionPane.showMessageDialog(null, "readAll: "+g);
        }finally{
            Conexion.cerrar();
        }
        return lista;        
    }

    @Override
    public vendedorDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
