package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClaseDao {
    Connection con; //Objeto de conexion
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar consultas
    String sql=null; //Variable para guardar sentencias
}
