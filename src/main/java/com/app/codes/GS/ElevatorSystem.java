package com.app.codes.GS;


/*

Designing an elevator system involves several components, including the elevator cars, the control system,
and the user interface. Below is a simplified outline of an elevator system design:

Elevator System Components:
Elevator Cars:

Each elevator car is a movable compartment that can carry passengers.
Elevator cars can move vertically within the elevator shaft.
Elevator Shaft:

The vertical shaft contains the elevator cars and ensures their movement.
Control System:

The control system manages the movement of elevator cars and responds to user inputs.
It includes the logic to decide which elevator car should respond to a user's call.
The control system handles requests efficiently to minimize wait times and optimize energy consumption.
User Interface:

The user interface allows passengers to request an elevator.
It typically includes buttons for selecting the desired floor and an indicator showing the current floor.
Elevator System Workflow:
User Requests:

Passengers request an elevator by pressing the "up" or "down" button on the floor they are located.
They enter their destination floor inside the elevator.
Control System Logic:

The control system receives user requests and determines which elevator car should respond.
It considers factors like the current location of elevator cars, their direction, and
the destination floors of existing passengers.
Elevator Movement:

The selected elevator car moves to the requested floor to pick up passengers.
It then moves to the destination floor while stopping at intermediate floors as needed.
Passenger Exit:

Passengers exit the elevator when it reaches their destination floor.
Maintenance and Safety:

The system should have safety features to prevent accidents.
Regular maintenance ensures the proper functioning of the elevators.
Considerations for a Comprehensive Design:
Efficiency:

Optimize the elevator system for efficiency to minimize wait times and energy consumption.
Load Balancing:

Distribute passengers among available elevator cars to balance the load.
Emergency Procedures:

Implement emergency procedures, such as stopping the elevator during a power outage or other emergencies.
Security:

Include security features to prevent unauthorized access.
Scalability:

Design the system to be scalable to accommodate a growing number of users.
Usability:

Ensure a user-friendly interface and clear indicators for passengers.
Energy Efficiency:

Optimize the elevator system for energy efficiency, considering factors like regenerative braking.
Maintenance Alerts:

Implement a system for monitoring and generating alerts for maintenance needs.
Remember that elevator system designs can vary based on the specific requirements of the building or facility.
The above outline provides a general framework for designing a conventional elevator system.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum Direction {
    UP,
    DOWN,
    NONE
}

class Request {
    private final int floor;
    private final Direction direction;

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}

class Elevator {
    private int currentFloor;
    private Direction direction;
    private final List<Request> requests;

    public Elevator() {
        this.currentFloor = 1;
        this.direction = Direction.NONE;
        this.requests = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        if (!requests.isEmpty()) {
            Request request = requests.remove(0);
            direction = calculateDirection(request.getFloor());
            currentFloor = request.getFloor();
            System.out.println("Elevator moving to floor " + currentFloor);
        }
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    private Direction calculateDirection(int targetFloor) {
        if (targetFloor > currentFloor) {
            return Direction.UP;
        } else if (targetFloor < currentFloor) {
            return Direction.DOWN;
        } else {
            return Direction.NONE;
        }
    }
}

class ElevatorSystems {
    private final List<Elevator> elevators;
    private final Queue<Request> requestQueue;

    public ElevatorSystems(int numElevators) {
        this.elevators = new ArrayList<>();
        this.requestQueue = new LinkedList<>();

        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator());
        }
    }

    public void requestElevator(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        requestQueue.add(request);
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }

        processRequests();
    }

    private void processRequests() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            assignRequest(request);
        }
    }

    private void assignRequest(Request request) {
        Elevator bestElevator = findBestElevator(request);
        bestElevator.addRequest(request);
    }

    private Elevator findBestElevator(Request request) {
        // In a real system, you would implement logic to find the best elevator
        // For simplicity, we'll just return the first elevator
        return elevators.get(0);
    }
}

public class ElevatorSystem {
    public static void main(String[] args) {
        ElevatorSystems elevatorSystem = new ElevatorSystems(3);

        // Simulate user requests
        elevatorSystem.requestElevator(3, Direction.UP);
        elevatorSystem.requestElevator(7, Direction.DOWN);
        elevatorSystem.requestElevator(5, Direction.UP);

        // Run the elevator system
        for (int i = 0; i < 10; i++) {
            elevatorSystem.step();
        }
    }
}
