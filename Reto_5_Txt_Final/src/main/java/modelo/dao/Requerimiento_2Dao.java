package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_2Vo>listado_registros_rq2 = new ArrayList<Requerimiento_2Vo>();
        String sql = "SELECT p.ID_Proyecto, c.Proveedor FROM Proyecto p, Compra c NATURAL JOIN Compra c WHERE p.Ciudad == 'Neiva' ORDER BY p.ID_Proyecto;";

        try(Statement stm = conexion.createStatement(); ResultSet resultSet = stm.executeQuery(sql)){
            while(resultSet.next()){
                Requerimiento_2Vo ciudad = new Requerimiento_2Vo();
                //Proyecto
                ciudad.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                ciudad.setProveedor(resultSet.getString("Proveedor"));     
                listado_registros_rq2.add(ciudad);
            }

        }
        return listado_registros_rq2;
    }
}