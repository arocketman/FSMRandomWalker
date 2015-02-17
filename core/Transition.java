package core;

public abstract class Transition {
	private String name;
	private State startState;
	private State endState;
	
	public Transition(String name,State startState,State endState)
	{
		this.name = name;
		this.startState = startState;
		this.endState = endState;
	}
	
	public abstract <T> T doTransition();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getStartState() {
		return startState;
	}

	public void setStartState(State startState) {
		this.startState = startState;
	}

	public State getEndState() {
		return endState;
	}

	public void setEndState(State endState) {
		this.endState = endState;
	}
	
	
}
