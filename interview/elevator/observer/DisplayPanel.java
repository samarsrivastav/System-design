package elevator.observer;

import elevator.state.Direction;

public class DisplayPanel implements Observer {
    private int elevatorId;
    private int currentFloor;
    private String direction;

    public DisplayPanel(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    @Override
    public void update(int elevatorId, int currentFloor, Direction direction) {
        if (this.elevatorId == elevatorId) {
            this.currentFloor = currentFloor;
            this.direction = direction.toString();
            display();
        }
    }

    private void display() {
        System.out.println("Elevator " + elevatorId + " is currently at floor " + currentFloor + " moving " + direction);
    }
    
}
