package Testing;

import Framework.Event;
import Framework.StateMachine;
import Framework.State;

/**
 * A state machine that counts the number of events of the same type.
 * 
 * @author leagi
 */
public class CountingStateMachine extends StateMachine{
    private int sameEventCounter;
    private Event lastEvent;
    public final int THRESHOLD = 3;
    
    public CountingStateMachine(State initState) {
        super(initState);
        this.sameEventCounter = 0;
        this.lastEvent = null;
    }
    
    /**
     * Handles an event and checks if there's a sequence of at least 3 events of the same type.
     * 
     * @param event 
     */
    @Override
    public void handleEvent(Event event) {
        // Handle the event like in the StateMachine class
        super.handleEvent(event);
        
        // If first event is handled or the event type is different from the last one
        if ((this.lastEvent == null) || 
                !(event.getType().equals(this.lastEvent.getType()))){
            this.lastEvent = event;
            this.sameEventCounter = 1;
        }
        // If this is not the first event and it is the same as the last one
        else {
           this.sameEventCounter++;
           if (this.sameEventCounter >= THRESHOLD) {
               String MESSAGE = "Catched a series of " + this.sameEventCounter 
                       + " of type '" + event.getType() + "'";
               System.out.println(MESSAGE);
           }
        }
    }
}