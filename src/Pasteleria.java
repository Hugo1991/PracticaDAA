import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Ignacio de Lucas Noguero
 * @author Hugo Fernandez Visier
 *
 */
public class Pasteleria {
	public static void main(String[] args) {
		// Si no se le pasa ningun argumento
		if (args.length == 0) {
			System.out.println("Error, no existe el parametro para el fichero de entrada");
			System.out.println("ej. Pasteleria \"entrada.txt\"");
		} else {
			// Captura excepciones del fichero, si no existe el fichero y el
			// error general
			try {
				// Leemos el fichero en el primer argumento
				Fichero.leerFichero(args[0]);
				int numPasteleros = Fichero.getNumPasteleros();
				int[][] pastelero_pastel = Fichero.getPastelero_pastel();
				int[] pedidos = Fichero.getPedido();
				int[][] beneficio = new int[pedidos.length][numPasteleros];
				int num = 0;
				for (int i = 0; i < pedidos.length; i++) {
					int npedido = pedidos[num];
					for (int j = 0; j < numPasteleros; j++)
						beneficio[i][j] = pastelero_pastel[j][npedido - 1];
					num++;
				}
				Nodo nodo = new Nodo(beneficio);
				Nodo solucion = RamificaYPoda.CalcularSolucion(nodo);
				// si encuentra el primer argumento solo muestra el resultado
				if (args.length == 1) {
					for (int pastelero : solucion.getPastelerosAsignados()) {
						System.out.print(++pastelero + ",");
					}
					System.out.println();
					System.out.println(solucion.getBeneficioActual());
					// si existe el segundo argumento, escribira el fichero
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
