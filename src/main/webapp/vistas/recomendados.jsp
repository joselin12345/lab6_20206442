<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jossr
  Date: 1/06/2023
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Recomendados"/>
</jsp:include>
<%
    ArrayList<Cancion> lista = (ArrayList<Cancion>) request.getAttribute("lista");
%>

    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="Recomendados"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendados:</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>Ver</th>
                    </tr>
                    </thead>

                    <tbody>}
                    <%for (Cancion cancion:lista){%>
                        <tr>
                            <td><%=cancion.getIdcancion()%>
                            </td>
                            <td><%=cancion.getNombreCancion()%>
                            </td>
                            <td><%=cancion.getBanda()%>
                            </td>
                            <td><button class="btn btn-success">Más detalles</button>
                            </td>
                        </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
