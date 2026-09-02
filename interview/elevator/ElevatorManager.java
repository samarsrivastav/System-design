package elevator;

import java.util.ArrayList;
import java.util.List;

import elevator.observer.Observer;
import elevator.state.Direction;
import elevator.strategy.ElevatorSelectionStrategy;

//singleton class to manage elevators
public class ElevatorManager {
    private ElevatorManager(){}
    private static ElevatorManager instance = null;

    public static ElevatorManager getInstance() {
        if(instance == null) {
            instance = new ElevatorManager();
        }
        return instance;
    }

    private static List<Elevator> elevators = new ArrayList<>();
    private static ElevatorSelectionStrategy selectionStrategy;
    private static Observer displayPanel;

    public static void requestElevator(int requestedFloor, Direction direction) {
        if (selectionStrategy != null) {
            selectionStrategy.selectElevator(requestedFloor, direction);
        } else {
            System.out.println("No selection strategy set.");
        }
    }
    public static void addElevators(Elevator elevator) {
        elevators.add(elevator);
    }
    public static void setSelectionStrategy(ElevatorSelectionStrategy strategy) {
        selectionStrategy = strategy;
    }
    public static void setDisplayPanel(Observer panel) {
        displayPanel = panel;
    }
    public static void notifyObservers(int elevatorId, int currentFloor, Direction direction) {
        if (displayPanel != null) {
            displayPanel.update(elevatorId, currentFloor, direction);
        }
    }
    


}
