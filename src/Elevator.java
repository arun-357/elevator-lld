import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private final int id;
    private Direction currentDirection;
    private int currentFloor;
    private boolean isMoving;

    private PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> downQueue = new PriorityQueue<>();

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.currentDirection = Direction.IDLE;
        this.isMoving = false;
    }

    public int getId() {
        return id;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public synchronized void addRequest(Request request) {
        if (request.getDestinationFloor() > currentFloor) {
            upQueue.offer(request.getDestinationFloor());
        } else if (request.getDestinationFloor() < currentFloor) {
            downQueue.offer(request.getDestinationFloor());
        }
    }


//    The processRequest() method executes different logic based on the elevator's current direction:
//
//    If direction is Direction.UP (Elevator is currently moving upwards):
//
//    Prioritize Up Requests: It first checks if upQueue is not empty. If there are pending "up" requests, it takes the next floor from upQueue using upQueue.poll() and calls moveToFloor() to move the elevator to that floor.
//    Switch to Down if Up Queue is Empty: If upQueue is empty (no more "up" requests in its current path), it then checks if there are any downQueue requests. If downQueue is not empty, the elevator changes its direction to Direction.DOWN to start serving those requests.
//    Go Idle if Both Queues are Empty: If both upQueue and downQueue are empty, it means there are no more requests to serve in either direction, so the elevator's direction is set to Direction.IDLE.
//    If direction is Direction.DOWN (Elevator is currently moving downwards):
//
//    Prioritize Down Requests: It first checks if downQueue is not empty. If there are pending "down" requests, it takes the next floor from downQueue using downQueue.poll() and calls moveToFloor() to move the elevator to that floor.
//    Switch to Up if Down Queue is Empty: If downQueue is empty (no more "down" requests in its current path), it then checks if there are any upQueue requests. If upQueue is not empty, the elevator changes its direction to Direction.UP to start serving those requests.
//    Go Idle if Both Queues are Empty: If both downQueue and upQueue are empty, the elevator's direction is set to Direction.IDLE.
//    If direction is Direction.IDLE (Elevator is currently stationary):
//
//    Choose Direction Based on Pending Requests: The elevator needs to decide which way to go.
//    It first checks if upQueue is not empty. If there are "up" requests, it sets its direction to Direction.UP.
//    If upQueue is empty, it then checks if downQueue is not empty. If there are "down" requests, it sets its direction to Direction.DOWN.
//    If both queues are empty, the elevator simply remains IDLE (though the code implicitly keeps it idle if no conditions are met).

    public synchronized void processRequest() {
        if (currentDirection == Direction.UP) {
            if (!upQueue.isEmpty()) {
                int next = upQueue.poll();
                moveToFloor(next);
            } else if (!downQueue.isEmpty()) {
                currentDirection = Direction.DOWN;
            } else {
                currentDirection = Direction.IDLE;
            }
        } else if (currentDirection == Direction.DOWN) {
            if (!downQueue.isEmpty()) {
                int next = downQueue.poll();
                moveToFloor(next);
            } else if (!upQueue.isEmpty()) {
                currentDirection = Direction.DOWN;
            } else {
                currentDirection = Direction.IDLE;
            }
        } else {
            if (!upQueue.isEmpty()) {
                currentDirection = Direction.UP;
            } else if (!downQueue.isEmpty()) {
                currentDirection = Direction.DOWN;
            }
        }
    }

    public synchronized void moveToFloor(int floor) {
        System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + floor);
        currentFloor = floor;
        System.out.println("Elevator " + id + " arrived at floor " + floor);
    }
}
