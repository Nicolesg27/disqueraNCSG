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

        <form action="artista" method="post">
            <center> <h4>Agregar Artista</h4></center>
             <input class="controls" type="number" name="id_artista"  placeholder="ID">
     
             <input class="controls" type="number" name="nodocumento"  placeholder="Número de documento">
     
             <input class="controls" type="text" name="tipodocumento"  placeholder="Tipo de documento">
     
             <input class="controls" type="text" name="nombre_artista" placeholder="Nombre">
     
             <input class="controls" type="text" name="apellido_artista" placeholder="Apellidos">
     
             <input class="controls" type="text" name="nombre_artistico" placeholder="Nombre Artistico">
     
             <input class="controls" type="number" name="nacimiento_artista" placeholder="Fecha de nacimiento">
     
             <input class="controls" type="text" name="email_artista" placeholder="Email">
     
             <input class="controls" type="text" name="estado_artista" placeholder="Estado del artista">
     
             <input class="botons" type="submit" value="Volver">
             
             <button class="botons" type="submit" class="btn btn-sucess" name="accion" value="Editar">Editar Artista</button>
            </form>
      </section>
</body>
</html>