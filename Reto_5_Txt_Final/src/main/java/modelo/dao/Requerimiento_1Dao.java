package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {

    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_1Vo> listado_registros_rq1 = new ArrayList<Requerimiento_1Vo>();
        String sql = "SELECT Ciudad_Residencia, AVG(Salario) Promedio " +  
        " FROM Lider GROUP BY Ciudad_Residencia " +
        " HAVING Promedio < 400000 "+
        " ORDER BY Promedio DESC";
    
        try(Statement stm = conexion.createStatement(); ResultSet resultSet = stm.executeQuery(sql)) {
            while(resultSet.next()){

                Requerimiento_1Vo promedioSuperior = new Requerimiento_1Vo();             
                promedioSuperior.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));
                promedioSuperior.setPromedio(resultSet.getDouble("Promedio"));
                listado_registros_rq1.add(promedioSuperior);
            }
        }
        return listado_registros_rq1; 
    }
}