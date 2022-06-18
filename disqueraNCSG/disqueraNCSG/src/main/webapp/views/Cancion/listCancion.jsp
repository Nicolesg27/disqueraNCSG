<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="cancion?accion=estilo">
    <title>Lista de Canciones</title>
</head>
<body>
    <body background="../assets/img/fondo.png"></body>
    <a class="button" href="cancion?accion=registrar">Nueva Cancion</a>
    <table class="greenTable">
        <thead>
        <tr>
            <th style="width:120px;">Id Canción</th>
            <th style="width:120px;">Nombre Canción</th>
            <th style="width:120px;">Fecha Grabacion</th>
            <th style="width:120px;">Duracion Canción</th>
            <th style="width:120px;">Estado Canción</th>
            <th style="width:120px;">Cambio de estado</th>
            <th style="width:120px;">Acciones</th>
            <th style="width:60px;"></th>
            <th style="width:60px;"></th>
        </tr>
        
            <c:forEach var="cancionNCSG" items="${listarC}">
                <tr>
                    <td>${cancionNCSG.getidCancion()}</td>
                    <td>${cancionNCSG.getnombreCancion()}</td>
                    <td>${cancionNCSG.getfechaGrabacion()}</td>
                    <td>${cancionNCSG.getduracionCancion()}</td>

                    <c:if test="$cancionNCSG.isestadoCancion() == true}">
                        <td><span>Canción Activo</span></td>
                    </c:if>
                    <c:if test="${cancionNCSG.isestadoCancion() == false}">
                        <td><span>Canción Inactivo</span></td>
                    </c:if>
                    <c:if test="${cancionNCSG.isestadoCancion() == true}">
                        <td>
                            <a href="cancion?accion=est&id_cancion=${cancionNCSG.getidCancion()}&estado_cancion=false"><button class="button" type="button">Inactivar</button></a>
                        </td>
                    </c:if>
                    <c:if test="${cancionNCSG.isestadoCancion() == false}">
                        <td>
                            <a href="cancion?accion=est&id_cancion=${cancionNCSG.getidCancion()}&estado_cancion=true"><button class="button" type="button">Activar</button></a>
                        </td>
                    </c:if>
                        <td>
                            <a href="cancion?accion=editar&idCancion=${cancionNCSG.getidCancion()}"><button class="button" type="button">Editar</button></a>
    
                            <a href="cancion?accion=eliminar&idCancion=${cancionNCSG.getidCancion()}"><button class="button" type="button">Eliminar</button></a>
                        </td>
                </tr>
            </c:forEach>
        </thead>
        </table>
</body>
</html>