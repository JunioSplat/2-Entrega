package usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Colors;

import connector.conector;

public class UsuarioDAO {

	private Connection conexao;

	public UsuarioDAO() {
		try {
			conexao = conector.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CREATE - Usuário
	public void criarUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuario(enderecoUsuario,nomeUsuario,emailUsuario,cepUsuario)" + " VALUES(?,?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, usuario.getEnderecoUsuario());
			stmt.setString(2, usuario.getNomeUsuario());
			stmt.setString(3, usuario.getEmailUsuario());
			stmt.setString(4, usuario.getCepUsuario());
			stmt.executeUpdate();
			System.out.println("Usuário criado com sucesso\n Nome: " + usuario.getNomeUsuario());
		} catch (Exception e) {
			System.out.println("Nao foi possivel criar o usuário." + e.getMessage());
		}
	}

	// READ - Usuário
	public void lerTodosUsuarios() {
		String sql = "SELECT * FROM usuario";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(r.getInt("idUsuario"));
				usuario.setEnderecoUsuario(r.getString("nomeUsuario"));
				usuario.setEmailUsuario(r.getString("emailUsuario"));
				usuario.setCepUsuario(r.getString("cepUsuario"));

				System.out.printf("ID: %s\n Nome: %s\n Email: %s\n senha: %s\n", usuario.getIdUsuario(),
						usuario.getEnderecoUsuario(), usuario.getEmailUsuario(), usuario.getCepUsuario());

			}
			if (!r.next()) {
				System.out.println("FIM DOS DADOS");
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel acessar as informacoes." + "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE usuario SET enderecoUsuario = ?, nomeUsuario = ?, emailUsuario= ?, cepUsuario= ? WHERE idUsuario = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, usuario.getEnderecoUsuario());
			stmt.setString(2, usuario.getNomeUsuario());
			stmt.setString(3, usuario.getEmailUsuario());
			stmt.setString(4, usuario.getCepUsuario());
			stmt.setInt(5, usuario.getIdUsuario());

			stmt.executeUpdate();
//			System.out.println(Colors.GREEN.get() + "Cliente atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
//					+ cliente.getNomeCliente() + "\nCPF: " + cliente.getCpfCliente());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteUsuario(int id) {
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	public Usuario buscarUsuario(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("idUsuario"));
				usuario.setEnderecoUsuario(resultado.getString("enderecoUsuario"));
				usuario.setNomeUsuario(resultado.getString("nomeUsuario"));
				usuario.setEmailUsuario(resultado.getString("emailUsuario"));
				usuario.setCepUsuario(resultado.getString("cepUsuario"));
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
