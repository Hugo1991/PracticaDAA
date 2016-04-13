
import java.util.*;

public class Nodo
 {
	private ArrayList<Integer> asignaciones ;
    private Integer costeAsignaciones;
    private ArrayList<Integer> pastelerosSinAsignar;
    private Integer ultimoPasterleroAsignado;
    private Integer cotaInferior;
    private ArrayList<Boolean> pedidosHechos;
    private ArrayList<Integer> valoresElegidosCotaInf;

	public void setCosteAsignaciones(Integer costeAsignaciones)
	{
		this.costeAsignaciones = costeAsignaciones;
	}

	public Integer getCosteAsignaciones()
	{
		return costeAsignaciones;
	}

	public void setValoresElegidosCotaInf(ArrayList<Integer> valoresElegidosCotaInf)
	{
		this.valoresElegidosCotaInf = valoresElegidosCotaInf;
	}

	public ArrayList<Integer> getValoresElegidosCotaInf()
	{
		return valoresElegidosCotaInf;
	}

	public void setPedidosHechos(ArrayList<Boolean> pedidosHechos)
	{
		this.pedidosHechos = pedidosHechos;
	}

	public ArrayList<Boolean> getPedidosHechos()
	{
		return pedidosHechos;
	}

	public void setCotaInferior(Integer cotaInferior)
	{
		this.cotaInferior = cotaInferior;
	}

	public Integer getCotaInferior()
	{
		return cotaInferior;
	}

	public void setUltimoPasterleroAsignado(Integer ultimoPasterleroAsignado)
	{
		this.ultimoPasterleroAsignado = ultimoPasterleroAsignado;
	}

	public Integer getUltimoPasterleroAsignado()
	{
		return ultimoPasterleroAsignado;
	}

	public void setPastelerosSinAsignar(ArrayList<Integer> pastelerosSinAsignar)
	{
		this.pastelerosSinAsignar = pastelerosSinAsignar;
	}

	public ArrayList<Integer> getPastelerosSinAsignar()
	{
		return pastelerosSinAsignar;
	}
    


	public void setAsignaciones(ArrayList<Integer> asignaciones)
	{
		this.asignaciones = asignaciones;
	}

	public ArrayList<Integer> getAsignaciones()
	{
		return asignaciones;
	}}
