import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Ignacio de Lucas Noguero
 * @author Hugo Fernandez Visier
 *
 */
public class Fichero {
	private static int numPasteleros;
	private static int numPasteles;
	private static int[][] pastelero_pastel;
	private static int[] pedido;

	/**
	 * Este metodo es el encargado de leer un fichero de texto y almacenarlo en
	 * las variables de clase para poderlas utilizar mas adelante en nuestro
	 * programa
	 * 
	 * @param ficheroEntrada
	 *            el nombre del fichero de entrada
	 * @throws FileNotFoundException
	 *             si el fichero no existe lanza una excepcion
	 * @throws IOException
	 *             Excepcion general en fallo de lectura de fichero
	 */
	public static void leerFichero(String ficheroEntrada) throws FileNotFoundException, IOException {
		FileReader f;
		f = new FileReader(ficheroEntrada);
		BufferedReader b = new BufferedReader(f);
		String linea;
		linea = b.readLine();
		String[] datosNum = linea.split(" ");
		numPasteleros = Integer.parseInt(datosNum[0]);
		numPasteles = Integer.parseInt(datosNum[1]);
		pastelero_pastel = new int[numPasteleros][numPasteles];
		pedido = new int[numPasteleros];
		int[][] coste = new int[numPasteleros][numPasteles];
		for (int i = 0; i < numPasteleros; i++) {
			linea = b.readLine();
			String[] datosMatriz = linea.split("\\s+");
			for (int j = 0; j < numPasteles; j++)
				pastelero_pastel[i][j] = Integer.parseInt(datosMatriz[j]);
		}
		linea = b.readLine();
		String[] datosPedido = linea.split("\\s+");
		for (int i = 0; i < datosPedido.length; i++)
			pedido[i] = Integer.parseInt(datosPedido[i]);
		for (int i = 0; i < numPasteleros; i++)
			for (int j = 0; j < numPasteles; j++)
				coste[i][j] = pastelero_pastel[i][pedido[j] - 1];
		b.close();
	}

	/**
	 * metodo encargado de escribir la solucion que le pasamos al fichero de
	 * salida. este metodo comprueba que el fichero no exista anteriormente, si
	 * ya existe, mostrara un mensaje de error
	 * 
	 * @param solucion
	 *            el objeto tipo Nodo para escribir los pasteleros asignados y
	 *            el beneficio actual
	 * @param nombreFicheroSalida
	 *            el nombre del fichero de salida
	 */
	public static void escribirFichero(Nodo solucion, String nombreFicheroSalida) {
		try {
			if (!ficheroExiste(nombreFicheroSalida)) {
				PrintWriter aux = new PrintWriter(new BufferedWriter(new FileWriter(nombreFicheroSalida)));
				for (int pastelero : solucion.getPastelerosAsignados())
					aux.print(++pastelero + ",");

				aux.println();
				aux.print(solucion.getBeneficioActual());
				aux.close();
			} else
				System.out.println("El fichero ya existe");

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

	/**
	 * Si el fichero existe, devuelve true
	 * @param nombreFichero el nombre de un fichero
	 * @return booleano
	 */
	public static boolean ficheroExiste(String nombreFichero) {
		return new File(nombreFichero).exists();
	}

	// METODOS GET de fichero

	public static int getNumPasteleros() {
		return numPasteleros;
	}

	public static int getNumPasteles() {
		return numPasteles;
	}

	public static int[][] getPastelero_pastel() {
		return pastelero_pastel;
	}

	public static int[] getPedido() {
		return pedido;
	}
}
