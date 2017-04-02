/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;  
import java.sql.*;  

import javax.servlet.http.*;  
import model.usuario;
import javax.servlet.RequestDispatcher;
import model.video;

/**
 *
 * @author Osmar
 */
@WebServlet("/video")
public class servletVideos extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
    //response.setContentType("text/html");  

    String id =request.getParameter("id");  
    String title =request.getParameter("title");  
    String author =request.getParameter("author");
    String creationdate =request.getParameter("creationdate");
    String reproductions =request.getParameter("reproductions");
    String description =request.getParameter("description");
    String format =request.getParameter("format");

    String[] strArray = new String[]{id, title, author, creationdate, reproductions, description, format};
    video.insert(strArray);  


}

}
