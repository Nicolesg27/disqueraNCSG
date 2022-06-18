package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlbumDao {
    
    //Atributos
    Connection con; //Objeto para la conexión
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar resultados de consultas
    String sql=null; // Variable para almacenar sentencias SQL
    int r;

    public int registrar(AlbumVo alb) throws SQLException{
        sql="INSERT INTO album(idAlbum, nombreAlbum, anioPublicacion, estadoAlbum) VALUES (?,?,?,?)";
        try{
            con=Conexion.conectar(); //Abre la conexión
            ps=con.prepareStatement(sql); //Prepara la sentencia
            ps.setInt(1, alb.getidAlbum());
            ps.setString(2, alb.getnombreAlbum());
            ps.setInt(3, alb.getanioPublicacion());
            ps.setBoolean(4, alb.isestadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecuta la sentencia
            ps.close(); //Cierra la sentencia
            System.out.println("Registrado con éxito");
        }catch (Exception e){
            System.out.println("Error con el registro " + e.getMessage().toString());
        }
        finally{
            con.close(); //Cierra conexión 
        }

        return r;   
    }

    public List<AlbumVo> listar() throws SQLException{
        List<AlbumVo> albumNCSG=new ArrayList<>();
        sql="SELECT * FROM album";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                AlbumVo r=new AlbumVo();
                r.setidAlbum(rs.getInt("idAlbum"));
                r.setnombreAlbum(rs.getString("nombreAlbum"));
                r.setanioPublicacion(rs.getInt("anioPublicacion"));
                r.setestadoAlbum(rs.getBoolean("estadoAlbum"));
                albumNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta generada de manera Exitosa");
        }catch (Exception e){
            System.out.println("La consulta no se pudo ejecutar correctamente " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return albumNCSG; 
    }

    public void eliminar(int idAlbum) throws SQLException{
        sql="DELETE FROM album WHERE idAlbum="+idAlbum;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente el dato");
        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }

    public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException{
        sql="UPDATE album SET estadoAlbum="+estadoAlbum+" WHERE idAlbum="+idAlbum;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a "+estadoAlbum+" correctamente");
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }

    public List<AlbumVo> listar(int idAlbum) throws SQLException{
        List<AlbumVo> albumNCSG=new ArrayList<>();
        sql="SELECT * FROM album WHERE idAlbum="+idAlbum;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                AlbumVo r=new AlbumVo();
                r.setidAlbum(rs.getInt("idAlbum"));
                r.setnombreAlbum(rs.getString("nombreAlbum"));
                r.setanioPublicacion(rs.getInt("anioPublicacion"));
                r.setestadoAlbum(rs.getBoolean("estadoAlbum"));
                albumNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return albumNCSG;
    }

    public int actualizar(AlbumVo alb) throws SQLException{
        sql="UPDATE album SET nombreAlbum=?,estadoAlbum=?,anioPublicacion=? WHERE idAlbum=?";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, alb.getnombreAlbum());
            ps.setBoolean(2, alb.isestadoAlbum());
            ps.setInt(3, alb.getanioPublicacion());
            ps.setInt(4, alb.getidAlbum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("El dato se edito de forma correcta");
        }catch (Exception e){
            System.out.println("Error al editar " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
        
        return r;
    }

}
