package org.example.questions;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int[] command = {-2, 8, 3, 7, -1};
        int[][] obstables = {{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}};
        System.out.println("Output: " + robotSim(command, obstables));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0;
        int x = 0;
        int y = 0;
        int maxX = x;
        int maxY = y;
        for (int command : commands) {
            if (command < 0) {
                if (command == -1) {
                    direction++;
                } else {
                    direction--;
                }
                if (direction > 3) direction = 0;
                if (direction == -1) direction = 3;
            } else {
                for (int j = 0; j < command; j++) {
                    boolean touchedObj = false;
                    switch (direction) {
                        case 0 -> {
                            y++;
                            if (haveObj(x, y, obstacles)) {
                                y--;
                                touchedObj = true;
                            }
                        }
                        case 1 -> {
                            x++;
                            if (haveObj(x, y, obstacles)) {
                                x--;
                                touchedObj = true;
                            }
                        }
                        case 2 -> {
                            y--;
                            if (haveObj(x, y, obstacles)) {
                                y++;
                                touchedObj = true;
                            }
                        }
                        case 3 -> {
                            x--;
                            if (haveObj(x, y, obstacles)) {
                                x++;
                                touchedObj = true;
                            }
                        }
                    }
                    if (touchedObj) break;
                }
                int tempX = x < 0 ? -x : x;
                int tempY = y < 0 ? -y : y;

                maxX = Math.max(maxX, tempX);
                maxY = Math.max(maxY, tempY);
            }
        }
        return (int) (Math.pow(maxX, 2) + Math.pow(maxY, 2));
    }

    public static boolean haveObj(int x, int y, int[][] obstacles) {
        for (int[] obj : obstacles) {
            if (x == obj[0] && y == obj[1]) {
                return true;
            }
        }
        return false;
    }
}
