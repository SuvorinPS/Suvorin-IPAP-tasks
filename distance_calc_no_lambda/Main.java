package distance_calc_no_lambda;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Main {
    static final int COUNTER = 5;
    static Scanner scanner = new Scanner(System.in);

    public static void main () {
        List<Point> points = getPointList(COUNTER);

        double euclidean = getShortDistance(points, new EuclideanCalculator());
        double vonNeumann = getShortDistance(points, new VonNeumannCalculator());
        double moore = getShortDistance(points, new MooreCalculator());

        System.out.printf("euclidean = %f\nvonNeumann = %f\nmoore = %f\n", euclidean, vonNeumann, moore);
    }

    static double getShortDistance(List<Point> points, DistanceCalculator calculator) {
        double minDistance = Double.POSITIVE_INFINITY;
        double localMin;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                localMin = calculator.calculateDistance(points.get(i), points.get(j));
                if (localMin < minDistance) {
                    minDistance = localMin;
                }
            }
        }

        return minDistance;
    }


    static List<Point> getPointList(int count) {
        List<Point> result = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            result.add(getPoint());
        }

        return result;
    }

    static Point getPoint() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new Point(x, y);
    }
}
