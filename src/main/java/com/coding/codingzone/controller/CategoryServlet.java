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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class CategoryServlet extends HttpServlet {

    public static final String UPLOAD_DIR = "C:\\Users\\adm\\Desktop\\codingzone\\src\\main\\webapp\\view\\images";
    public String dbFileName = "";

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
        Part part = request.getPart("file");
        String fileName = extractFileName(part);
        String savePath = UPLOAD_DIR + File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
        dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
        Category category = new Category(name,dbFileName);
        System.out.println(category);
        CategoryImpl category1 = new CategoryImpl();
        category1.create(category);
        response.sendRedirect("listCategory");
    }
    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String imgae = request.getParameter("image");
        Category category = new Category(id,name,imgae);
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

    private String extractFileName(Part part) {
        //This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
