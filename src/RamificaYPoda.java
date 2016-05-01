import java.util.ArrayList;
import java.util.PriorityQueue;

public class RamificaYPoda {
	public static void RamificaYPoda(Nodo n) {
		PriorityQueue<Nodo> nodosVivos = new PriorityQueue<>();
		nodosVivos.add(n);
		//int cotaSuperior=calculaPrimeraSolucion().getBeneficio();
		while (!nodosVivos.isEmpty()) {
			Nodo aux=nodosVivos.poll();
			
			//if ya no puede tener mas hijos aux
				//if esValido cotaSuperior<beneficioactual+beneficioAux
				//cotaSuperior=beneficio
			//else
				//arrayList hijos=complecciones(aux)
				//for Nodo hijo:hijos
					//if esValido beneficioActual<beneficioActual+beneficioHijo
						//nodosVivos.add hijo
				
			
			
			
		}
	}

}