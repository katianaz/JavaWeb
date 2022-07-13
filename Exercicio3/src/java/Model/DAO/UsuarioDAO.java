package Model.DAO;

import Connection.ConnectionFactory;
import Model.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author katia
 */
public class UsuarioDAO {
    private Connection con = null;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }
    
    /*
    public void create(Usuario u) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tb_usuario(login_usuario, senha_usuario, nome_usuario) VALUES(?,?,?)");
            stmt.setString(1, u.getLogin_usuario());
            stmt.setString(2, u.getSenha_usuario());
            stmt.setString(3, u.getNome_usuario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }  catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    */
    public boolean save(Usuario usuario) throws SQLException{
        
        String sql = "INSERT into tb_usuario (login_usuario, senha_usuario, nome_usuario) "
                + "VALUES ('" + usuario.getLogin_usuario() + "', '" + usuario.getSenha_usuario() + "', '"+ usuario.getNome_usuario() + "')";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
}
