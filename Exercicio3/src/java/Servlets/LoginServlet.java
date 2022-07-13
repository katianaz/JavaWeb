package Servlets;

import Connection.ConnectionFactory;
import Model.Bean.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katia
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try {
            
            Usuario usuario = new Usuario();
            
            String sql = "SELECT * FROM tb_usuario WHERE login_usuario = '" + request.getParameter("login") + "' and senha_usuario = '" + request.getParameter("senha") + "'";
            
            Connection con = ConnectionFactory.getConnection();;
            try {
                con = ConnectionFactory.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                Statement stmt = con.createStatement();
                stmt.executeQuery(sql);
                ResultSet rs = stmt.getResultSet();
                while (rs.next()){
                    usuario.setLogin_usuario(rs.getString("login_usuario"));
                    usuario.setSenha_usuario(rs.getString("senha_usuario"));
                    usuario.setNome_usuario(rs.getString("nome_usuario"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=UTF-8"); 
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>" +
                    "<header class=\"text-center\">");
                        
            if (usuario.getNome_usuario() != null){
                session.setAttribute("usuario", usuario);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalServlet");
                rd.include(request, response);                
            } 
            else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
                request.setAttribute("msg", "Usuário/senha não encontrado");
                request.setAttribute("page", "index.html");
                rd.forward(request, response);
            }
            
            out.println("</header>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
