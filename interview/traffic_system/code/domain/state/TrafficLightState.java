package interview.traffic_system.code.domain.state;


import interview.traffic_system.code.domain.TrafficLight;

public interface TrafficLightState {
    void turnGreen(TrafficLight trafficLight);
    void turnYellow(TrafficLight trafficLight);
    void turnRed(TrafficLight trafficLight);
    void turnOff(TrafficLight trafficLight);
    String getStateName();
    boolean canTransitionTo(TrafficLightState newState);
} 