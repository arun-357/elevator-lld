import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void handleRequest (Request request) {
        Elevator best = null;
        Integer minDistance = Integer.MAX_VALUE;

        for (Elevator elevator: elevators) {
            if (elevator.getCurrentDirection() == Direction.IDLE || elevator.getCurrentDirection() == request.getDirection()) {
                Integer distance = Math.abs(elevator.getCurrentFloor() - request.getDestinationFloor());
                if (distance < minDistance) {
                    best = elevator;
                    minDistance = distance;
                }
            }
        }

        if (best == null) {
            best = elevators.get(0);
        }

        best.addRequest(request);
        System.out.println("Request for floor " + request.getDestinationFloor() + " assigned to elevator " + best.getId());
    }

    public void processAllRequests () {
        for (Elevator elevator: elevators) {
            elevator.processRequest();
        }
    }
}
