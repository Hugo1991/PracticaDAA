import java.io.FileNotFoundException;
import java.io.IOException;

public class Pasteleria {
	static int numPasteleros;
	static int numPasteles;
	static int[][] pastelero_pastel;
	static int[] pedido;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Error, no existe el parametro para el fichero de entrada");
			System.out.println("ej. Pasteleria \"entrada.txt\"");
		} else {
			try {
			Fichero.leerFichero(args[0]);
			numPasteleros = Fichero.getNumPasteleros();
			numPasteles = Fichero.getNumPasteles();
			pastelero_pastel = Fichero.getPastelero_pastel();
			pedido = Fichero.getPedido();
			RamificaYPoda.RamificaYPoda(new Nodo(pastelero_pastel));
			if (args.length == 1) {
				System.out.println(numPasteleros);
				System.out.println(numPasteles);
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++)
						System.out.print(pastelero_pastel[i][j] + " ");
					System.out.println();
				}
				System.out.println(pedido);
			} else {

				Fichero.escribirFichero(pedido, args[1]);
			}
			}catch (FileNotFoundException fne) {
				System.out.println("error, fichero no existe");
			}catch (IOException e) {
				System.out.println("Error generico");
			}
		}
	}

}
