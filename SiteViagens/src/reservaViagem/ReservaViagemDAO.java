package reservaViagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import connector.conector;
import pacote.Pacote;
import pacote.PacoteDAO;
import usuario.Usuario;
import usuario.UsuarioDAO;
import utils.Colors;

public class ReservaViagemDAO {

	private Connection conexao;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	PacoteDAO pacoteDAO = new PacoteDAO();

	public ReservaViagemDAO() {
		try {
			conexao = conector.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CREATE - Pacote
	public void criarReserva(ReservaViagem reservaViagem) {

		String sql = "INSERT INTO reservaviagem (dataIda,idPacote,idUsuario)" + " VALUES(?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDate(1, new Date(reservaViagem.getDataIda().getTime()));
			stmt.setInt(2, reservaViagem.getPacote().getIdPacote());
			stmt.setInt(3, reservaViagem.getUsuario().getIdUsuario());
			stmt.executeUpdate();
			System.out.println((Colors.GREEN.get() + "Reserva de viagem registrada com sucesso" + Colors.RESET.get()));
		} catch (Exception e) {
			System.out.println(
					(Colors.RED.get() + "Nao foi possivel reservar a viagem!!" + e.getMessage() + Colors.RESET.get()));
		}
	}

	// READ - Usuário
	public void lerReservas() {
		String sql = "SELECT * FROM reservaviagem";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				ReservaViagem reservaViagem = new ReservaViagem();
				reservaViagem.setIdViagem(r.getInt("idViagem"));
				reservaViagem.setDataIda(r.getDate("DataIda"));

				Pacote pacote = new Pacote();
				pacote.setIdPacote(r.getInt("IdPacote"));
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("idUsuario"));

				System.out.printf("ID Reserva: %s \nPara o cliente de ID: %s está marcada para:\nData: %s\n",
						reservaViagem.getIdViagem(), usuario.getIdUsuario(), reservaViagem.getDataIda());

			}
			if (!r.next()) {
				System.out.println("FIM DOS DADOS");
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel acessar as informacoes." + "\n Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updateReserva(ReservaViagem reservaViagem) {
		String sql = "UPDATE reservaviagem SET dataIda= ? WHERE idViagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDate(1, new Date(reservaViagem.getDataIda().getTime()));
			stmt.setInt(2, reservaViagem.getIdViagem());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Data atualizada!!\n" + Colors.RESET.get());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o pacote." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteReservaViagem(int id) {
		String sql = "DELETE FROM reservaviagem WHERE idViagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Reserva deletada com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar a reserva." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

}
