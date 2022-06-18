<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title> Album </title>
    <link rel="stylesheet" href="album?accion=estilos">
</head>

<body>
    <body background="../assets/img/fondo.png"></body>
    <section class="form-register">

      <form action="album" method="post">
       <center> <h4>Editar Album</h4></center>
       <input class="controls" type="number" name="id"  placeholder="ID">

       <input class="controls" type="text" name="nombreAlb"  placeholder="Nombre del Album">

       <input class="controls" type="number" name="publicacion"  placeholder="A&ntilde;o Publicacion">

       <input class="controls" type="text" name="estado" placeholder="Estado del Álbum">

        <input class="botons" type="submit" value="Volver">

        <button class="botons" type="submit" class="button" name="accion" value="Editar">Guardar Cambios</button>
       </form>
      </section>
</body>
</html>