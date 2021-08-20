package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {

        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_3Vo> listado_registros_rq3 = new ArrayList<Requerimiento_3Vo>();
        String sql = "SELECT p.ID_Proyecto, mc.Nombre_Material FROM Proyecto p, MaterialConstruccion mc NATURAL JOIN Compra c WHERE p.ID_Proyecto >=40 and p.ID_Proyecto <=55 ORDER BY p.ID_Proyecto;";

        try (Statement stm = conexion.createStatement(); ResultSet resultSet = stm.executeQuery(sql)) {
            while (resultSet.next()) {
                //Proyecto
                Requerimiento_3Vo material = new Requerimiento_3Vo();
                material.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                material.setNombreMaterial(resultSet.getString("Nombre_Material"));
                listado_registros_rq3.add(material);
                
            }

        }
        return listado_registros_rq3;

    }
}
