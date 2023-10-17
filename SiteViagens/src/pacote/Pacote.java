package pacote;

import usuario.Usuario;

public class Pacote {

	private int idPacote;
	private double valor;
	private int diarias;
	private String destino;
	private Usuario usuario;

	public Pacote() {
		super();
	}

	public Pacote(int idPacote, double valor, int diarias, String destino, Usuario usuario) {
		super();
		this.idPacote = idPacote;
		this.valor = valor;
		this.diarias = diarias;
		this.destino = destino;
		this.usuario = usuario;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
