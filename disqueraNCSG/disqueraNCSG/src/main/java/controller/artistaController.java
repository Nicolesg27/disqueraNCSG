package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtistaDao;
import model.ArtistaVo;

public class artistaController extends HttpServlet {
    
    ArtistaDao rd= new ArtistaDao();
    ArtistaVo r= new ArtistaVo();

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
        if(req.getParameter("id_artista") !=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("id_artista")));
         }
        try{
            List<ArtistaVo> artista=rd.listarArtista(r.getIdArtista());
            req.setAttribute("artista", artista);
            req.getRequestDispatcher("views/Artista/editArtista.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edición");
        }catch (Exception e){
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id_artista") !=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("id_artista")));
         }
        if(req.getParameter("estado_artista") !=null){
            r.setEstadoArtista(Boolean.parseBoolean(req.getParameter("estado_artista")));
        }
        try{
            rd.estado(r.isEstadoArtista(), r.getIdArtista());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id_artista") !=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("id_artista")));
         }
        try{
            rd.eliminar(r.getIdArtista());
            System.out.println("El dato se elimino con exito");
            visualizar(req, resp);
        }catch(Exception e){
            System.out.println("Error al eliminar un dato " + e.getMessage().toString());
        }
    }

    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List<ArtistaVo> artistaNCSG=rd.listar();
            req.setAttribute("listarAR", artistaNCSG);
            req.getRequestDispatcher("views/Artista/listArtista.jsp").forward(req, resp);
            System.out.println("Datos listados de manera exitosa, disfruta de los mejores artistas");
        }catch (Exception e){
            System.out.println("Hay problemas al momento de listar los datos " + e.getMessage().toString());
        }
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Artista/addArtista.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
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
        if(req.getParameter("id_artista") !=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("id_artista")));
         }
        if(req.getParameter("nodocumento") !=null){
            r.setNoDocumento(Integer.parseInt(req.getParameter("nodocumento")));
        }
        if(req.getParameter("tipodocumento") !=null){
            r.setTipoDocumento(req.getParameter("tipodocumento"));
        }
        if(req.getParameter("nombre_artista") !=null){
             r.setNombreArtista(req.getParameter("nombre_artista"));
         }
        if(req.getParameter("apellido_artista") !=null){
            r.setApellidoArtista(req.getParameter("apellido_artista"));
        }
        if(req.getParameter("nombre_artistico") !=null){
           r.setNombreArtistico(req.getParameter("nombre_artistico"));
        }
        if(req.getParameter("nacimiento_artista") !=null){
          r.setFeNacimArtista(Integer.parseInt(req.getParameter("nacimiento_artista")));
        }
        if(req.getParameter("email_artista")!=null){
          r.setEmailArtista(req.getParameter("email_artista"));
        }
        if(req.getParameter("estado_artista") !=null){
             r.setEstadoArtista(true);
         }
        else{
             r.setEstadoArtista(false);
         }
        try{
             rd.actualizar(r);
             System.out.println("Editar el registro el artista correctamente");
             visualizar(req, resp); 
        }catch (Exception e){
             System.out.println("Error al editar el registro " + e.getMessage().toString());
         }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id_artista") !=null){
            r.setIdArtista(Integer.parseInt(req.getParameter("id_artista")));
         }
        if(req.getParameter("nodocumento") !=null){
            r.setNoDocumento(Integer.parseInt(req.getParameter("nodocumento")));
        }
        if(req.getParameter("tipodocumento") !=null){
            r.setTipoDocumento(req.getParameter("tipodocumento"));
        }
        if(req.getParameter("nombre_artista") !=null){
             r.setNombreArtista(req.getParameter("nombre_artista"));
         }
        if(req.getParameter("apellido_artista") !=null){
            r.setApellidoArtista(req.getParameter("apellido_artista"));
        }
        if(req.getParameter("nombre_artistico") !=null){
           r.setNombreArtistico(req.getParameter("nombre_artistico"));
        }
        if(req.getParameter("nacimiento_artista") !=null){
          r.setFeNacimArtista(Integer.parseInt(req.getParameter("nacimiento_artista")));
        }
        if(req.getParameter("email_artista")!=null){
          r.setEmailArtista(req.getParameter("email_artista"));
        }
        if(req.getParameter("estado_artista") !=null){
             r.setEstadoArtista(true);
         }
        else{
             r.setEstadoArtista(false);
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
