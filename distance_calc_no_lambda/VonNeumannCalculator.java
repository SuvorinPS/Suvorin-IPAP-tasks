package distance_calc_no_lambda;

class VonNeumannCalculator implements DistanceCalculator {
    @Override
    public double calculateDistance(Point from, Point to) {
        return (double) Math.abs(to.x - from.x) + Math.abs(to.y - from.y);
    }
}
