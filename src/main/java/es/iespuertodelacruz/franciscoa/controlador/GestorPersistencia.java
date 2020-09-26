package es.iespuertodelacruz.franciscoa.controlador;

import es.iespuertodelacruz.franciscoa.modelo.Conexion;
import es.iespuertodelacruz.franciscoa.modelo.Operacion;
import es.iespuertodelacruz.franciscoa.modelo.Operacion.TipoOperacion;
import es.iespuertodelacruz.franciscoa.modelo.dao.OperacionDAO;

public class GestorPersistencia {
	private static OperacionDAO operacion;
	
	public GestorPersistencia() {
		try {
			Conexion.setNewConexion("historial.db");
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	public static Operacion get(int id) {
		if (operacion != null) {
			operacion = null;
		}
		operacion = new OperacionDAO(id, null, null, null);
		return (OperacionDAO) operacion.get();
	}

	public static void insert(TipoOperacion tipoOperacion, Double cantidad, Double resultado) {
		if (operacion != null) {
			operacion = null;
		}
		operacion = new OperacionDAO(null, tipoOperacion, cantidad, resultado);
		operacion.insert();
	}

	public static void delete(int id) {
		if (operacion != null) {
			operacion = null;
		}
		operacion = new OperacionDAO(id, null, null, null);
		operacion.delete();
	}
}
