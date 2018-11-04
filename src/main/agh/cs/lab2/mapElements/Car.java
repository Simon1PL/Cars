package agh.cs.lab2.mapElements;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab2.maps.IWorldMap;
import agh.cs.lab2.maps.MapDirection;

public class Car extends AbstractWorldMapElement {
    private MapDirection carDirection;

    public Car(IWorldMap map, Position startPosition, MapDirection startDirection) {
        this.carDirection = startDirection;
        this.position = startPosition;
        if (map.place(this)) {
            this.map = map;
        } else {
            System.out.println("nie mozna postawic auta na tej mapie");
        }
    }

    public String toString() {
        return this.carDirection.toString();
    }

    public void move(MoveDirection direction) {
        int x = 0;
        switch (direction) {
            case RIGHT:
                this.carDirection = this.carDirection.next();
                break;
            case LEFT:
                this.carDirection = this.carDirection.previous();
                break;
            case FORWARD:
                x = -1;
                break;
            case BACKWARD:
                x = 1;
                break;
        }
        if (x != 0) {
            Position position = this.position;
            switch (this.carDirection) {
                case EAST:
                    position = position.add(new Position(-x, 0));
                    break;
                case WEST:
                    position = position.add(new Position(x, 0));
                    break;
                case NORTH:
                    position = position.add(new Position(0, -x));
                    break;
                case SOUTH:
                    position = position.add(new Position(0, x));
                    break;
            }
            if (this.map.canMoveTo(position)) {
                this.position = position;
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Car))
            return false;
        Car that = (Car) other;
        return (this.position.equals(that.position) && this.carDirection == that.carDirection); //uwaga nie sprawdza czy obiekty maja taki sam atrybut 'map'
    }
}
