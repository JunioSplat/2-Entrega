package connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conector {

	private static final String URL = "jdbc:mysql://localhost:3306/siteviagens";

	private static final String USUARIO = "root";

	private static final String SENHA = "5864";

	public static Connection conectar() throws SQLException {

		return DriverManager.getConnection(URL, USUARIO, SENHA);

	}

	public static PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
