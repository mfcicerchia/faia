package frsf.cidisi.faia.agent;
import frsf.cidisi.faia.agent.problem.Action;
import frsf.cidisi.faia.agent.problem.Problem;
import frsf.cidisi.faia.solver.Solve;
import frsf.cidisi.faia.state.AgentState;

/**
 * @author Jorge M. Roa
 * @version 1.0
 * @created 08-Mar-2007 13:16:04
 */
public abstract class GoalBasedAgent extends Agent {

	protected Solve solver;
	protected Problem problem;
	protected AgentState state;

	public GoalBasedAgent(){

	}

	
	public abstract Action selectAction();

	public void see(Perception p){
		//problem.getAgentState().updateState(p);
		this.getAgentState().updateState(p);
	}
	
	public Problem getProblem(){
		return problem;
	}

	public Solve getSolver(){
		return solver;
	}
	
	public void setProblem(Problem problem){
		this.problem = problem;
	}

	public void setSolver(Solve solver){
		this.solver = solver;
	}
	
	public AgentState getAgentState(){
		return state;
	}
	public void setAgentState(AgentState agentState){
		this.state = agentState;
	}


	public AgentState getState() {
		return state;
	}


	public void setState(AgentState state) {
		this.state = state;
	}
	
}