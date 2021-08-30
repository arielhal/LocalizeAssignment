package Testing;

import Framework.State;
import Framework.Event;

/**
 * A state of type FirstState.
 * 
 * @author leagi
 */
public class FirstState extends State{
    public State getNextState(Event event) {
        return new SecondState();
    }
}
