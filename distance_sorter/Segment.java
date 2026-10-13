package distance_sorter;

class Segment {
    Point from, to;

    public Segment(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public double distanceBetween() {
        return Math.sqrt(((double) this.to.x - this.from.x) * (this.to.x - this.from.x) + (this.to.y - this.from.y) * (this.to.y - this.from.y));
    }
}
