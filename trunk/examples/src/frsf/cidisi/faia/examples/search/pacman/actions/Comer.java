/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package frsf.cidisi.faia.examples.search.pacman.actions;

import frsf.cidisi.faia.examples.search.pacman.*;
import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.agent.searchbased.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Comer extends SearchAction {
    
	/**
	 * Este método se utiliza para actualizar el estado de un nodo cuando se
	 * está ejecutando el proceso de búsqueda. No actualiza el estado real
	 * del agente, sino sólamente el estado de un nodo del árbol.
	 */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoPacman estP = (EstadoPacman) s;

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estP.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Comer@Pac - ");
            return estP;
        }


        return null;
    }
    
    /**
     * Este método se utiliza tanto para actualiar el estado interno del agente,
     * como para el estado real del simulador.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente estA = (EstadoAmbiente) est;
        EstadoPacman estP = ((EstadoPacman) ast);

        int fil = estP.getFila();
        int col = estP.getColumna();

        if (estA.getMundo()[fil][col] == PercepcionPacman.PERCEPCION_COMIDA) {
            estA.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            estP.setMundo(fil, col, PercepcionPacman.PERCEPCION_VACIO);
            //System.out.println(" Comer@Amb - ");
            return estA;
        }

        return null;
    }

    /**
     * Este método se puede utilizar para establecer un cierto costo a cada
     * acción, dando prioridad a algunas en vez de a otras.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * Si bien el uso de éste método no es muy importante cuando se crea un
     * agente basado en búsqueda, sí es vital establecer correctamente el nombre
     * de la acción cuando se crea un agente basado en cálculo situacional.
     * Mirar el código del método CalculusAction.toLogicName(). Lo que hace ese
     * método es pasar el resultado de este a minúsculas, y supone que en el
     * archivo prolog se está utilizando ese string (en minúsculas) para indicar
     * la acción.
     */
    @Override
    public String toString() {
        return "Comer";
    }
}