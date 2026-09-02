## Functional Features

- Simulates multiple elevators.
- Handles user requests for elevators from floor panels.
- Optimally selects elevators based on the nearest available one and current direction.
- Updates floor panels with real-time elevator status.

## Design Features

- State Management: Dynamically transitions between states like Idle, Moving Up, and Moving Down.
- Flexible Elevator Selection: Encapsulates the selection logic in the NearestElevatorStrategy.
- Observer Notifications: Floor panels automatically update their displays when elevators move.
