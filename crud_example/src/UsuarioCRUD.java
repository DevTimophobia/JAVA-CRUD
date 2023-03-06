import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCRUD {

    private static final String SELECT_ALL = "SELECT id, nombre, edad FROM usuarios";
    private static final String INSERT = "INSERT INTO usuarios (nombre, edad) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM usuarios WHERE id = ?";

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEdad(rs.getInt("edad"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario buscarPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(Conexion.JDBC_URL, Conexion.JDBC_USER, Conexion.JDBC_PASWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEdad(rs.getInt("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    

    public boolean guardar(Usuario usuario) {
        boolean resultado = false;
    
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            resultado = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return resultado;
    }
    
    public boolean actualizar(Usuario usuario) {
        boolean resultado = false;
    
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            stmt.setInt(3, usuario.getId());
            resultado = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public boolean eliminar(int id) {
        boolean resultado = false;
    
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            resultado = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return resultado;
    }
}