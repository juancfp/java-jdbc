import java.sql.Connection;
import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		
		for(int i=0; i < 20; i++) {
			Connection con = factory.createConnection();
			System.out.println(i);
			con.close();
		}
	}
}
