package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.CategoryImpl;
import com.coding.codingzone.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

@WebServlet(name = "CategoryServlet", value = {"/CategoryServlet","/insert","/new","/delete","/listCategory","/edit","/update"})

public class CategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showForm(request, response);
                    break;
                case "/insert":
                    addCategory(request, response);
                    break;
                case "/delete":
                    deleteCategory(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        CategoryImpl category = new CategoryImpl();
        System.out.println(category.all());
        request.setAttribute("data", category.all());
        this.getServletContext().getRequestDispatcher("/view/category/index.jsp").forward(request,response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/category/addCategory.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        CategoryImpl category = new CategoryImpl();
        System.out.println(category.find(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/category/editCategory.jsp");
        request.setAttribute("data", category.find(id));
        dispatcher.forward(request, response);
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Category category = new Category(name,image);
        System.out.println(category);
        CategoryImpl category1 = new CategoryImpl();
        category1.create(category);
        response.sendRedirect("listCategory");
    }
    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Category category = new Category(id,name,image);
        CategoryImpl category1 = new CategoryImpl();
        category1.update(category);
        response.sendRedirect("listCategory");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id_category");
        CategoryImpl category1 = new CategoryImpl();
        category1.delete(id);
        response.sendRedirect("listCategory");
    }


}
