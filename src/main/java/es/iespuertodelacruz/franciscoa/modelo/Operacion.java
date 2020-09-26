package es.iespuertodelacruz.franciscoa.modelo;

public abstract class Operacion {
	public enum TipoOperacion{
		ED,
		DE
	}
	protected Integer id;
	protected TipoOperacion tipoOperacion;
	protected Double cantidad;
	protected Double resultado;
	public Operacion(Integer id, TipoOperacion tipoOperacion, Double cantidad, Double resultado) {
		super();
		this.id = id;
		this.tipoOperacion = tipoOperacion;
		this.cantidad = cantidad;
		this.resultado = resultado;
	}
	
	public Operacion() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
}
