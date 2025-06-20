import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(elevator1);
        elevators.add(elevator2); // or Arrays.asList(e1, e2)
        ElevatorController controller = new ElevatorController(elevators);

        controller.handleRequest(new Request(Direction.UP, 5));
        controller.handleRequest(new Request(Direction.DOWN, 3));
        controller.handleRequest(new Request(Direction.UP, 7));

        for (int i= 0; i < 10; i++) {
            controller.processAllRequests();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }
}