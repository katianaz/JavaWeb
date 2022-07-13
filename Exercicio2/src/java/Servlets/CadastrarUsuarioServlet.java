/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;

/**
 *
 * @author katia
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();         
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cadastrar Usuario</title>");  
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='container'>" + 
                    "<header class=\"text-center\">"); 
        out.println("<br><p>Usuário " + usuario.getNome() + " cadastrado com sucesso!</p><br>");            
        out.println("<a href=\"PortalServlet\">Portal</a>");      
       
        out.println("</header>");  
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
