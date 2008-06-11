package robot;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrQ extends Action {

	/**
	 * 
	 * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
	 */
	public AgentState execute(AgentState s){
		EstadoRobot estR = (EstadoRobot)s;
		
		if (estR.getPosicionesVisitadas().contains(EstadoRobot.Q))
			return null;
		
		ArrayList<String> sucesores = new ArrayList<String>(estR.getSucesores());
		if (sucesores!=null){
			int index = sucesores.indexOf(EstadoRobot.Q);
			if (index>=0){
				estR.setPosicion(EstadoRobot.Q);
				return estR;
			}
			
		}
		
		return null;
	}

	/**
	 * Permite actualizar el estado real del agente y del ambiente.-
	 * 
	 * @param ast: Es el estado del agente a ser actualizado.-
	 * @param est: Es el estado del ambiente a ser actualizado.-
	 */
	public EnvironmentState execute(AgentState ast, EnvironmentState est){
		this.execute(ast);

		return null;
	}
	
	public Double getCost(){
		return new Double(0);
	}

	public String toString() {
		return "IrQ";
	}

}