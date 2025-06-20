public class Request {
    private final Direction direction;
    private final int destinationFloor;

    public Request(Direction direction, int destinationFloor) {
        this.direction = direction;
        this.destinationFloor = destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
