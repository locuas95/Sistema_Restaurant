
package dao;

import dto.PlatosDTO;
import dto.usuarioDTO;
import interfaces.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexion;

public class PlatosDAO implements Operaciones <PlatosDTO>
{
    private Connection cx;
    private ResultSet rs;
    private PreparedStatement ps;
//    private final String SQL_VALIDAR="SELECT *FROM usuario WHERE usuario=? AND contraseña=?";
    private final String SQL_CREATE="INSERT INTO platos(idplatos,idmenu,precio,nombre,descripcion)VALUES (NULL , ?, ?,?,?);";
    private final String SQL_UPDATE="UPDATE bd_Restaurante.platos SET idmenu = ?, precio = ?, nombre = ?, descripcion = ?, WHERE platos.idplatos =?";
    private final String SQL_DELETE="DELETE FROM platos WHERE idplatos = ?";
//    private final String SQL_READ="SELECT *FROM usuario WHERE idusuario=?";
    private final String SQL_READALL="SELECT *FROM platos";

    @Override
    public int create(PlatosDTO e) {
        int op = 0;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_CREATE);
            ps.setInt(1, e.getIdmenu());
            ps.setDouble(2, e.getPrecio());
            ps.setString(3, e.getNombre());
            ps.setString(4, e.getDescripcion());
           op = ps.executeUpdate();                    
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Create: "+a);
        } finally{
           Conexion.cerrar();
        }
        return op;
    }

    @Override
    public int update(PlatosDTO e) {
        int op = 0;        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setInt(1, e.getIdplatos());
            ps.setDouble(2, e.getIdmenu());
            ps.setString(3, e.getNombre());
            ps.setDouble(4, e.getPrecio());
            ps.setString(5, e.getDescripcion());
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
        return op;
    }

    @Override
    public List<PlatosDTO> readAll() {
        List<PlatosDTO> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                PlatosDTO dTO = new PlatosDTO();
                dTO.setIdplatos(rs.getInt("idplatos"));
                dTO.setIdmenu(rs.getInt("idmenu"));
                dTO.setPrecio(rs.getDouble("precio"));        
                dTO.setNombre(rs.getString("nombre"));    
                dTO.setDescripcion(rs.getString("Descripcion"));    
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
    public PlatosDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
