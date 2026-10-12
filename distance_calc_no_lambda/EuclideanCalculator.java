package distance_calc_no_lambda;

class EuclideanCalculator implements DistanceCalculator {
    @Override
    public double calculateDistance(Point from, Point to) {
        return Math.sqrt(((double) to.x - from.x) * (to.x - from.x) + (to.y - from.y) * (to.y - from.y));
    }
}
