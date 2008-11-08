package agente;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.calculus.CalculusActionFactory;
import agente.acciones.*;

/**
 * Cuando el Solver (en este caso la clase Calculus) pide la mejor acción
 * al agente (ver el método solve()), recibe de la base de conocimiento
 * un string que representa a la acción elegida. Sin embargo, el método
 * solve debe devolver un *objeto* Action.
 * Esta clase es utilizada para transformar un string en un objeto acción, y
 * debe ser implementada por el usuario.
 * Se utiliza el patrón Singleton.
 */
public class CalculusAccionFactory extends CalculusActionFactory {
	
    private static CalculusAccionFactory instancia;

    private CalculusAccionFactory() {
    }

    public static CalculusAccionFactory getInstance() {
        if (instancia == null) {
            instancia = new CalculusAccionFactory();
        }
        return instancia;
    }

    /**
     * El método es sencillo: recibe un string y devuelve un objeto
     * Action, dependiendo del valor de ese string.
     */
    @Override
    public Action stringToAction(String stringAction) {
        
        return null;
    }

    /** Retornamos el string que utilizamos en 'base_conocimiento.pl'
     * (el archivo prolog) en el predicado mejorAccion cuando se ha
     * cumplido el objetivo.
     * Esta es la línea donde, en el ejemplo, se utiliza una acción
     * tipo 'noAccion' para indicar que hemos llegado al objetivo:
     * 
     *   mejorAccion(noAccion,S):-cumplioObjetivo(S),!.
     *   
     */
    @Override
    public String noActionString() {
        return "noAccion";
    }
}