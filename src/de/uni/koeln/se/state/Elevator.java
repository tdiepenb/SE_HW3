package de.uni.koeln.se.state;

public class Elevator {

    public static int current_Floor = 5;
    private final Elv_States State = new Elv_States();
    int dest_Floor;

    public Elevator(int dest_floor) {
        this.dest_Floor = dest_floor;
        System.out.println("*** Destination floor is: " + dest_Floor);
        if (current_Floor != dest_Floor) {
            if (current_Floor < dest_Floor) {
                go_up();
            } else {
                go_down();
            }
        } else {
            System.out.println("Already on this Floor");
        }
    }

    private void go_up() {
        State.currentState = State.Moving_up;
        while (current_Floor < dest_Floor) {
            System.out.println("The current Floor is: " + current_Floor + " - The Elevator is " + State.currentState);
            current_Floor++;
        }
        arrive_atFloor();

    }

    private void go_down() {
        State.currentState = State.Moving_down;
        while (current_Floor > dest_Floor) {
            System.out.println("The current Floor is: " + current_Floor + " - The Elevator is " + State.currentState);
            current_Floor--;
        }
        arrive_atFloor();
    }

    private void arrive_atFloor() {
        if (dest_Floor == current_Floor) {
            System.out.println("Elevator is Arriving at Floor: " + current_Floor);
            State.currentState = State.Idle;
            System.out.println("Elevator is now " + State.currentState);
            exit();
        }

    }

    private void exit() {
        System.out.println("You can now Exit the Elevator.");
    }

}
