package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeneroDao;
import model.GeneroVo;

public class generoController extends HttpServlet {
    GeneroVo r = new GeneroVo();
    GeneroDao rd = new GeneroDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "abrirForm":
                abrirForm(req,resp);
            break;
            case "abrireditar":
            abrireditar(req,resp);
        break;
            case "listar":
                listar(req,resp);
            break;
            case "eliminar":
                eliminar(req,resp);
            break;
            case "cambiarEstado":
            estado(req,resp);
        break;    

        case "estilos":
                req.getRequestDispatcher("assets/CSS/style.css").forward(req,resp);
            break;

            case "estilo":
            req.getRequestDispatcher("assets/CSS/styleee.css").forward(req,resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "add":
                add(req,resp);
            break;
            case "editar":
            editar(req,resp);
        break;
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            r.setidGenero( Integer.parseInt(req.getParameter("idGenero")) );
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setestadoGenero(false); 
        }else{
            r.setestadoGenero(true);
        }
        try {
            rd.estadoGenero(r.getidGenero(),r.getestadoGenero());
            System.out.println("Cambió de estado correctamente");
            listar(req,resp);
        } catch (Exception e) {
            System.out.println("Error al cambiar estado "+e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            r.setidGenero( Integer.parseInt(req.getParameter("idGenero")) );
        }
        try {
            rd.eliminarGenero(r.getidGenero());
            System.out.println("Eliminado correctamente");
            listar(req,resp);
        } catch (Exception e) {
            System.out.println("Error al eliminar "+e.getMessage().toString());
        }
    }

       private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        
        try{
            req.getRequestDispatcher("views/Genero/addGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario no ha sido abierto"+e.getMessage().toString());
        }
    }

    private void abrireditar(HttpServletRequest req, HttpServletResponse resp) {
       
        if(req.getParameter("idGenero")!=null){
            r.setidGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        
        try{
            List<GeneroVo> generosList = rd.Listargenero(r.getidGenero());
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/Genero/editGenero.jsp").forward(req, resp);
            System.out.println("El formulario de editar ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario de editar no ha sido abierto"+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreGenero")!=null){
            r.setnombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setestadoGenero(true);
        }
        else{
            r.setestadoGenero(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            listar(req,resp);
        } catch (Exception e) {
            System.out.println("Error en la insertar del registro "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<GeneroVo> generosList=rd.listar();
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/Genero/listGenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("idGenero")!=null){
            r.setidGenero(Integer.parseInt(req.getParameter("idGenero")) );
        }
        if(req.getParameter("nombreGenero")!=null){
            r.setnombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setestadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        
        try {
            rd.editar(r);
            System.out.println("Registro editado correctamente");
            listar(req,resp);
        } catch (Exception e) {
            System.out.println("Error en el registro "+e.getMessage().toString());
        }
    }
}