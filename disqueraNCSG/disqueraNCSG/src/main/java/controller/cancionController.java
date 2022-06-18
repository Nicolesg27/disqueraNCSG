package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CancionDao;
import model.CancionVo;


public class cancionController extends HttpServlet {

    CancionDao rd= new CancionDao();
    CancionVo r= new CancionVo();
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
        if(req.getParameter("id_cancion") !=null){
            r.setidCancion(Integer.parseInt(req.getParameter("id_cancion")));
        }
        try{
            List<CancionVo> cancionNCSG=rd.listarCancion(r.getidCancion());
            req.setAttribute("cancion", cancionNCSG);
            req.getRequestDispatcher("views/Cancion/editCancion.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edición");
        }catch (Exception e){
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id_cancion") !=null){
            r.setidCancion(Integer.parseInt(req.getParameter("id_cancion")));
        }
        if(req.getParameter("estado_cancion") !=null){
            r.setestadoCancion(Boolean.parseBoolean(req.getParameter("estado_cancion")));
        }
        try{
            rd.estado(r.isestadoCancion(), r.getidCancion());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error en el cambio de estado " + e.getMessage().toString());
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("Id_Cancion") !=null){
            r.setidCancion(Integer.parseInt(req.getParameter("Id_Cancion")));// Cambia la variable que viene de la vista como string, haciendo la conversion a entero que es lo que entiende la base de datos
        }
        try{
            rd.eliminar(r.getidCancion());
            System.out.println("El dato se elimino con exito");
            visualizar(req, resp);
        }catch(Exception e){
            System.out.println("Error al eliminar un dato " + e.getMessage().toString());
        }
    }
    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List<CancionVo> cancionNCSG=rd.listar();
            req.setAttribute("listarC", cancionNCSG);
            req.getRequestDispatcher("views/Cancion/listCancion.jsp").forward(req, resp);
            System.out.println("Datos listados de manera exitosa, disfruta de las mejores canciones producidas en PineApple");
        }catch (Exception e){
            System.out.println("Hay problemas al momento de listar los datos " + e.getMessage().toString());
        }
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cancion/addCancion.jsp").forward(req, resp);
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
        if(req.getParameter("id_cancion") !=null){
            r.setidCancion(Integer.parseInt(req.getParameter("id_cancion")));
         }
         if(req.getParameter("nombre_cancion") !=null){
             r.setnombreCancion(req.getParameter("nombre_cancion"));
         }
         if(req.getParameter("fecha_cancion") !=null){
            r.setfechaGrabacion(Integer.parseInt(req.getParameter("fecha_cancion")));
         }
         if(req.getParameter("duracion_cancion") !=null){
            r.setduracionCancion(Integer.parseInt(req.getParameter("duracion_cancion")));
         }
         if(req.getParameter("estado_cancion") !=null){
             r.setestadoCancion(true);
         }
         else{
             r.setestadoCancion(false);
         }
         try{
             rd.actualizar(r);
             System.out.println("Editar el registro de la canción correctamente");
             visualizar(req, resp); 
         }catch (Exception e){
             System.out.println("Error al editar el registro " + e.getMessage().toString());
         }

    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id_cancion") !=null){
            r.setidCancion(Integer.parseInt(req.getParameter("id_cancion")));
         }
         if(req.getParameter("nombre_cancion") !=null){
             r.setnombreCancion(req.getParameter("nombre_cancion"));
         }
         if(req.getParameter("fecha_cancion") !=null){
            r.setfechaGrabacion(Integer.parseInt(req.getParameter("fecha_cancion")));
         }
         if(req.getParameter("duracion_cancion") !=null){
            r.setduracionCancion(Integer.parseInt(req.getParameter("duracion_cancion")));
         }
         if(req.getParameter("estado_cancion") !=null){
             r.setestadoCancion(true);
         }
         else{
             r.setestadoCancion(false);
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
