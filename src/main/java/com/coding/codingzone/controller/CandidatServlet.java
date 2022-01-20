package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.CandidatImpl;
import com.coding.codingzone.daoImpl.CategoryImpl;
import com.coding.codingzone.model.Candidat;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CandidatServlet", value = {"/CandidatServlet","/newCandidat","/deleteCandidat","/editCandidat","/updateCandidat","/addCandidat","/listCandidats"})
public class CandidatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/newCandidat":
                showForm(request, response);
                break;
            case "/listCandidats":
                listCandidats(request, response);
                break;
            case "/updateCandidat":
                try {
                    updateCandidat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/editCandidat":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/deleteCandidat":
                try {
                    deleteCandidat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/addCandidat":
                try {
                    addCandidat(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                listCandidats(request, response);
                break;
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/addCandidats.jsp");
        dispatcher.forward(request, response);

    }

    private void listCandidats(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CandidatImpl candidat = new CandidatImpl();
        System.out.println(candidat.all());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/index.jsp");
        request.setAttribute("data", candidat.all());
        dispatcher.forward(request, response);
    }

    private void addCandidat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        Person person = new Person(firstname,lastname,email);
        Candidat candidat = new Candidat();
        CandidatImpl candidat1 = new CandidatImpl();
        candidat1.addCandidat(candidat,person);
        response.sendRedirect("listCandidats");
    }

    private void deleteCandidat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String id_person = request.getParameter("id_person");
        CandidatImpl candidat = new CandidatImpl();
        candidat.deleteCandidat(id,id_person);
        response.sendRedirect("listCandidats");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        CandidatImpl candidat = new CandidatImpl();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/editCandidat.jsp");
        request.setAttribute("data", candidat.find(id));
        dispatcher.forward(request, response);
    }


    private void updateCandidat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String id_person = request.getParameter("id");
        Person person = new Person(id_person,firstname,lastname,email);
        CandidatImpl candidat1 = new CandidatImpl();
        candidat1.updateCandidat(person);
        response.sendRedirect("listCandidats");
    }

}
