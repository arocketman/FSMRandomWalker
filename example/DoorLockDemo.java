package example;

import core.FSM;
import core.State;
import core.Transition;

public class DoorLockDemo {
	public static void main(String[] args) {
		State opened = new State("opened");
		State closed = new State("closed");
		State locked = new State("locked");
		
		Transition open = new Transition("open",closed,opened) {
			
			@Override
			public <T> T doTransition() {
				return null;
			}
		};
		Transition close = new Transition("close",opened,closed) {
			
			@Override
			public <T> T doTransition() {
				return null;
			}
		};
		
		Transition lock = new Transition("lock",closed,locked){

			@Override
			public <T> T doTransition() {
				return null;
			}
			
		};
		
		Transition unlock = new Transition("unlock",locked,closed){

			@Override
			public <T> T doTransition() {
				return null;
			}
			
		};
		
		opened.addTransition(close);
		closed.addTransition(open);
		closed.addTransition(lock);
		locked.addTransition(unlock);
		
		FSM myFSM = new FSM(opened,closed);
		
		myFSM.randomWalk(100);
	}
}
