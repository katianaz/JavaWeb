package Servlets;

import Connection.ConnectionFactory;
import Model.Bean.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katia
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
                  
        List<Usuario> usuarios = new ArrayList<Usuario>();
            
        String sql = "SELECT * FROM tb_usuario";
            
        Connection con = ConnectionFactory.getConnection();
            
        try {
            Statement stmt = con.createStatement();
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();        
            while (rs.next()){
              Usuario usuario = new Usuario();
              usuario.setLogin_usuario(rs.getString("login_usuario"));
              usuario.setSenha_usuario(rs.getString("senha_usuario"));
              usuario.setNome_usuario(rs.getString("nome_usuario"));
              usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session = request.getSession();
            Usuario usuarioSession = (Usuario)session.getAttribute("usuario");
                   
            if (usuarioSession.getNome_usuario() == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
            
                request.setAttribute("msg", "Usuário não está logado.");

                request.setAttribute("page", "index.html");
                rd.forward(request, response);
            }else{  
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Portal</title>");   
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
                out.println("</head>");
                out.println("<body>");

                out.println("<div class='container'>");
                out.print("<br>");
                out.println("<div class=\"d-flex flex-wrap justify-content-center\">" +
                        "<form action=\"CadastrarUsuarioServlet\" method=\"post\"> \n" +
                        "Nome: <input class=\"form-control\" type=\"text\" name=\"nome\" value=\"\" required /> <br/>\n" +       
                        "Login: <input class=\"form-control\" type=\"text\" name=\"login\" value=\"\" required /> <br/>\n" +
                        "Senha: <input class=\"form-control\" type=\"password\" name=\"senha\" value=\"\"  autocomplete=\"current-password\" required/> <br/>\n" +
                        "<input class=\"btn btn-primary\" type =\"submit\" value=\"Salvar\">" +
                        "</form>" +
                        "</div>" + 
                        "<br>");

                out.println("<table class=\"table\" style=\"width:800px\" align=\"center\">"
                        + "<thead class=\"thead-dark\" style=\"background-color: darkseagreen;\">");
                out.println("<tr>\n" +
                    "    <th scope=\"col\">Nome</th>\n" +
                    "    <th scope=\"col\">Login</th>\n" +
                    "    <th scope=\"col\">Senha</th>\n" +
                    "  </tr>" +
                    "</thead>");
                for(Usuario usuario : usuarios){
                    out.println("<tbody>");
                    out.println("<tr>");
                        out.println("<td>");
                            out.println(usuario.getNome_usuario());
                        out.println("</td>");

                        out.println("<td>");
                            out.println(usuario.getLogin_usuario());
                        out.println("</td>");

                        out.println("<td>");
                            out.println(usuario.getSenha_usuario());
                        out.println("</td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                }              
                out.println("</table>");

                out.println("<div class=\"d-flex flex-wrap justify-content-center\">");            
                out.println("<a href=\"LogoutServlet\">Logout</a>");
                out.println("</div>");

                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PortalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PortalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
