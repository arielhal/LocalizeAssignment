/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localizeassignment;

import Framework.PersistentStateMachine;
import Testing.CountingStateMachine;
import Testing.FirstEvent;
import Testing.FirstState;
import Testing.SecondEvent;
import Testing.SecondState;
import Testing.ThirdEvent;

/**
 *
 * @author leagi
 */
public class LocalizeAssignment {

    /**
     * Runs tests of the framework.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Perform the second assignment
        FirstEvent firstEvent = new FirstEvent();
        SecondEvent secondEvent = new SecondEvent();
        ThirdEvent thirdEvent = new ThirdEvent();
        FirstState firstState = new FirstState();
        SecondState secondState = new SecondState();

        CountingStateMachine machine = new CountingStateMachine(firstState);
        machine.handleEvent(firstEvent);
        machine.handleEvent(secondEvent);
        machine.handleEvent(secondEvent);
        machine.handleEvent(secondEvent);
        machine.handleEvent(secondEvent);
        machine.handleEvent(firstEvent);
        
        // Test the persistent machine
        System.out.println("Testing persistent machine");
        PersistentStateMachine persistentMachine = new PersistentStateMachine(secondState);
        persistentMachine.handleEvent(firstEvent);
        System.out.println(persistentMachine.getState().getClass().getName());
        persistentMachine.save();
        persistentMachine.handleEvent(thirdEvent);
        persistentMachine = persistentMachine.load();
        System.out.println(persistentMachine.getState().getClass().getName());
        persistentMachine.handleEvent(secondEvent);
        System.out.println(persistentMachine.getState().getClass().getName());
        persistentMachine = persistentMachine.load();
        System.out.println(persistentMachine.getState().getClass().getName());
    }
    
}
