package es.iespuertodelacruz.franciscoa.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//tablas
	public static final String TOPERACIONES = "operaciones";
	//registros
	public static final String TOPERACIONES_ID_OPERACION = "id_operacion";
	public static final String TOPERACIONES_OPERACION_TIPO = "operacionTipo";
	public static final String TOPERACIONES_CANTIDAD = "cantidad";
	public static final String TOPERACIONES_RESULTADO = "resultado";
	//parámetros de conexion
	private String jdbcUrl;
	//atributos de clase
	private Connection connection;
	private static Conexion conexion;
	
	private Conexion(String db) throws SQLException {
		jdbcUrl = "jdbc:sqlite:src/main/resources/db/"+db;
		cargarDriverSqlite();
		sqlite();
	}
	
	public static Conexion getConexion() throws Exception {
		if(conexion == null) {
			throw new Exception("no se ha creado conexión");
		}else {
			return conexion;
		}
	}
	
	public static Conexion setNewConexion(String db) throws Exception{
		if(conexion != null) {
			if(conexion.getConnection() != null && !conexion.getConnection().isClosed()) {
				conexion.getConnection().close();
			}
		}
		conexion = new Conexion(db);
		return conexion;
	}

	public static void cargarDriverSqlite() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("no conecta tronco!!: "+e);
			System.exit(1);
		}
	}
	
	private Connection sqlite() throws SQLException {
		return sqlite(jdbcUrl);
	}
	
	private Connection sqlite(String url) throws SQLException {
		setConnection(null);
		if(jdbcUrl != null && !url.isEmpty()) {
			jdbcUrl = url;
		}
		Connection c = DriverManager.getConnection(jdbcUrl);
		setConnection(c);
		return connection;
	}
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}
