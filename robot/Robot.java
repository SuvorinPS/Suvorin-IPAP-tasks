package robot;

class Robot {
    private Direction direction;
    private Point position;

    Robot() {
        this.direction = Direction.UP;
        this.position = new Point(0, 0);
    }

    public Point getPosition() {
        return position;
    }

    public void turnLeft() {
        this.direction = this.direction.left();
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public void makeStep() {
        position = switch (direction) {
            case UP -> new Point(position.x(), position.y() + 1);
            case RIGHT -> new Point(position.x() + 1, position.y());
            case DOWN -> new Point(position.x(), position.y() - 1);
            case LEFT -> new Point(position.x() - 1, position.y());
        };
    }
}
