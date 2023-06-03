<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones"/>
</jsp:include>
<%
    ArrayList<Cancion> listarPorBanda = (ArrayList<Cancion>) request.getAttribute("listarPorBanda");
%>

<body>
<div class='container'>
    <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="Canciones"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <h1 class='text-light'>Lista de Canciones por banda:</h1>
        </div>
        <div class="col-lg-6">
            <a class="btn btn-warning" href="<%=request.getContextPath()%>/ListaTotalCancionServlet">Mostrar todas las canciones</a>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>CANCION</th>
                <th>BANDA</th>
            </tr>
            </thead>

            <tbody>}
            <%for (Cancion cancion:listarPorBanda){%>
            <tr>
                <td><%=cancion.getIdcancion()%>
                </td>
                <td><%=cancion.getNombreCancion()%>
                </td>
                <td><%=cancion.getBanda()%>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
