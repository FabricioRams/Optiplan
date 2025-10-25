package Negocio;
import Util.ConexionBD;
import Entidades.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaNegocio {
    public List<Categoria> obtenerCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT CategoriaID, Nombre FROM Categorias";

        try (Connection conn = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setCategoriaID(rs.getInt("CategoriaID"));
            cat.setNombre(rs.getString("Nombre"));
            lista.add(cat);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
    }
}
