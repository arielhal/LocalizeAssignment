package Framework;

/**
 * Event class.
 * Represents an event in the state machine.
 * @author leagi
 */
public abstract class Event {
    // Should have created another not static variable that will save the ID (I understood and fixed it myslef during the interview)
    private static int id = 0;      // A unique ID for each event
    
    /**
     * A constructor for Event object.
     * Every event has a unique ID.
     */
    public Event() {
        Event.id++;
    }
    
    public int getId() {
        return this.id;
    }
    
    /**
     * The type of the event is the name of the class.
     * This method is final because the type should always be defined this way.
     * @return 
     */
    public final String getType() {
        return this.getClass().getName();
    }
    
    /**
     * Two events are equal if they are of the same type.
     * 
     * @param obj
     * @return True if the events are of the same type, otherwise - False
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
}
