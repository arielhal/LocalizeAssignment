package Framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Persistent State Machine.
 * A state machine that can be saved and reloaded from a file.
 * 
 * @author leagi
 */
public class PersistentStateMachine extends StateMachine{
    
    private final String PATH = "state_machine";
    
    public PersistentStateMachine(State initState) {
        super(initState);
    }
    
    /**
     * Save state machine to a file.
     */
    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream(PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.flush();
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Load a copy of the state machine that was most recently saved.
     * 
     * @return copy of the state machine
     */
    public PersistentStateMachine load() {
        try {
            FileInputStream fileIn = new FileInputStream(PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return (PersistentStateMachine)obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
