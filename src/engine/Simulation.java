package engine;

import java.util.ArrayList;
import java.util.List;

import immobile.StructureParts;
import mobile.MovingParts;
import model.ConfigureStructure;
import model.SimulationState;

public class Simulation {
	
	private List<SimulationState> listStates;
	private int lineNb;
	private int columnNb;
	
	
	//Constructeur
	public Simulation(ConfigureStructure structConfig) {
		this.listStates = new ArrayList<SimulationState>();
		this.lineNb = structConfig.lineNb;
		this.columnNb = structConfig.columnNb;
		
	}
	

	/**
	 * Initialisation de la première étape et exécution de l'avancement de la simulation pas à pas.
	 * 
	 * @param structureParts
	 * @param movingParts
	 * 
	 */
	//
	
	public void run() {
			
		boolean termination = false;
		int currentState = 0;
		
		SimulationState initState = new SimulationState(currentState, this.lineNb, this.columnNb);
		listStates.add(initState);
		
		while(termination == false) {
			//Execute simulation step by step.
			currentState++;
			listStates.add(new SimulationState(currentState, this.lineNb, this.columnNb)); //Add simulation state to list
			termination = listStates.get(currentState).generate(listStates.get(currentState-1)); //Generate current state from previous State
		}
	}
	
public void run(StructureParts structureParts, MovingParts movingParts) {
		
		run();
	}


	/**
	 * Get a state of the simulation at the given index
	 * @param index
	 * @return
	 */
	public SimulationState getState(int index) {
		return this.listStates.get(index);
	}
	
}
