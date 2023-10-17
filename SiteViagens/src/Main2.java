import usuario.Usuario;
import usuario.UsuarioDAO;
import java.sql.Date;
import java.util.Scanner;
import pacote.Pacote;
import pacote.PacoteDAO;
import reservaViagem.ReservaViagem;
import reservaViagem.ReservaViagemDAO;

public class Main2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha;

		// MENU PRINCIPAL
		do {
			System.out.println("\r\n" + "  __  __                  \r\n" + " |  \\/  | ___ _ __  _   _ \r\n"
					+ " | |\\/| |/ _ \\ '_ \\| | | |\r\n" + " | |  | |  __/ | | | |_| |\r\n"
					+ " |_|  |_|\\___|_| |_|\\__,_|\r\n" + "                          \r\n" + "");
			
			System.out.println(".________ Menu Criar ________.");
			System.out.println("| 1 - Criar                  |");
			System.out.println("| 2 - Visualizar             |");
			System.out.println("| 3 - Editar                 |");
			System.out.println("| 4 - Excluir                |");
			System.out.println("| 5 - Sair                   |");
			System.out.println("|____________________________|");
			System.out.print("          Escolha uma opção: ");
			
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				System.out.println("Você escolheu a opção CRIAR");
				break;
			case 2:
				System.out.println("Você escolheu a opção VISUALIZAR");
				break;
			case 3:
				System.out.println("Você escolheu a opção EDITAR");
				break;
			case 4:
				System.out.println("Você escolheu a opção EXCLUIR");
				break;
			case 5:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

			// SubMenu Criar
			if (escolha == 1) {
				int escolhaSubmenu;
				do {
					System.out.println(".________ Menu Criar ________.");
					System.out.println("| 1 - Criar usuário          |");
					System.out.println("| 2 - Criar pacote           |");
					System.out.println("| 3 - Criar reserva          |");
					System.out.println("| 4 - Voltar ao Menu         |");
					System.out.println("|____________________________|");
					System.out.print("          Escolha uma opção: ");
					escolhaSubmenu = scanner.nextInt();

					switch (escolhaSubmenu) {
					case 1:
						scanner.nextLine();
						Usuario usuario = new Usuario();
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						System.out.println("Endereço: ");
						usuario.setEnderecoUsuario(scanner.nextLine());
						System.out.println("Nome Completo: ");
						usuario.setNomeUsuario(scanner.nextLine());
						System.out.println("Email: ");
						usuario.setEmailUsuario(scanner.nextLine());
						System.out.println("CPF: ");
						usuario.setCepUsuario(scanner.nextLine());
						usuarioDAO.criarUsuario(usuario);
						break;
					case 2:
						scanner.nextLine();
						Pacote pacote = new Pacote();
						UsuarioDAO usuarioDAO2 = new UsuarioDAO();
						PacoteDAO pacoteDAO = new PacoteDAO();
						System.out.println("Valor: ");
						pacote.setValor(scanner.nextDouble());
						System.out.println("Diarias: ");
						pacote.setDiarias(scanner.nextInt());
						System.out.println("ID do usuário: ");
						int idUsuario = scanner.nextInt();
						System.out.println("Destino: ");
						pacote.setDestino(scanner.next());

						Usuario usuariob = usuarioDAO2.buscarUsuario(idUsuario);
						if (usuariob != null) {
							pacote.setUsuario(usuariob);
						} else {
							System.out.println("Usuário não encontrado.");
						}
						pacoteDAO.criarPacote(pacote);
						break;
					case 3:
						scanner.nextLine();
						ReservaViagem reservaViagem = new ReservaViagem();
						ReservaViagemDAO reservaDAO = new ReservaViagemDAO();
						UsuarioDAO usuarioDAO3 = new UsuarioDAO();
						PacoteDAO pacoteDAO2 = new PacoteDAO();
						System.out.println("Preencha a data da viagem:");
						System.out.println("Dia: ");
						int diai = scanner.nextInt();
						System.out.println("Mês: ");
						int mesi = scanner.nextInt();
						System.out.println("Ano: ");
						int anoi = scanner.nextInt();
						reservaViagem.setDataIda(new Date(anoi - 1900, mesi - 1, diai));
						System.out.println("ID do usuário: ");
						int idUsuario5 = scanner.nextInt();
						Usuario usuario1 = usuarioDAO3.buscarUsuario(idUsuario5);
						if (usuario1 != null) {
							reservaViagem.setUsuario(usuario1);
						} else {
							System.out.println("Usuário não encontrado.");
						}
						System.out.println("ID da pacote: ");
						int idPacote = scanner.nextInt();
						Pacote pacoteb = pacoteDAO2.buscarPacote(idPacote);
						if (pacoteb != null) {
							reservaViagem.setPacote(pacoteb);
						} else {
							System.out.println("Pacote não encontrado.");
						}
						reservaDAO.criarReserva(reservaViagem);
						break;
					case 4:
						System.out.println("Voltando ao Menu Principal.");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
				} while (escolhaSubmenu != 4);
			}

			// MENU VIZUALIZAÇÃO
			if (escolha == 2) {
				int escolhaSubmenuv;
				do {
					System.out.println(".________ Menu Visualizar ________.");
					System.out.println("| 1 - Visualizar usuário          |");
					System.out.println("| 2 - Visualizar pacote           |");
					System.out.println("| 3 - Visualizar reserva          |");
					System.out.println("| 4 - Voltar ao Menu              |");
					System.out.println("|_________________________________|");
					System.out.print("          Escolha uma opção: ");
					escolhaSubmenuv = scanner.nextInt();
					switch (escolhaSubmenuv) {
					case 1:
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						usuarioDAO.lerTodosUsuarios();
						break;
					case 2:
						PacoteDAO pacoteDAO = new PacoteDAO();
						pacoteDAO.lerPacotes();
						break;
					case 3:
						ReservaViagemDAO reservaDAO = new ReservaViagemDAO();
						reservaDAO.lerReservas();
						break;
					case 4:
						System.out.println("Voltando ao Menu Principal.");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
				} while (escolhaSubmenuv != 4);
				// FIM DO MENU DE VISUALIZAÇÃO
			}
			if (escolha == 3) {
				int escolhaSubmenue;
				do {
					System.out.println(".________ Menu Editar ________.");
					System.out.println("| 1 - Editar usuário          |");
					System.out.println("| 2 - Editar pacote           |");
					System.out.println("| 3 - Editar reserva          |");
					System.out.println("| 4 - Voltar ao Menu          |");
					System.out.println("|_____________________________|");
					System.out.print("        Escolha uma opção: ");

					escolhaSubmenue = scanner.nextInt();
					switch (escolhaSubmenue) {
					case 1:
						scanner.nextLine();
						Usuario usuario = new Usuario();
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						System.out.println("Endereço: ");
						usuario.setEnderecoUsuario(scanner.nextLine());
						System.out.println("Nome: ");
						usuario.setNomeUsuario(scanner.nextLine());
						System.out.println("Email: ");
						usuario.setEmailUsuario(scanner.nextLine());
						System.out.println("CEP: ");
						usuario.setCepUsuario(scanner.nextLine());
						System.out.println("ID Usuário:");
						usuario.setIdUsuario(scanner.nextInt());
						usuarioDAO.atualizarUsuario(usuario);
						break;
					case 2:
						scanner.nextLine();
						Pacote pacote = new Pacote();
						UsuarioDAO usuarioDAO2 = new UsuarioDAO();
						PacoteDAO pacoteDAO = new PacoteDAO();
						System.out.println("Valor: ");
						pacote.setValor(scanner.nextDouble());
						System.out.println("Diarias: ");
						pacote.setDiarias(scanner.nextInt());
						System.out.println("Destino: ");
						pacote.setDestino(scanner.next());
						System.out.println("ID do usuário: ");
						int idUsuario = scanner.nextInt();
						Usuario usuariob = usuarioDAO2.buscarUsuario(idUsuario);
						if (usuariob != null) {
							pacote.setUsuario(usuariob);
						} else {
							System.out.println("Usuário não encontrado.");
						}
						System.out.println("ID Pacote:");
						pacote.setIdPacote(scanner.nextInt());
						pacoteDAO.updatePacote(pacote);
						break;
					case 3:
						scanner.nextLine();
						ReservaViagem reservaViagem = new ReservaViagem();
						ReservaViagemDAO reservaViagemDAO = new ReservaViagemDAO();
						UsuarioDAO usuarioDAO3 = new UsuarioDAO();
						PacoteDAO pacoteDAO3 = new PacoteDAO();

						System.out.println("Alterar a data da viagem:");
						System.out.println("Dia: ");
						int diai = scanner.nextInt();
						System.out.println("Mês: ");
						int mesi = scanner.nextInt();
						System.out.println("Ano: ");
						int anoi = scanner.nextInt();
						reservaViagem.setDataIda(new Date(anoi - 1900, mesi - 1, diai));
						System.out.println("ID do usuário: ");
						int idUsuarior = scanner.nextInt();
						Usuario usuario2 = usuarioDAO3.buscarUsuario(idUsuarior);
						if (usuario2 != null) {
							reservaViagem.setUsuario(usuario2);
						} else {
							System.out.println("Usuário não encontrado.");
						}
						System.out.println("ID do pacote: ");
						int idPacote = scanner.nextInt();
						Pacote pacoteb = pacoteDAO3.buscarPacote(idPacote);
						if (pacoteb != null) {
							reservaViagem.setPacote(pacoteb);
						} else {
							System.out.println("Usuário não encontrado.");
						}
						System.out.println("ID reserva:");
						reservaViagem.setIdViagem(scanner.nextInt());
						reservaViagemDAO.updateReserva(reservaViagem);
					case 4:
						System.out.println("Voltando ao Menu.");
						break;
					default:
						System.out.println("Opção inexistente!");
						break;
					}
				} while (escolhaSubmenue != 4); // FIM DO SUBMENU EDITAR
			}

			// Submenu Deletar
			if (escolha == 4) {
				int escolhaSubmenuD;
				do {

					System.out.println(".________ Menu Deletar ________.");
					System.out.println("| 1 - Deletar usuário          |");
					System.out.println("| 2 - Deletar pacote           |");
					System.out.println("| 3 - Deletar reserva          |");
					System.out.println("| 4 - Voltar ao Menu           |");
					System.out.println("|______________________________|");
					System.out.print("          Escolha uma opção: ");

					escolhaSubmenuD = scanner.nextInt();
					switch (escolhaSubmenuD) {
					case 1:
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						System.out.println("Digite o ID do Usuário a ser DELETADO");
						int idUsuario = scanner.nextInt();
						usuarioDAO.deleteUsuario(idUsuario);
						break;
					case 2:
						PacoteDAO pacoteDAO = new PacoteDAO();
						System.out.println("Digite o ID do Pacote a ser DELETADO");
						int idPacote = scanner.nextInt();
						pacoteDAO.deletePacote(idPacote);
						break;
					case 3:
						ReservaViagemDAO reservaViagemDAO = new ReservaViagemDAO();
						System.out.println("Digite o ID da Reserva a ser DELETADO");
						int idreserva = scanner.nextInt();
						reservaViagemDAO.deleteReservaViagem(idreserva);
						break;
					case 4:
						System.out.println("Voltando ao Menu.");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
				} while (escolhaSubmenuD != 4); // FIM DO SUBMENU EXCLUIR
			}

		} while (escolha != 5);

		scanner.close();

	}
}
