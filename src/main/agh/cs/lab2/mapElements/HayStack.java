package agh.cs.lab2.mapElements;

import agh.cs.lab2.Position;

public class HayStack extends AbstractWorldMapElement {

    public HayStack(Position position) {
        this.position = position;
    }

    public HayStack(int x, int y) {
        this.position =new Position(x, y);
    }

    public String toString() {
        return "s";
    }
}
