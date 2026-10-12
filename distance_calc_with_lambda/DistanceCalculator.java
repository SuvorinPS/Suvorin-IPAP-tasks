package distance_calc_with_lambda;

@FunctionalInterface
interface DistanceCalculator {
    double calculateDistance(Point from, Point to);
}
