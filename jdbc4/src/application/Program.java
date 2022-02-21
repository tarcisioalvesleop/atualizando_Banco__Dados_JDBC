package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			//atualizando os dados (codigo MYSQL)
			st = conn.prepareStatement(
					"UPDATE seller SET BaseSalary = BaseSalary + ? " 
					+ "WHERE " 
					+ "(DepartmentId = ?)");
			//atribuindo o valores desejados para atualização
			st.setDouble(1, 200.0);//valor
			st.setInt(2, 2);//department 2
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {//fechando conexão e statement
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
