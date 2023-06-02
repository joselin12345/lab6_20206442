package Servlets;

import Daos.RecomendablesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecomendadosServlet", value = "/listaRecomendados")
public class RecomendadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendablesDao recomendablesDao = new RecomendablesDao();

        request.setAttribute("lista", recomendablesDao.lista());
        request.getRequestDispatcher("vistas/recomendados.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
