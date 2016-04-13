import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {
	int numPasteleros;
	int numPasteles;
	int[][] pastelero_pastel;
	int[] pedido;

	public void leerFichero(String ficheroEntrada) throws IOException {
		FileReader f = new FileReader(ficheroEntrada);
		BufferedReader b = new BufferedReader(f);
		String linea = b.readLine();
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

	public int getNumPasteleros() {
		return numPasteleros;
	}

	public void setNumPasteleros(int numPasteleros) {
		this.numPasteleros = numPasteleros;
	}

	public int getNumPasteles() {
		return numPasteles;
	}

	public void setNumPasteles(int numPasteles) {
		this.numPasteles = numPasteles;
	}

	public int[][] getPastelero_pastel() {
		return pastelero_pastel;
	}

	public void setPastelero_pastel(int[][] pastelero_pastel) {
		this.pastelero_pastel = pastelero_pastel;
	}

	public int[] getPedido() {
		return pedido;
	}

	public void setPedido(int[] pedido) {
		this.pedido = pedido;
	}
}
