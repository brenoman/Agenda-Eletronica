package conexao;
import java.sql.*;

import sun.jdbc.odbc.JdbcOdbcDriver;


public class Conexao {
	// CRIA O DRIVER
	private Driver d;
	protected Statement stm;
	protected ResultSet rs;
	protected Connection con;
	/**
	 * @return Returns the con.
	 */
	public Connection getCon() {
		return con;
	}
	/**
	 * @param con The con to set.
	 */
	public void setCon(Connection con) {
		this.con = con;
	}
	// CRIA OS DADOS
	private String banco = "agenda";
	private String user = "root";
	private String password = "root";
	public Conexao() {
		d = new JdbcOdbcDriver();
		// REGISTRA O DRIVER
		try {
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			// CRIA A CONEXÃO
			con = DriverManager.getConnection(banco,user,password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
