package Servlets;

import Model.Bean.Usuario;
import Model.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katia
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = null;
        try {
            usuarioDAO = new UsuarioDAO();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        usuario.setNome_usuario(request.getParameter("nome"));
        usuario.setLogin_usuario(request.getParameter("login"));
        usuario.setSenha_usuario(request.getParameter("senha"));
        
        try {
            usuarioDAO.save(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        out.println("<br><p>Usuário " + usuario.getNome_usuario() + " cadastrado com sucesso!</p><br>");            
        out.println("<a href=\"PortalServlet\">Portal</a>");      
       
        out.println("</header>");  
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");   
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
