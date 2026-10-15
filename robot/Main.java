package robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    private static final String INPUT_FILENAME = "src/robot/robot_path.txt";
    private static final String OUTPUT_FILENAME = "src/robot/step_count.txt";

    public static void main(String[] args) {
        String robotPath = readStringFromFile();
        int steps = findStepCount(robotPath);
        writeResultToFile(steps);
    }

    private static int findStepCount(String robotPath) {
        Robot robot = new Robot();
        HashSet<Point> visited = new HashSet<>();

        int steps = 0;
        visited.add(new Point(0, 0));

        for (char command : robotPath.toCharArray()) {
            switch (command) {
                case 'L' -> robot.turnLeft();
                case 'R' -> robot.turnRight();
                case 'S' -> {
                    robot.makeStep();
                    Point nextPoint = robot.getPosition();
                    steps++;

                    if (!visited.add(nextPoint)) {
                        return steps;
                    }
                }
            }
        }

        return -1;
    }

    private static String readStringFromFile() {
        File file = new File(INPUT_FILENAME);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            result.append(scanner.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Нет такого файла: " + INPUT_FILENAME, e);
        }

        return result.toString();
    }

    private static void writeResultToFile(int result) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILENAME)) {
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать " + OUTPUT_FILENAME, e);
        }
    }
}