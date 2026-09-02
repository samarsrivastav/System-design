package elevator.strategy;

import elevator.state.Direction;

public class NearestFirst implements ElevatorSelectionStrategy {
    @Override
    public void selectElevator(int requestedFloor, Direction direction) {
        // Implement the logic to select the nearest elevator based on the requested floor and direction
        // This is a placeholder implementation; actual logic will depend on the elevator system's state
        System.out.println("Selecting nearest elevator for floor: " + requestedFloor + " in direction: " + direction);
    }
    
}
