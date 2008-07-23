package robot;

import frsf.cidisi.faia.agent.problem.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class MetaRobot extends GoalTest {

    public boolean isGoalState(AgentState agentState) {
        if (((EstadoRobot) agentState).getPosicion().equals(EstadoRobot.B)) {
            return true;
        }
        return false;
    }
}
