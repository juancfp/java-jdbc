import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
//		ConnectionFactory factory = new ConnectionFactory();
//		Connection con = factory.createConnection();
//		
//		Statement stm = con.createStatement();

//		retorna um bool (só é true qnd resultado é lista)
//		insert nunca é true
//		precisa colocar no execute para retornar algo
		
		
//		show all
//		stm.execute("SELECT * FROM contas");

//		ResultSet result = stm.getResultSet();
//		print(result);
		
		
//		------------------
//		insert something while returning generated keys
//		stm.execute("INSERT INTO contas (NumConta, NumAgencia, Saldo, ReceitaMes, DespesasMes) VALUES (50, 2, 200, 800, 20)", Statement.RETURN_GENERATED_KEYS);
//		
//		
//		ResultSet result = stm.getGeneratedKeys();
//		
//		result.next();
//		System.out.println(result.getInt(1));


//		-----------------
		
//		removendo dados
		
//		stm.execute("DELETE FROM contas WHERE id > 1");
//		Integer qndRemovida = stm.getUpdateCount(); // quantos foram removidos?
//		System.out.println(qndRemovida);
		
		
//		========================
//		transações
		ConnectionFactory factory = new ConnectionFactory();
		// criou pool com determinado num de conexões
		try(Connection con = factory.createConnection()
				){
			try (PreparedStatement stm = con.prepareStatement(
					"INSERT INTO contas (NumConta, NumAgencia, Saldo, ReceitaMes, DespesasMes)"+
					" VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
				stm.setInt(1, 60);
				stm.setInt(2, 50);
				stm.setInt(3, 40);
				stm.setInt(4, 30);
				stm.setInt(5, 20);
				stm.execute();
				
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			} // stm close
				
		} // connection close
		
		
		
		
//		stm.execute(); // para prepared statements não precisa colocar parâmetros
		
		
//		con.close(); // fechar conexão

	}

	private static void print(ResultSet result) throws SQLException {
		while(result.next()) {
			Integer id = result.getInt(1);
			System.out.println(id);
		}
	}

}
