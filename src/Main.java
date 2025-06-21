import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);
        ElevatorController controller = new ElevatorController(Arrays.asList(e1, e2));

        controller.handleRequest(new Request(Direction.UP, 5));
        controller.processAllRequests(); Thread.sleep(1000);

        controller.handleRequest(new Request(Direction.DOWN, 3));
        controller.processAllRequests(); Thread.sleep(1000);

        controller.handleRequest(new Request(Direction.DOWN, 1));
        controller.processAllRequests(); Thread.sleep(1000);

        controller.handleRequest(new Request(Direction.DOWN, 1));
        controller.processAllRequests(); Thread.sleep(1000);

        controller.handleRequest(new Request(Direction.DOWN, 0));
        controller.processAllRequests(); Thread.sleep(1000);

        controller.handleRequest(new Request(Direction.UP, 7));
        for (int i = 0; i < 10; i++) {
            controller.processAllRequests();
            Thread.sleep(1000);
        }
    }
}
