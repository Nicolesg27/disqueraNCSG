package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumDao;
import model.AlbumVo;

public class albumController extends HttpServlet {

    AlbumDao rd=new AlbumDao();
    AlbumVo r=new AlbumVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){

            case "registrar":
            registrar(req, resp);
            break;

            case "visualizar":
            visualizar(req, resp);
            break;

            case "eliminar":
            eliminar(req, resp);
            break;

            case "est":
            estado(req, resp);
            break;

            case "editar":
            editar(req, resp);
            break;

            case "estilos":
                req.getRequestDispatcher("assets/CSS/style.css").forward(req,resp);
            break;

            case "estilo":
            req.getRequestDispatcher("assets/CSS/styleee.css").forward(req,resp);
            break;
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id") !=null){
            r.setidAlbum(Integer.parseInt(req.getParameter("id")));
        }
        try{
            List<AlbumVo> albumNCSG=rd.listar(r.getidAlbum());
            req.setAttribute("album", albumNCSG);
            req.getRequestDispatcher("views/Album/editAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        }catch (Exception e){
            System.out.println("Hay problemas al listar" + e.getMessage().toString());
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id") !=null){
            r.setidAlbum(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("estado") !=null){
            r.setestadoAlbum(Boolean.parseBoolean(req.getParameter("estado")));
        }
        try{
            rd.estado(r.isestadoAlbum(), r.getidAlbum());
            System.out.println("Cambio exitoso");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }

    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id") !=null){
            r.setidAlbum(Integer.parseInt(req.getParameter("id")));
        }
        try{
            rd.eliminar(r.getidAlbum());
            System.out.println("Dato eliminado con exito");
            visualizar(req, resp);
        }catch(Exception e){
            System.out.println("Error al eliminar un dato " + e.getMessage().toString());
        }
    }

    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List<AlbumVo> albumLNCSG=rd.listar();
            req.setAttribute("listarAlbum", albumLNCSG);
            req.getRequestDispatcher("views/Album/listAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados de manera exitosa, disfruta de los mejores álbumes");
        }catch (Exception e){
            System.out.println("Hay problemas al momento de listar los datos " + e.getMessage().toString());
        }
    }
    

    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Album/addAlbum.jsp").forward(req, resp);
            System.out.println("El formulario abierto");
        }catch (Exception e){
            System.out.println("El formulario NO ha sido abierto " + e.getMessage().toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al DoPost");
        String a=req.getParameter("accion");
 
        switch (a){
 
         case "Registrar":
         add(req, resp);
         break;
 
         case "Editar":
         edit(req, resp);
         break;
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id") !=null){
            r.setidAlbum(Integer.parseInt(req.getParameter("id")));
         }
         if(req.getParameter("nombreAlb") !=null){
             r.setnombreAlbum(req.getParameter("nombreAlb"));
         }
         if(req.getParameter("publicacion") !=null){
            r.setanioPublicacion(Integer.parseInt(req.getParameter("publicacion")));
         }
         if(req.getParameter("estado") !=null){
             r.setestadoAlbum(true);
         }
         else{
             r.setestadoAlbum(false);
         }
         try{
             rd.actualizar(r);
             System.out.println("Editar el registro de album correctamente");
             visualizar(req, resp); 
         }catch (Exception e){
             System.out.println("Error al editar el registro " + e.getMessage().toString());
         }

    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id") !=null){
            r.setidAlbum(Integer.parseInt(req.getParameter("id")));
         }
         if(req.getParameter("nombreAlb") !=null){
             r.setnombreAlbum(req.getParameter("nombreAlb"));
         }
         if(req.getParameter("publicacion") !=null){
            r.setanioPublicacion(Integer.parseInt(req.getParameter("publicacion")));
         }
         if(req.getParameter("estado") !=null){
             r.setestadoAlbum(true);
         }
         else{
             r.setestadoAlbum(false);
         }
        try{
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en la insercion del registro " + e.getMessage().toString());
        }
    }

    


  
}
