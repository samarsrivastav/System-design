package elevator.strategy;

import elevator.state.Direction;

public interface ElevatorSelectionStrategy {
    public void selectElevator(int requestedFloor, Direction direction);
}
