package distance_calc_no_lambda;

class MooreCalculator implements DistanceCalculator {
    @Override
    public double calculateDistance(Point from, Point to) {
        return Math.max(Math.abs((double) to.x - from.x), (Math.abs(to.y - from.y)));
    }
}
