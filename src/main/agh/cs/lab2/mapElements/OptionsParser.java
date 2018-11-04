package agh.cs.lab2.mapElements;

import agh.cs.lab2.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] strings) {
        MoveDirection[] result = new MoveDirection[strings.length];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "f":
                case "forward":
                case "F":
                case "Forward":
                    result[k] = MoveDirection.FORWARD;
                    k++;
                    break;
                case "b":
                case "backward":
                case "B":
                case "Backward":
                    result[k] = MoveDirection.BACKWARD;
                    k++;
                    break;
                case "l":
                case "L":
                case "left":
                case "Left":
                    result[k] = MoveDirection.LEFT;
                    k++;
                    break;
                case "r":
                case "R":
                case "Right":
                case "right":
                    result[k] = MoveDirection.RIGHT;
                    k++;
                    break;
            }
        }
        MoveDirection[] result2 = new MoveDirection[k];
        for (int i = 0; i < k; i++) {
            result2[i] = result[i];
        }
        return result2;
    }
}
