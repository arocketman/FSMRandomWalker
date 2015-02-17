package core;

import java.util.ArrayList;

public class FSM {
	
	private ArrayList<State> states;
	private State currentState;

	//Settings
	private boolean debugTransition = true;
	
	/**
	 * Constructor for the Finite State machine.
	 * @param states the FSM states
	 */
	public FSM(State... states)
	{
		this.states = new ArrayList<State>();
		currentState = states[0];
		for(State s : states)
		{
			this.states.add(s);
		}
	}
	
	public void addState(State state)
	{
		this.states.add(state);
	}
	
	public void randomWalk(int nTransitions)
	{
		for(int i = 0; i < nTransitions; i++)
		{
			Transition chosenTransition = currentState.getRandomTransition();
			chosenTransition.doTransition();
			if(debugTransition){
				System.out.println(chosenTransition.getStartState().getName() + "---" + chosenTransition.getName() + "()--->"  + chosenTransition.getEndState().getName());
			}

			currentState = chosenTransition.getEndState();
		}
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	
}
