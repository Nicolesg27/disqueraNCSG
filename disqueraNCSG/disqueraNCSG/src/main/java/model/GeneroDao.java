package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GeneroDao {
    
    //Atributos
    Connection con; //Objeto para la conexión
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto para almacenar resultados de consultas
    String sql=null; // Variable para almacenar sentencias SQL
    int r;

    public List<GeneroVo> listar() throws Exception{
		
		List<GeneroVo> genero=new ArrayList<>();
		sql="SELECT *FROM genero";
		
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				GeneroVo r=new GeneroVo();
				r.setidGenero(rs.getInt("idGenero"));
				r.setnombreGenero(rs.getString("nombreGenero"));
				r.setestadoGenero(rs.getBoolean("estadoGenero"));
				
				genero.add(r);
			}
			ps.close(); 
			System.out.println("consulta exitosa");
		}catch(Exception e) {
			System.out.println("No existen generos definidos"+e.getMessage());
		}finally {
			con.close();
		}
		return genero;
	}
	

    public int registrar(GeneroVo genero) throws SQLException{

        sql="INSERT INTO genero(nombreGenero,estadoGenero) VALUES(?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql);
            ps.setString(1,genero.getnombreGenero());
            ps.setBoolean (2,genero.getestadoGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el genero");


        }catch(Exception e){
            System.out.println("Se presentó un error en el registro del genero "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    public void eliminarGenero(int idGenero) throws SQLException {
		sql="DELETE FROM genero WHERE idGenero="+idGenero;
		System.out.println(sql);
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se eliminó el genero");
		}catch(Exception e) {
			System.out.println("Error en la eliminación del registro "+e.getMessage());
		}
		finally {
			con.close();
		}
	}

	public void estadoGenero(int idGenero, boolean estado) throws SQLException {
		sql="UPDATE genero SET estadoGenero="+estado+" WHERE idGenero="+idGenero;
		System.out.println(sql);
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se cambio del estado correctamente");
		}catch(Exception e) {
			System.out.println("Error en el cambio de estado "+e.getMessage());
		}
		finally {
			con.close();
		}
	} 

	public int editar(GeneroVo genero) throws SQLException{
	
        sql="UPDATE genero SET nombreGenero='"+genero.getnombreGenero()+"', estadoGenero="+genero.getestadoGenero()+" WHERE idGenero="+genero.getidGenero();
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se edito el genero");


        }catch(Exception e){
            System.out.println("Se presentó un error la edicion del genero "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
	public List<GeneroVo> Listargenero(int idGenero) throws SQLException{
        List<GeneroVo> genero = new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero = " + idGenero;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo r = new GeneroVo();
                r.setidGenero(rs.getInt("idGenero"));
                r.setnombreGenero(rs.getString("nombreGenero"));
                r.setestadoGenero(rs.getBoolean("estadoGenero"));
                genero.add(r);
            }
            ps.close();
            System.out.println("Consulta correcta de genero");
        } catch (Exception e) {
            System.out.println("La consulta no se ejecuto "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return genero;
    }
}
