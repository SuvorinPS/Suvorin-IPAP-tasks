package distance_sorter;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToZero() {
        return Math.sqrt(x * x + y * y);
    }
}
