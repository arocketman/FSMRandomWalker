package example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import core.FSM;
import core.State;
import core.Transition;

public class FileDemo {
	
	static RandomAccessFile file;
	
	public static void main(String[] args) {
		
		State opened = new State("opened");
		State closed = new State("closed");
		Transition open = new Transition("open",closed,opened) {
			
			@Override
			public <T> T doTransition() {
				try {
					file = new RandomAccessFile("file.txt","rw");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};
		Transition close = new Transition("close",opened,closed) {
			
			@Override
			public <T> T doTransition() {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};
		Transition read = new Transition("read",opened,opened){

			@Override
			public <T> T doTransition() {
				try {
					file.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
		};
		
		Transition write = new Transition("read",opened,opened){

			@Override
			public <T> T doTransition() {
				try {
					file.writeChars("Hello..");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
		};
		
		opened.addTransition(close);
		closed.addTransition(open);
		opened.addTransition(read);
		opened.addTransition(write);
		
		FSM myFSM = new FSM(opened,closed);
		myFSM.setCurrentState(closed);
		
		myFSM.randomWalk(100);
		
	}
}
