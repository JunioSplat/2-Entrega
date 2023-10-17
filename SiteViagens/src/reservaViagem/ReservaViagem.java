package reservaViagem;

import java.sql.Date;

import pacote.Pacote;
import usuario.Usuario;

public class ReservaViagem {

	private int idViagem;
	private Date dataIda;
	private Usuario usuario;
	private Pacote pacote;
	public ReservaViagem() {
		super();
	}
	public ReservaViagem(int idViagem, Date dataIda, Usuario usuario, Pacote pacote) {
		super();
		this.idViagem = idViagem;
		this.dataIda = dataIda;
		this.usuario = usuario;
		this.pacote = pacote;
	}
	public int getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(int idViagem) {
		this.idViagem= idViagem;
	}
	public Date getDataIda() {
		return dataIda;
	}
	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pacote getPacote() {
		return pacote;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	@Override
	public String toString() {
		return "ReservaViagem [idReserva=" + idViagem+ ", dataIda=" + dataIda + ", usuario=" + usuario + ", pacote="
				+ pacote + "]";
	}



}
