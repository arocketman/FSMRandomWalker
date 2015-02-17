# FSMRandomWalker

Finite State Machine Random Walker is a tool to model your State Machine and generate random walkings from them. This is useful if you want to use Finite State Machine for Model Based Testing (MBT). 

#Usage

1. Create the States.
2. Create the Transitions and over-ride the doTransition() method.
3. Add the transitions to the states they belong to.
4. Create the FSM with the States as parameters.
5. Give the randomWalk command.

There are three worked examples in the example folders with images of the starting Finite State Machine.

#TODO

* Add maven support
* All transition / All states coverage.
