import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {
	private static int numPasteleros;
	private static int numPasteles;
	private static int[][] pastelero_pastel;
	private static int[] pedido;

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

	public static boolean ficheroExiste(String nombreFichero) {
		return new File(nombreFichero).exists();
	}

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
