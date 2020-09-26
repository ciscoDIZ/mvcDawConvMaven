package es.iespuertodelacruz.franciscoa.controlador;

public class ConvCore {
	private Double cantidad;
	private final Double TIPO_CAMBIO;
	
	public ConvCore() {
		cantidad = 0.0;
		TIPO_CAMBIO = 1.19;
	}
	
	public ConvCore(Double tipoCambio) {
		super();
		TIPO_CAMBIO = tipoCambio;
	}

	public double convED() {
		return cantidad * TIPO_CAMBIO;
	}
	
	public double convDE() {
		return cantidad / TIPO_CAMBIO;
	}
	
	public Double getCantidad() {
		return cantidad;
	}

	public Double getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
