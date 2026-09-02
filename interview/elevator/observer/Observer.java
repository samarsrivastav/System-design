package elevator.observer;

import elevator.state.Direction;

public interface Observer {
    public void update(int elevatorId, int currentFloor, Direction direction);
}
