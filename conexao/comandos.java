package conexao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class comandos extends Conexao {
	public comandos(String sql) {
		try {
			con = DriverManager.getConnection("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stm = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs = stm.executeQuery(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		rs = stm.executeQuery(sql);
	}
	public void adicionar() {
		String sql = "INSERT INTO tb_agenda";
		comandos(sql);
	
	}
	
}
