package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDao {

     //Atributos que realizan las operaciones en la BD

     Connection con;//Objeto de conexión
     PreparedStatement ps;//Prepara las sentencias a ejecutar
     ResultSet rs;//Almacena las consultas generadas
     String sql=null;
     int r; //Cantidad de filas que devuelve una sentencias
 
     //Sentencias a ejecutar en la clase Artista

    //!Registrar
    public int registrar(ArtistaVo artista) throws SQLException{
        sql="INSERT INTO artista(idArtista, noDocumento, tipoDocumento, nombreArtista, apellidoArtista, nombreArtistico, feNacimArtista, emailArtista, estadoArtista) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            con=Conexion.conectar(); //Abre la conexión con la BD
            ps=con.prepareStatement(sql); //Prepara la sentencia
            ps.setInt(1, artista.getIdArtista());
            ps.setInt(2, artista.getNoDocumento());
            ps.setString(3, artista.getTipoDocumento());
            ps.setString(4, artista.getNombreArtista());
            ps.setString(5, artista.getApellidoArtista());
            ps.setString(6, artista.getNombreArtistico());
            ps.setInt(7, artista.getFeNacimArtista());
            ps.setString(8, artista.getEmailArtista());
            ps.setBoolean(9, artista.isEstadoArtista());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecuta la sentencia
            ps.close(); //Cierra la sentencia
            System.out.println("Se registro el artista correctamente");
        }catch (Exception e){
            System.out.println("Error en el registro del álbum " + e.getMessage().toString());
        }
        finally{
            con.close(); //Cierra conexión con la BD
        }

        return r; // Retorna el numero de filas afectadas   
    }

    //!Listar
    public List<ArtistaVo> listar() throws SQLException{
        List<ArtistaVo> artistaNCSG=new ArrayList<>();
        sql="SELECT * FROM artista ";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ArtistaVo r=new ArtistaVo();
                //Escribimos en el setter cada valor encontrado
                r.setIdArtista(rs.getInt("idArtista"));
                r.setNoDocumento(rs.getInt("noDocumento"));
                r.setTipoDocumento(rs.getString("tipoDocumento"));
                r.setNombreArtista(rs.getString("nombreArtista"));
                r.setApellidoArtista(rs.getString("apellidoArtista"));
                r.setNombreArtistico(rs.getString("nombreArtistico"));
                r.setFeNacimArtista(rs.getInt("feNacimArtista"));
                r.setEmailArtista(rs.getString("emailArtista"));
                r.setEstadoArtista(rs.getBoolean("estadoArtista"));
                artistaNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch (Exception e){
            System.out.println("La consulta no se pudo ejecutar correctamente " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return artistaNCSG; //Retorna array con los datos de la tabla
    }

    //!Eliminar
    public void eliminar(int idArtista) throws SQLException{
        sql="DELETE FROM artista WHERE idArtista="+idArtista;
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

    
    //!Estado
    public void estado(Boolean estadoArtista, int idArtista) throws SQLException{
        sql="UPDATE artista SET estadoArtista="+estadoArtista+" WHERE idArtista="+idArtista;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se cambio el estado a "+estadoArtista+" correctamente");
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }

    //!Editar
    public List<ArtistaVo> listarArtista(int idArtista) throws SQLException{
        List<ArtistaVo> artistaNCSG=new ArrayList<>();
        sql="SELECT * FROM artista WHERE idArtista="+idArtista;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ArtistaVo r=new ArtistaVo();
                //Escribimos en el setter cada valor encontrado
                r.setIdArtista(rs.getInt("idArtista"));
                r.setNoDocumento(rs.getInt("noDocumento"));
                r.setTipoDocumento(rs.getString("tipoDocumento"));
                r.setNombreArtista(rs.getString("nombreArtista"));
                r.setApellidoArtista(rs.getString("apellidoArtista"));
                r.setNombreArtistico(rs.getString("nombreArtistico"));
                r.setFeNacimArtista(rs.getInt("feNacimArtista"));
                r.setEmailArtista(rs.getString("emailArtista"));
                r.setEstadoArtista(rs.getBoolean("estadoArtista"));
                artistaNCSG.add(r);
            }
            ps.close();
            System.out.println("Consulta exitosa al artista en especifico");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return artistaNCSG;
    }

    //!Actualizar
    public int actualizar(ArtistaVo artista) throws SQLException{
        sql="UPDATE artista SET idArtista=?,noDocumento=?,tipoDocumento=?,nombreArtista=?,apellidoArtista=?,nombreArtistico=?,feNacimArtista=?,emailArtista=?,estadoArtista=?";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1, artista.getIdArtista());
            ps.setInt(2, artista.getNoDocumento());
            ps.setString(3, artista.getTipoDocumento());
            ps.setString(4, artista.getNombreArtista());
            ps.setString(5, artista.getApellidoArtista());
            ps.setString(6, artista.getNombreArtistico());
            ps.setInt(7, artista.getFeNacimArtista());
            ps.setString(8, artista.getEmailArtista());
            ps.setBoolean(9, artista.isEstadoArtista());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito el artista correctamente");
        }catch (Exception e){
            System.out.println("Error al editar el artista " + e.getMessage().toString());
        }
        finally{
            con.close();
        }
        
        return r;
    }

    
}
