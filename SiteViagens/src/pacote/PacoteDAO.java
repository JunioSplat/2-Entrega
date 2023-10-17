package pacote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connector.conector;
import usuario.Usuario;
import usuario.UsuarioDAO;
import utils.Colors;

public class PacoteDAO {

	private Connection conexao;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public PacoteDAO() {
		try {
			conexao = conector.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CREATE - Pacote
	public void criarPacote(Pacote pacote) {

		String sql = "INSERT INTO pacote(valor,diarias,destino,idUsuario)" + " VALUES(?,?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDouble(1, pacote.getValor());
			stmt.setInt(2, pacote.getDiarias());
			stmt.setString(3, pacote.getDestino());
			stmt.setInt(4, pacote.getUsuario().getIdUsuario());
			stmt.executeUpdate();
			System.out.println((Colors.GREEN.get() + "Pacote registrado com sucesso\n Dias: " + pacote.getDiarias()
					+ Colors.RESET.get()));
		} catch (Exception e) {
			System.out.println((Colors.RED.get() + "Nao foi possivel incluir o pacote no sistema." + e.getMessage()
					+ Colors.RESET.get()));
		}
	}

	// READ - Usuário
	public void lerPacotes() {
		String sql = "SELECT * FROM pacote";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Pacote pacote = new Pacote();
				pacote.setIdPacote(r.getInt("idPacote"));
				pacote.setValor(r.getDouble("valor"));
				pacote.setDiarias(r.getInt("diarias"));
				pacote.setDestino(r.getString("destino"));
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("idUsuario"));

				System.out.printf("ID Pacote: %s\n ID Usuário: %s\n Valor: %s\n Diarias: %s\n Destino: %s\n",
						pacote.getIdPacote(), usuario.getIdUsuario(), pacote.getValor(), pacote.getDiarias(),
						pacote.getDestino());

			}
			if (!r.next()) {
				System.out.println("FIM DOS DADOS");
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel acessar as informacoes." + "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updatePacote(Pacote pacote) {
		String sql = "UPDATE pacote SET valor = ?, diarias = ?, destino= ?, idUsuario= ? WHERE idPacote = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDouble(1, pacote.getValor());
			stmt.setInt(2, pacote.getDiarias());
			stmt.setString(3, pacote.getDestino());
			stmt.setInt(4, pacote.getUsuario().getIdUsuario());
			stmt.setInt(5, pacote.getIdPacote());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Pacote atualizado!!\n" + Colors.RESET.get() + "Valor: "
					+ pacote.getValor() + "\nDiarias: " + pacote.getDiarias() + "\nDestino:" + pacote.getDestino());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o pacote." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deletePacote(int id) {
		String sql = "DELETE FROM pacote WHERE idPacote = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Pacote deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o pacote." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	public Pacote buscarPacote(int id) {
		Pacote pacote = null;
		String sql = "SELECT * FROM pacote WHERE idPacote = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				pacote = new Pacote();
				pacote.setIdPacote(resultado.getInt("idPacote"));
				pacote.setValor(resultado.getDouble("valor"));
				pacote.setDiarias(resultado.getInt("diarias"));
				pacote.setDestino(resultado.getString("destino"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacote;
	}
}
