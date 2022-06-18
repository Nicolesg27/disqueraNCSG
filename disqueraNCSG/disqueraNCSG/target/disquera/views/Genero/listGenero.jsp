<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="genero?accion=estilo">
    <title>Lista de Géneros</title>
</head>
<body background="../assets/img/fondo.png">
    <table class="greenTable">
          <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Estado</th>
                <th>Cambio de estado</th>
                <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            <tr>
                <td colspan="5">
                    <a id="addGenero" class="btn btn-info" href="genero?accion=abrirForm" role="button">Agregar género</a>
                </td>
            </tr>
    
            <c:forEach var="genero" items="${generosList}">         
              <tr>
                <td>${genero.getidGenero()}</td>
                <td>${genero.getnombreGenero()}</td>
                <c:if test = "${genero.getestadoGenero() == true}">
                    <td><span class="badge bg-success active">Activo</span></td> 
                  </c:if>
                  <c:if test = "${genero.getestadoGenero() == false}">
                      <td><span class="badge bg-danger active">Inactivo</span></td> 
                </c:if>
    
                <c:if test="${genero.getestadoGenero() == true}">
                  <td>
                    <a href="genero?accion=cambiarEstado&idGenero=${genero.getidGenero()}&estadoGenero=false"><button class="btn btn-info" type="button">Inactivar</button> </a> 
                  </td> 
                </c:if>
                <c:if test="${genero.getestadoGenero() == false}">
                  <td>
                    <a href="genero?accion=cambiarEstado&idGenero=${genero.getidGenero()}&estadoGenero==true"><button class="btn btn-info" type="button">Activar</button> </a>
                  </td> 
                </c:if>
                <td>
                  <a id="botonList1" class="btn btn-danger" href="genero?accion=eliminar&idGenero=${genero.getidGenero()}" role="button">Eliminar género</a>
                  <a id="botonList2" class="btn btn-success" href="genero?accion=abrireditar&idGenero=${genero.getidGenero()}" role="button">Actualizar género</a>
                </td>
              <tr>
            </c:forEach>
          </tbody>
        </table>
</body>
</html>