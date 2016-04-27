import java.io.IOException;

public class Pasteleria {
	static int numPasteleros;
	static int numPasteles;
	static int[][] pastelero_pastel;
	static int[] pedido;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fichero file=new Fichero();
		file.leerFichero("entrada.txt");
		numPasteleros=file.getNumPasteleros();
		numPasteles=file.getNumPasteles();
		pastelero_pastel=file.getPastelero_pastel();
		pedido=file.getPedido();
		System.out.println(numPasteleros);
		System.out.println(numPasteles);
		for(int i=0;i<5;i++){
			for(int j=0;j<3;j++)
				System.out.print (pastelero_pastel[i][j]+ " ");
			System.out.println();
		}
		System.out.println(pedido);
	}

}
