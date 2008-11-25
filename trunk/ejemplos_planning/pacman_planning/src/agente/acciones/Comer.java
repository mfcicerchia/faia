package agente.acciones;

import frsf.cidisi.faia.agent.planning.PlanningAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import agente.EstadoAmbiente;
import agente.EstadoPacman;
import agente.PercepcionPacman;

public class Comer extends PlanningAction {
	
	public Comer() {
		super();
	}
	
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int pos = estP.getPosicion();

        if (estA.getMundo(pos) == PercepcionPacman.PERCEPCION_COMIDA) {
            estA.setMundo(pos, PercepcionPacman.PERCEPCION_VACIO);
            
            return estA;
        }

        return null;
    }
    
    @Override
    public String toString() {
        return "Comer";
    }
}