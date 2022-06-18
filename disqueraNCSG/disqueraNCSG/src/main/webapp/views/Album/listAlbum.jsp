<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="album?accion=estilo">
    <title>Lista de Albums</title>
</head>
<body>
    <body background="../assets/img/fondo.png"></body>
    <a class="button" href="album?accion=registrar">Nuevo Álbum</a>
    <table class="greenTable">
        <thead>
        <tr>
        <th style="width:120px;">Id</th>
        <th style="width:120px;">Nombre</th>
        <th style="width:120px;">Año Publicacion</th>
        <th style="width:120px;">Estado</th>
        <th style="width:120px;">Cambio de Estado</th>
        <th style="width:120px;">Acciones</th>
        <th style="width:60px;"></th>
        <th style="width:60px;"></th>
        </tr>
        
            <c:forEach var="albumLNCSG" items="${listarAlbum}">
                <tr>
                    <td>${albumLNCSG.getidAlbum()}</td>
                    <td>${albumLNCSG.getnombreAlbum()}</td>
                    <td>${albumLNCSG.getanioPublicacion()}</td>
    
                    <c:if test="$albumLNCSG.isestadoAlbum() == true}">
                        <td><span>Álbum Activo</span></td>
                    </c:if>
                    <c:if test="${albumLNCSG.isestadoAlbum() == false}">
                        <td><span>Álbum Inactivo</span></td>
                    </c:if>
                    <c:if test="${albumLNCSG.isestadoAlbum() == true}">
                        <td>
                            <a href="album?accion=est&id=${albumLNCSG.getidAlbum()}&estado=false"><button class="button" type="button">Inactivar</button></a>
                        </td>
                    </c:if>
                    <c:if test="${albumLNCSG.isestadoAlbum() == false}">
                        <td>
                            <a href="album?accion=est&id=${albumLNCSG.getidAlbum()}&estado=true"><button class="button" type="button">Activar</button></a>
                        </td>
                    </c:if>
                        <td>
                            <a href="album?accion=editar&idAlbum=${albumLNCSG.getidAlbum()}"><button class="button" type="button">Editar</button></a>
    
                            <a href="album?accion=eliminar&idAlbum=${albumLNCSG.getidAlbum()}"><button class="button" type="button">Eliminar</button></a>
                        </td>
                </tr>
            </c:forEach>
        </thead>
        </table>
</body>
</html>