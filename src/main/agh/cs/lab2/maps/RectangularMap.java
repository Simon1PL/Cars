package agh.cs.lab2.maps;

import agh.cs.lab2.Position;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        if (width < 1 || height < 1) {
            System.out.println("szerokość i wysokość muszą być dodatnie, nie stworzono mapy");
            return;
        }
        this.positionLowerLeft = new Position(0, 0);
        this.positionUpperRight = new Position(width - 1, height - 1);
    }

    public RectangularMap(int xMin, int xMax, int yMin, int yMax) {
        if (xMax > xMin && yMax > yMin) {
            this.positionLowerLeft = new Position(xMin, yMin);
            this.positionUpperRight = new Position(xMax, yMax);
        } else {
            System.out.println("źle podane parametry mapy, nie stworzono mapy");
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (position.smaller(this.positionUpperRight) && position.larger(this.positionLowerLeft) && !isOccupied(position))
            return true;
        return false;
    }
}
