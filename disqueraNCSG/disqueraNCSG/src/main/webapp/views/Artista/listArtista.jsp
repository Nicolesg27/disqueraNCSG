<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="artista?accion=estilo">
    <title>Lista de Artistas</title>
</head>
<body>
    <body background="../assets/img/fondo.png"></body>
    <a class="button" href="artista?accion=registrar">Nuevo Artista</a>
    <table class="greenTable">
        <thead>
        <tr>
            <th style="width:120px;">Id Artista</th>
            <th style="width:120px;">No. Documento</th>
            <th style="width:120px;">Tipo Documento</th>
            <th style="width:120px;">Nombre Artista</th>
            <th style="width:120px;">Apellido Artista</th>
            <th style="width:120px;">Nombre Artistico</th>
            <th style="width:120px;">Fecha Nacimiento</th>
            <th style="width:120px;">Email Artista</th>
            <th style="width:120px;">Estado Artista</th>
            <th style="width:120px;">Cambio de estado</th>
            <th style="width:120px;">Acciones</th>
            <th style="width:60px;"></th>
            <th style="width:60px;"></th>
        </tr>
        
            <c:forEach var="artistaNCSG" items="${listarAR}">
                <tr>
                    <td>${artistaNCSG.getIdArtista()}</td>
                    <td>${artistaNCSG.getNoDocumento()}</td>
                    <td>${artistaNCSG.getTipoDocumento()}</td>
                    <td>${artistaNCSG.getNombreArtista()}</td>
                    <td>${artistaNCSG.getApellidoArtista()}</td>
                    <td>${artistaNCSG.getNombreArtistico()}</td>
                    <td>${artistaNCSG.getFeNacimArtista()}</td>
                    <td>${artistaNCSG.getEmailArtista()}</td>
    
                    <c:if test="$artistaNCSG.isEstadoArtista() == true}">
                        <td><span>Artista Activo</span></td>
                    </c:if>
                    <c:if test="${artistaNCSG.isEstadoArtista() == false}">
                        <td><span>Artista Inactivo</span></td>
                    </c:if>
                    <c:if test="${artistaNCSG.isEstadoArtista() == true}">
                        <td>
                            <a href="artista?accion=est&id_artista=${artistaNCSG.getIdArtista()}&estado_artista=false"><button class="button" type="button">Inactivar</button></a>
                        </td>
                    </c:if>
                    <c:if test="${artistaNCSG.isEstadoArtista() == false}">
                        <td>
                            <a href="artista?accion=est&id_artista=${artistaNCSG.getIdArtista()}&estado_artista=true"><button class="button" type="button">Activar</button></a>
                        </td>
                    </c:if>
                        <td>
                            <a href="artista?accion=editar&idArtista=${artistaNCSG.getIdArtista()}"><button class="button" type="button">Editar</button></a>
    
                            <a href="artista?accion=eliminar&idArtista=${artistaNCSG.getIdArtista()}"><button class="button" type="button">Eliminar</button></a>
                        </td>
                </tr>
            </c:forEach>
        </thead>
        </table>
</body>
</html>