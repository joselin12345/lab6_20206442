package Servlets;

import Daos.ListarCancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListaTotalCancionServlet", value = "/ListaTotalCancion")
public class ListaTotalCancionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListarCancionesDao listarCancionesDao = new ListarCancionesDao();

        request.setAttribute("listaTodo",listarCancionesDao.listaTodo());
        request.getRequestDispatcher("ListaTotalCancion").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
