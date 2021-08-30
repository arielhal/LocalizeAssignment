package Testing;

import Framework.Event;
import Framework.State;

/**
 * A state of type SecondState.
 * 
 * @author leagi
 */
public class SecondState extends State{
    @Override
    public State getNextState(Event event) {
        if (event instanceof ThirdEvent)
            return this;
        return new FirstState();
    }
}
