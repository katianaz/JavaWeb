/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author katia
 */
@WebServlet(name = "InformacoesServlet", urlPatterns = {"/Informacoes"})
public class InformacoesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">");
            out.println("<title>Informações SEPT</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>" + 
                    "<header class=\"d-flex flex-wrap justify-content-center\">" +
                    "<img class=\"center\" src=\"img/logoSEPT.png\" class=\"bi me-2\" width=\"120\" height=\"80\" alt=\"SEPT UFPR\"> \n" +
                    "<h1><font size='18' color='blue' face='Verdana'> SEPT - Setor de Educação Profissional e Tecnológica</font></h1>" +
                    "<p><font size='3' color='black' face='Arial'>Rua Dr. Alcides Vieira Arcoverde, 1225 CEP: 81520-260 - Jardim das Américas - Curitiba (PR) - Brasil</font></p>" +
                    "</header>");
              
            out.println("<table class=\"table\" style=\"width:800px\" align=\"center\">"
                    + "<thead class=\"thead-dark\" style=\"background-color: darkseagreen;\">");
            out.println("<tr>\n" +
                "    <th scope=\"col\">Curso</th>\n" +
                "    <th scope=\"col\">Página</th>\n" +
                "  </tr>" +
                "</thead>");
            
            out.println("<tr>\n" +
                "    <td>TPG - Petróleo e Gás</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/petroleogas/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n" +
                "  <tr>");
            
            out.println("<tr>\n" +
                "    <td>TACS - Agente Comunitário da Saúde</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/agentesaude/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");
            out.println("<tr>\n" +
                "    <td>TADS - Análise e Desenvolvimento de Sistemas</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/analisesistemas/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");
           out.println("<tr>\n" +
                "    <td>TCI - Comunicação Institucional</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/comunicacaoinstitucional/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");
            out.println("<tr>\n" +
                "    <td>TGQ - Gestão da Qualidade</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/gestaoqualidade/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");
            out.println("<tr>\n" +
                "    <td>TGP - Gestão Pública</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/gestaopublica/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");
            out.println("<tr>\n" +
                "    <td>TNI - Negócios Imobiliários</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/negociosimobiliarios/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");                
            out.println("<tr>\n" +
                "    <td>TCP - Produção Cênica</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/producaocenica/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n");    
            out.println("<tr>\n" +
                "    <td>TS - Secretariado</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/secretariado/sobre-o-curso/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n"); 
            out.println("<tr>\n" +
                "    <td>MBA em Mercado Imobiliário</td>\n" +
                "    <td><a href='http://www.sept.ufpr.br/portal/mbani/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n"); 
            out.println("<tr>\n" +
                "    <td>Especialização em Desenvolvimento Ágil de Software</td>\n" +
                "    <td><a href='https://das.ufpr.br/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n"); 
            out.println("<tr>\n" +
                "    <td>Especialização em Inteligência Artifical Aplicada</td>\n" +
                "    <td><a href='http://www.iaa.ufpr.br/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n"); 
            out.println("<tr>\n" +
                "    <td>Pós-Graduação em Bioinformática</td>\n" +
                "    <td><a href='http://www.bioinfo.ufpr.br/'>Sobre o Curso</a></td>\n" +
                "  </tr>\n"); 
            out.println("</table>"); 

            out.println("<div style=\"text-align: center\">" + 
                    "<br><a href='http://localhost:8080/Exercicio1/meuTads.jsp'>Meu TADS</a>" + 
                    "</div>"); 
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
