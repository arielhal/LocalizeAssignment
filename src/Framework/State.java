package Framework;

import java.io.Serializable;

/**
 * Represents a state of the State Machine.
 * @author leagi
 */
public abstract class State implements Serializable{
    public abstract State getNextState(Event event);
}
