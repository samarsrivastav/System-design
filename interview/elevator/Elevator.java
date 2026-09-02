package elevator;

import elevator.state.ElevatorState;

public class Elevator {
    private int id;
    private int currentFloor;
    private ElevatorState state;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assuming ground floor as starting point
        this.state = ElevatorState.IDLE;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void moveToFloor(int floor) {
        if (floor > currentFloor) {
            state = ElevatorState.UP;
        } else if (floor < currentFloor) {
            state = ElevatorState.DOWN;
        } else {
            state = ElevatorState.IDLE;
        }
        currentFloor = floor;
        System.out.println("Elevator " + id + " moved to floor " + currentFloor + " and is now " + state);
    }
}
