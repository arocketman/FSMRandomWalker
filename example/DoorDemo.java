package example;

import core.FSM;
import core.State;
import core.Transition;

public class DoorDemo {

	public static void main(String[] args) {
		State opened = new State("opened");
		State closed = new State("closed");
		Transition open = new Transition("open",closed,opened) {
			
			@Override
			public <T> T doTransition() {
				System.out.println("Open sent");
				return null;
			}
		};
		Transition close = new Transition("close",opened,closed) {
			
			@Override
			public <T> T doTransition() {
				System.out.println("Close sent");
				return null;
			}
		};
		opened.addTransition(close);
		closed.addTransition(open);
		
		FSM myFSM = new FSM(opened,closed);
		
		myFSM.randomWalk(100);
	}

}
