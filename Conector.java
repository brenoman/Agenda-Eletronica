import java.sql.*;


/**
 * Esta é uma classe auxiliar
 */
public class Conector {

	private static Connection connection;
	private static Statement statement;

	public static Statement reservaStatement() throws RepositorioException {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/siga", "root",
				"");
				System.out.println("conexao com sucesso");
				
			}
			catch (SQLException sqle) {
				System.out.println("SQLException => ConnectionManager: " +
						sqle.getMessage());
				throw new RepositorioException();
				
			}
			catch (ClassNotFoundException cnfe) {
				System.out.println("Driver nao encontrado => ConnectionManager: " +
						cnfe.getMessage());
				throw new RepositorioException();
			}
		}
		try {
			statement = connection.createStatement();
		}
		catch (SQLException sqle) {
			System.out.println("SQLException => ConnectionManager: " +
					sqle.getMessage());
		}
		return statement;
	}

	/**
	 * Atenção, este método fecha o Statement!
	 */
	public synchronized static void liberaStatement() {
		try {
			if (statement != null) {
				statement.close();
			}
		}
		catch (SQLException sqle) {
			System.out.println("Erro de BD => ConnectionManager" + sqle.getMessage());
		}
	}

	public static void liberaRecursos() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		catch (Exception ex) {}
		try {
			connection.close();
		}
		catch (Exception ex) {}
	}

	public static void iniciaTransacao() {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
			}
			catch (Exception ex) {

			}
		}
	}

	public static void confirmaTransacao() {
		if (connection != null) {
			try {
				connection.commit();
				connection.setAutoCommit(true);
			}
			catch (Exception ex) {
			}
		}
	}

	public static void cancelaTransacao() {
		if (connection != null) {
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			}
			catch (Exception ex) {
			}
		}
	}
}
