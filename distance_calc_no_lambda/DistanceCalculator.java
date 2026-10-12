package distance_calc_no_lambda;

@FunctionalInterface
interface DistanceCalculator {
    public double calculateDistance(Point from, Point to);
}
