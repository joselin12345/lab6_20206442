package Servlets;

import Daos.ListarCancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListaCancionesServlet", value = "/listaCanciones")
public class ListaCancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ListarCancionesDao listarCancionesDao = new ListarCancionesDao();

        request.setAttribute("listarPorBanda",listarCancionesDao.listaPorBanda());
        request.getRequestDispatcher("vistas/listaCancion.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
