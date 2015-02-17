package core;

import java.util.ArrayList;
import java.util.Random;

public class State {
	
	private ArrayList<Transition> transitions;
	private String name;
	
	public State(String name)
	{
		this.name = name;
		transitions = new ArrayList<Transition>();
	}
	
	public void addTransition(Transition transition)
	{
		this.transitions.add(transition);
	}
	
	public Transition getRandomTransition()
	{
		Random r = new Random();
		return transitions.get(r.nextInt(transitions.size()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
