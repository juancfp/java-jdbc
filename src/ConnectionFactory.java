import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource ;
	
	public ConnectionFactory() {
		// data source é uma interface que implementa o pool
		ComboPooledDataSource comboPolledDataSource = new ComboPooledDataSource();
		comboPolledDataSource.setJdbcUrl("jdbc:mysql://localhost/financas");
		comboPolledDataSource.setUser("root");
		comboPolledDataSource.setPassword("28552855");
		
		comboPolledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPolledDataSource;
	}
	public Connection createConnection() throws SQLException{
		
		return this.dataSource.getConnection();
		// sempre que uma conexão for requisitada, não vai precisar ir no bd
		// já vai ter conexão aberta 
		
	}
}
