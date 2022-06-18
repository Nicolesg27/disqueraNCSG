<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title> Género </title>
    <link rel="stylesheet" href="genero?accion=estilos">
</head>

<body>
    <body background="../assets/img/fondo.png"></body>
    <section class="form-register">

      <form action="genero" method="post">
       <center> <h4>Registrar Género</h4></center>
        <input class="controls" type="text" name="nombreGenero" id="nombreGenero" placeholder="Nombre">
        <input class="controls" type="number" name="estadoGenero" id="estadoGenero" placeholder="Estado">
        <input class="botons" type="submit" value="Volver">
        <input class="botons" type="submit" name="accion" value="add">
       </form>
      </section>
</body>
</html>