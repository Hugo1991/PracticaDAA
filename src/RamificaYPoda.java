
import java.util.ArrayList;
import java.util.PriorityQueue;

public class RamificaYPoda {

	/**
	 * Este algoritmo consigue la cota minima para maximizar el beneficio de los
	 * pasteleros. Este algoritmo es voraz, es decir, coge el numero maximo dado
	 * un pedido, sin ver si hay un pastelero mejor mas adelante.
	 * 
	 * @return Nodo cota minima
	 */
	private static Nodo CalcularCota() {
		Nodo nodocota = new Nodo();
		for (int[] pesoPedido : Nodo.getMatrizBeneficios()) {
			int beneficio_max = 0;
			int pasteleroAsignado = 0;
			for (int pastelero = 0; pastelero < pesoPedido.length; pastelero++)
				if (!(nodocota.getPastelerosAsignados().contains(pastelero)))
					if (pesoPedido[pastelero] > beneficio_max) {
						beneficio_max = pesoPedido[pastelero];
						pasteleroAsignado = pastelero;
					}

			nodocota.getPastelerosAsignados().add(pasteleroAsignado);
			nodocota.setBeneficioActual(beneficio_max + nodocota.getBeneficioActual());
		}
		return nodocota;
	}

	/**
	 * Este algoritmo, calcula el valor maximo del algoritmo ramifica y poda en
	 * base a un valor maximo.
	 * 
	 * @param nodo
	 * @return nodo
	 */
	public static Nodo CalcularSolucion(Nodo nodo) {
		PriorityQueue<Nodo> colaNodoVivos = new PriorityQueue<>();
		long start = System.currentTimeMillis();
		Nodo nodoCota = CalcularCota();
		int cotaInferior = nodoCota.getBeneficioActual();
		nodo.setBeneficioActual(cotaInferior);
		colaNodoVivos.add(nodo);
		// Bucle de Ramifica y poda
		  
		while (!colaNodoVivos.isEmpty()) {
			Nodo candidato = colaNodoVivos.poll();
			if (candidato.estaTerminado()) {
				if (candidato.getBeneficioActual() > cotaInferior) {
					nodoCota = candidato;
					cotaInferior = candidato.getBeneficioActual();
				}
			} else {
				if (candidato.getBeneficioActual() >= cotaInferior) {
					ArrayList<Nodo> nHijos = candidato.complecciones(candidato);
					for (Nodo Hcandidato : nHijos)
						if (Hcandidato.getBeneficioActual() >= cotaInferior)
							colaNodoVivos.add(Hcandidato);
				}
			}
		}
		  long end = System.currentTimeMillis();
		  long res = end - start;
		  System.out.println("milisegundos: "+res);
		return nodoCota;
	}
}