package Framework;

import java.io.Serializable;

/**
 * An object representing the state machine.
 * 
 * @author leagi
 */
public class StateMachine implements Serializable{
    private State currentState;
    
    /**
     * A constructor for State Machine objects.
     * 
     * @param initState - the first state of the machine
     */
    public StateMachine(State initState) {
        this.currentState = initState;
    }
    
    public State getState() {
        return this.currentState;
    }
    
    /**
     * The method receives the event and updates the state of the machine.
     * 
     * @param event 
     */
    public void handleEvent(Event event) {
        State newState = this.currentState.getNextState(event);
        this.currentState = newState;
    }
}
