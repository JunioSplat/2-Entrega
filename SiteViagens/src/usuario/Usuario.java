package usuario;

public class Usuario {

	
	private int idUsuario;
	private String enderecoUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String cepUsuario;
	
	
	public Usuario() {
		super();
	}


	public Usuario(int idUsuario, String enderecoUsuario, String nomeUsuario, String emailUsuario, String cepUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.enderecoUsuario = enderecoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.cepUsuario = cepUsuario;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}


	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getEmailUsuario() {
		return emailUsuario;
	}


	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}


	public String getCepUsuario() {
		return cepUsuario;
	}


	public void setCepUsuario(String cepUsuario) {
		this.cepUsuario = cepUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", enderecoUsuario=" + enderecoUsuario + ", nomeUsuario="
				+ nomeUsuario + ", emailUsuario=" + emailUsuario + ", cepUsuario=" + cepUsuario + "]";
	}
	
	
	
}
