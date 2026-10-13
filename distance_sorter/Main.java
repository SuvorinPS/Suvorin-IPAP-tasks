package distance_sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main {
    static final String FILENAME = "src/distance_sorter/test_data.txt";

    public static void main() {
        List<Point> points = createPointList();
        points.sort(Comparator.comparingDouble(Point::distanceToZero));

        List<Segment> segments = createSegmentsList(points);
        segments.sort(Comparator.comparingDouble(Segment::distanceBetween));

        printStatistics(segments);
    }

    static List<Point> createPointList() {
        File file = new File(FILENAME);
        List<Point> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            int pointCount = scanner.nextInt();

            for (int i = 0; i < pointCount; i++) {
                result.add(readPoint(scanner));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: " + FILENAME);
            e.printStackTrace();
        }

        return result;
    }

    static Point readPoint(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new Point(x, y);
    }

    static List<Segment> createSegmentsList(List<Point> points) {
        List<Segment> segments = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                segments.add(new Segment(points.get(i), points.get(j)));
            }
        }

        return segments;
    }

    static void printStatistics(List<Segment> segments) {
        double mean = findMean(segments);
        double median = findMedian(segments);
        double mode = findMode(segments);

        System.out.println("Средняя длина: " + mean + "\nМедианная длина: " + median + "\nМодная длина: " + mode);
    }

    // Находит среднюю длину в отсортированном списке
    static double findMean(List<Segment> segments) {
        if (segments.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Segment segment : segments) {
            sum += segment.distanceBetween();
        }

        return sum / segments.size();
    }

    // Находит медианную длину в отсортированном списке
    static double findMedian(List<Segment> segments) {
        if (segments.isEmpty()) {
            return 0;
        }
        double result;
        if (segments.size() % 2 == 0) {
            result = (segments.get(segments.size() / 2).distanceBetween() + segments.get(segments.size() / 2 - 1).distanceBetween()) / 2;
        } else {
            result = segments.get(segments.size() / 2).distanceBetween();
        }

        return result;
    }

    // Находит моду в отсортированном списке
    static double findMode(List<Segment> segments) {
        if (segments.isEmpty()) {
            return 0;
        }
        int modeIndex = 0;
        int maxInARow = 1;
        int localInARow = 1;
        for (int i = 1; i < segments.size(); i++) {
            if (segments.get(i).distanceBetween() == segments.get(i - 1).distanceBetween()) {
                localInARow++;
            } else {
                localInARow = 1;
            }
            if (localInARow > maxInARow) {
                maxInARow = localInARow;
                modeIndex = i;
            }
        }

        return segments.get(modeIndex).distanceBetween();
    }
}
