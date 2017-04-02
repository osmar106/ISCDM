package controller;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import model.usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/loginServlet")
public class servletRegistroUsu extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
    
  
//response.setContentType("text/html");  
          
    String name =request.getParameter("name");  
    String lastname =request.getParameter("lastname");  
    String email =request.getParameter("email");
    String user =request.getParameter("user");
    String password =request.getParameter("password");
    String repassword =request.getParameter("repassword");
    String message="";
    String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    if(!password.equals(repassword)){ 
        message = "ERROR: Las contraseñas no coinciden. Intente de nuevo";
    }

    //-->función añadida<--
    else if(name.isEmpty() || lastname.isEmpty() || email.isEmpty() || user.isEmpty() || password.isEmpty() || repassword.isEmpty()){
        message = "Por favor, completar el formulario antes de enviar.";
    }
    ////-->función añadida<--


    else if(usuario.checkIfUserExists(user)){
        message = "Este usuario ya se encuentra registrado.";
    }

    ////-->función añadida<--
    else if(email.matches(emailregex)==false){
        message = "Dirección de correo electrónico inválida.";   
    }
    ////-->función añadida<--

    else{
        String[] strArray = new String[]{name,lastname,email, user, password, repassword};
        usuario.insert(strArray);
        message = "El usuario fue registrado con éxito.";   
    }
    
    
    if(usuario.login(user, password)==true){
        request.getRequestDispatcher("/video.html").forward(request, response);        
    }
    else{
        message = "Usuario o contraseña incorrectos."; 
    }
    
    request.setAttribute("message", message);
    request.getRequestDispatcher("/registroRes.jsp").forward(request, response);


    
    
    
    }
  
}  