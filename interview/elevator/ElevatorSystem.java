package elevator;

import elevator.observer.DisplayPanel;
import elevator.state.Direction;
import elevator.strategy.ElevatorSelectionStrategy;
import elevator.strategy.NearestFirst;

public class ElevatorSystem {
    private static ElevatorSelectionStrategy selectionStrategy = new NearestFirst();
    public static void main(String[] args) {
        ElevatorManager manager = ElevatorManager.getInstance();
        // Example usage of the ElevatorSystem
        manager.setSelectionStrategy(selectionStrategy);

        manager.requestElevator(5, Direction.UP);

        manager.setDisplayPanel(new DisplayPanel(1));
        manager.notifyObservers(1, 5, Direction.UP);

    }
}
