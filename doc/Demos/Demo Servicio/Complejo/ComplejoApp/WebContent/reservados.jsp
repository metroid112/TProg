<%-- 
    Document   : index.jsp
    Created on : Oct 23, 2016, 10:16:30 PM
    Author     : efviodo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="complejoservidor.publicar.DataPersona" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ComplejoApp::Reservados</title>
        <link rel="icon" type="image/png" href="/ComplejoApp/media/img/favicon.png">
        
        <!-- JQuery -->
        <script src="/ComplejoApp/media/jquery-3.1.1.min.js"></script>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="/ComplejoApp/media/bootstrap/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="/ComplejoApp/media/bootstrap/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="/ComplejoApp/media/bootstrap/js/bootstrap.min.js"></script>
        
        <style>
            ul {
                list-style-type: none
            }
            li{
                border: 1px solid #ddd;
                box-shadow: 0 2px 1px 0 hsla(0,0%,91%,.5);
                border-radius: 2px;
                margin: 1%;
                width: 18%;
            }
            .imagen-etiqueta{
                width: 100%;
                bottom: 10px;
                height: 50px;
                display: block;
                clear: both;
                font-weight: 600;
                background-color: #00A8E2;
                color: white;
                height: 70px;
                float: left;
            }
            .numero{
                height: 100%;
                width: 25%;
                background-color: #005194;
                display: block;
                height: 70px;
                float: left;
                text-align: center;
                font-size: 2rem;
                line-height: 300%;
            }
            .nombre{
                width: 75%;
                display: block;
                height: 70px;
                text-align: left;
                float: left;
                padding-left: 14px;
                padding-top: 15px;
            }
            .title{
                color: #64BCEC;
                line-height: 300%;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-md-2 col-md-offset-1">
                    <img src="/ComplejoApp/media/img/LOGO-AUF.png" width="100%">
                </div>
                <div class="col-sm-12 col-md-7">
                    <h1 class="title">Futbolistas Reservados</h1>
                </div>
                <div class="col-sm-2">
                    <audio controls autoplay>
                        <source src="/ComplejoApp/Audios" type="audio/mpeg" autoplay>
                    </audio>
                </div>
            </div>
            <div class="row" style="background-color: #e4e6e7">
                <div class="col-sm-12 col-md-10 col-md-offset-1">
                    <ul>
                    <%    
//                     	DataPersona[] cont =  (DataPersona[]) request.getAttribute("reservados");
                    	List<DataPersona> cont =  (List<DataPersona>) request.getAttribute("reservados");
                    
//                         List<DataPersona> personas = Arrays.asList(cont);
                    	Iterator<DataPersona> itr = cont.iterator();
                        int numero = 0;
                        while (itr.hasNext()) {
                            numero++;
                            DataPersona item = itr.next();
                        %>
                        <li style="float: left">
                            <img src="/ComplejoApp/Imagenes?id=<%= item.getImagen() %>" alt="<%= item.getNombre() %>" 
                                 class="" style="width: 100%">

                            <div class="imagen-etiqueta">
                                <span class="numero">
                                    <%= numero %>
                                </span>
                                <span class="nombre">
                                    <strong>
                                        <%= item.getNombre() %> <br />
                                        <%= item.getApellido() %>
                                    </strong>
                                </span>
                            </div>
                        </li>
                       <%       
                      }
                     %> 
                     </ul>
                </div>
            </div>
        </div>
    </body>
</html>
