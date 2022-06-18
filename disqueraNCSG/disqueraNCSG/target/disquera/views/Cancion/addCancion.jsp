<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title> Cancion </title>
    <link rel="stylesheet" href="cancion?accion=estilos">
</head>

<body>
    <section class="form-register">

      <form action="cancion" method="post">
       <center> <h4>Agregar Cancion</h4></center>
        <input class="controls" type="number" name="id_cancion" id="id" placeholder="ID">

        <input class="controls" type="text" name="nombre_cancion" id="name" placeholder="Nombre">

        <input class="controls" type="number" name="fecha_cancion" id="fecha" placeholder="Fecha de Grabacion">

        <input class="controls" type="number" name="duracion_cancion" id="name" placeholder="Duración de la Cancion">

        <input class="controls" type="text" name="estado_cancion" id="estado" placeholder="Estado">

        <input class="botons" type="submit" value="Volver">
        <input class="botons" type="submit" value="Guardar">
       </form>
      </section>
</body>
</html>