import java.io.FileNotFoundException;
import java.io.IOException;

public class Pasteleria {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Error, no existe el parametro para el fichero de entrada");
			System.out.println("ej. Pasteleria \"entrada.txt\"");
		} else {
			try {

				Fichero.leerFichero(args[0]);
				int numPasteleros = Fichero.getNumPasteleros();
				int[][] pastelero_pastel = Fichero.getPastelero_pastel();
				int[] pedidos = Fichero.getPedido();
				int[][] beneficio = new int[pedidos.length][numPasteleros];
				int num = 0;
				for (int i = 0; i < pedidos.length; i++) {
					int npedido = pedidos[num];
					for (int j = 0; j < numPasteleros; j++) {
						beneficio[i][j] = pastelero_pastel[j][npedido - 1];
					}
					num++;
				}
				Nodo nodo = new Nodo(beneficio);
				Nodo solucion = RamificaYPoda.CalcularSolucion(nodo);
				if (args.length == 1) {
					for (int pastelero : solucion.getPastelerosAsignados()) {
						System.out.print(++pastelero + ",");
					}
					System.out.println();
					System.out.println("Y el Beneficio superior es: " + solucion.getBeneficioActual());
				} else {
					Fichero.escribirFichero(solucion, args[1]);
				}
			} catch (FileNotFoundException fne) {
				System.out.println("error, fichero no existe");
			} catch (IOException e) {
				System.out.println("Error generico");
			}
		}
	}

}
