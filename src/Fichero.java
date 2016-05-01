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

	public static void leerFichero(String ficheroEntrada) throws FileNotFoundException,IOException {
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
			for (int i = 0; i < numPasteleros; i++)
				pedido[i] = Integer.parseInt(datosPedido[i]);

			for (int i = 0; i < numPasteleros; i++)
				for (int j = 0; j < numPasteles; j++)
					coste[i][j] = pastelero_pastel[i][pedido[j] - 1];

			b.close();
		

	}

	public static void escribirFichero(int[] pedido, String nombreFicheroSalida) {
		try {
			if (!new File(nombreFicheroSalida).exists()) {
				PrintWriter aux = new PrintWriter(new BufferedWriter(new FileWriter(nombreFicheroSalida)));
				for (int i = 1; i <= pedido.length; i++) {
					int j = 0;
					while ((j < pedido.length) && (pedido[j] != i)) {
						j++;
					}
					aux.print((j + 1) + ",");
					System.out.println(j + 1);
				}
				aux.println();
				aux.close();
			} else {
				System.out.println("El fichero ya existe");
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

	public static int getNumPasteleros() {
		return numPasteleros;
	}

	public void setNumPasteleros(int numPasteleros) {
		this.numPasteleros = numPasteleros;
	}

	public static int getNumPasteles() {
		return numPasteles;
	}

	public void setNumPasteles(int numPasteles) {
		this.numPasteles = numPasteles;
	}

	public static int[][] getPastelero_pastel() {
		return pastelero_pastel;
	}

	public void setPastelero_pastel(int[][] pastelero_pastel) {
		this.pastelero_pastel = pastelero_pastel;
	}

	public static int[] getPedido() {
		return pedido;
	}

	public void setPedido(int[] pedido) {
		this.pedido = pedido;
	}
}
