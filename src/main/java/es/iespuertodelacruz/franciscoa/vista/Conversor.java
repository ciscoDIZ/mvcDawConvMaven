package es.iespuertodelacruz.franciscoa.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.franciscoa.controlador.ConvCore;
import es.iespuertodelacruz.franciscoa.controlador.GestorPersistencia;
import es.iespuertodelacruz.franciscoa.modelo.Operacion.TipoOperacion;

public class Conversor {
	// mensajes de sistema
	public static final String MSG_SALUDO = "Hola encantado de verte por aqui!";
	public static final String MSG_DESEDIDA = "Espero volver a verte pronto!";
	public static final String MSG_MENU = "E) convertir Euro a Dólar\nD) convertir Dólar a Euro\nO) mostrar estas opciones\nS) salir";
	public static final String MSG_CANTIDAD = "Por favor, Introducir cantidad.";
	// atributos de clase
	private static ConvCore convCore = new ConvCore();
	private static Scanner sc = new Scanner(System.in);
	public static void ini() {
		new GestorPersistencia();
		System.out.println(MSG_SALUDO);
		construirMenu();
		System.out.println(MSG_DESEDIDA);
	}
	
	private static void introducirCantidad() throws InputMismatchException {
		System.out.println(MSG_CANTIDAD);
		double cantidad = sc.nextDouble();
		sc.nextLine();
		convCore.setCantidad(cantidad);
	}

	private static void construirMenu() {
		System.out.println(MSG_MENU);
		boolean salir = false;
		double resultado;
		while (!salir) {
			char opt = sc.nextLine().toLowerCase().charAt(0);
			switch (opt) {
			case 'e':
				introducirCantidad();
				resultado = convCore.convED();
				GestorPersistencia.insert(TipoOperacion.ED, convCore.getCantidad(), resultado);
				System.out.println(resultado);
				break;
			case 'd':
				introducirCantidad();
				resultado = convCore.convDE();
				GestorPersistencia.insert(TipoOperacion.DE, convCore.getCantidad(), resultado);
				System.out.println(resultado);
				break;
			case 'o':
				System.out.println(MSG_MENU);
				break;
			case 's':
				salir = true;
				break;
			default:
				break;
			}
		}
	}
}
