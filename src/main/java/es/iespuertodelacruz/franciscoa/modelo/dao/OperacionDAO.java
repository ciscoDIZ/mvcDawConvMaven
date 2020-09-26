package es.iespuertodelacruz.franciscoa.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import es.iespuertodelacruz.franciscoa.modelo.Conexion;
import es.iespuertodelacruz.franciscoa.modelo.Operacion;

public class OperacionDAO extends Operacion implements DAO {

	public OperacionDAO() {
		super();
	}

	public OperacionDAO(Integer id, TipoOperacion tipoOperacion, Double cantidad, Double resultado) {
		super(id, tipoOperacion, cantidad, resultado);
	}

	private Connection conectar() throws Exception {
		Conexion conexion = Conexion.getConexion();
		Connection connection = conexion.getConnection();
		return connection;
	}
	
	@Override
	public Object get() {
		try {
			Connection conn = conectar();
			String query = "select * from "+Conexion.TOPERACIONES+" where "+Conexion.TOPERACIONES_ID_OPERACION+" = "+id;
			try(Statement st = conn.createStatement()){
				ResultSet resultSet = st.executeQuery(query);
				if(resultSet.next()) {
					setId(resultSet.getInt(0));
					setTipoOperacion(TipoOperacion.valueOf(TipoOperacion.class, resultSet.getString(1)));
					setCantidad(resultSet.getDouble(2));
					setResultado(resultSet.getDouble(3));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	@Override
	public void insert() {
		try {
			Connection conn = conectar();
			String query = "insert into "+Conexion.TOPERACIONES+" ("+Conexion.TOPERACIONES_OPERACION_TIPO+","+
					Conexion.TOPERACIONES_CANTIDAD+","+Conexion.TOPERACIONES_RESULTADO+") values (?,?,?)";
			try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
				preparedStatement.setString(1, tipoOperacion.toString());
				preparedStatement.setDouble(2, cantidad);
				preparedStatement.setDouble(3, resultado);
				preparedStatement.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void delete() {
		try {
			Connection conn = conectar();
			String query = "delete from "+Conexion.TOPERACIONES+" where "+Conexion.TOPERACIONES_ID_OPERACION+" = "+id;
			try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
				preparedStatement.execute();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
