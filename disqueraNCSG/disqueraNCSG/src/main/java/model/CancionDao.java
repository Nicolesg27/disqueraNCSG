package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CancionDao {
    
    //Atributos
    Connection con; //Objeto para la conexión
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar resultados de consultas
    String sql=null; // Variable para almacenar sentencias SQL
    int r;

	public int registrar(CancionVo cancion) throws SQLException{
        sql="INSERT INTO cancion(idCancion,nombreCancion,fechaGrabacion,duracionCancion,estadoCancion) VALUES (?,?,?,?,?)";
        try{
            con=Conexion.conectar(); //Abre la conexión con la BD
            ps=con.prepareStatement(sql); //Prepara la sentencia
            ps.setInt(1, cancion.getidCancion());
            ps.setString(2, cancion.getnombreCancion());
            ps.setInt(3, cancion.getfechaGrabacion());
            ps.setInt(4, cancion.getduracionCancion());
            ps.setBoolean(5, cancion.isestadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecuta la sentencia
            ps.close(); //Cierra la sentencia
            System.out.println("Se registro la canción correctamente");
        }catch (Exception e){
            System.out.println("Error en el registro de la cancion " + e.getMessage().toString());
        }
        finally{
            con.close(); //Cierra conexión con la BD
        }

        return r; // Retorna el numero de filas afectadas   
    }

	public List<CancionVo> listar() throws SQLException{
        List<CancionVo> cancionNCSG=new ArrayList<>();
        sql="SELECT * FROM cancion ";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo r=new CancionVo();
                r.setidCancion(rs.getInt("idCancion"));
                r.setnombreCancion(rs.getString("nombreCancion"));
                r.setfechaGrabacion(rs.getInt("fechaGrabacion"));
                r.setduracionCancion(rs.getInt("duracionCancion"));
                r.setestadoCancion(rs.getBoolean("estadoCancion"));
                cancionNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch (Exception e){
            System.out.println("La consulta no se pudo ejecutar correctamente " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return cancionNCSG; 
    }

	public void eliminar(int idCancion) throws SQLException{
        sql="DELETE FROM cancion WHERE idCancion="+idCancion;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente el dato seleccionado");
        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato seleccionado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }

	public void estado(Boolean estadoCancion, int idCancion) throws SQLException{
        sql="UPDATE cancion SET estadoCancion="+estadoCancion+" WHERE idCancion="+idCancion;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a "+estadoCancion+" correctamente");
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }

	public List<CancionVo> listarCancion(int  idCancion) throws SQLException{
        List<CancionVo> cancionNCSG=new ArrayList<>();
        sql="SELECT * FROM cancion WHERE idCancion="+idCancion;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo r=new CancionVo();
                r.setidCancion(rs.getInt("idCancion"));
                r.setnombreCancion(rs.getString("nombreCancion"));
                r.setfechaGrabacion(rs.getInt("fechaGrabacion"));
                r.setduracionCancion(rs.getInt("duracionCancion"));
                r.setestadoCancion(rs.getBoolean("estadoCancion"));
                cancionNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return cancionNCSG;
    }

	public int actualizar(CancionVo cancion) throws SQLException{
        sql="UPDATE cancion SET nombreCancion=?,fechaGrabacion=?, duracionCancion=?, estadoCancion=? WHERE idCancion=?";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, cancion.getnombreCancion());
            ps.setInt(2, cancion.getfechaGrabacion());
            ps.setInt(3, cancion.getduracionCancion());
            ps.setBoolean(4, cancion.isestadoCancion());
            ps.setInt(5, cancion.getidCancion());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito la canción correctamente");
        }catch (Exception e){
            System.out.println("Error al editar la canción " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
        
        return r;
    }    
}
