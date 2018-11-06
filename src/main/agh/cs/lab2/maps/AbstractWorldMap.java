package agh.cs.lab2.maps;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab2.mapElements.Car;
import agh.cs.lab2.mapElements.IWorldElement;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected Position positionUpperRight;
    protected Position positionLowerLeft;
    protected Map<Position,Car> cars = new HashMap<>();
    protected Map<Position,IWorldElement> objects = new HashMap<>();

    public String toString() {
        return new MapVisualizer(this).draw(this.positionLowerLeft, this.positionUpperRight);
    }

    public IWorldElement objectAt(Position position) {
        return objects.get(position);
    }

    public boolean isOccupied(Position position) {
        if (objectAt(position) != null) return true;
        return false;
    }

    public boolean canMoveTo(Position position) {
        if (!isOccupied(position))
            return true;
        return false;
    }

    public boolean place(IWorldElement object) {
        if (canMoveTo(object.getPosition())) {
            if (object instanceof Car) {
                this.cars.put(object.getPosition(), (Car) object);
            }
            this.objects.put(object.getPosition(), object);
            return true;
        }
        throw new IllegalArgumentException("position " + object.getPosition() + " is unavailable");
    }

    public void run(MoveDirection[] directions) {
        if (cars.size() != 0) {
            for (int moveNumber = 0; moveNumber < directions.length; moveNumber++) {
                Car car1 = (Car) cars.values().toArray()[moveNumber % cars.size()];
                Position lastPosition = new Position(car1.getPosition().x, car1.getPosition().y);
                car1.move(directions[moveNumber]);
                if (!car1.getPosition().equals(lastPosition)) {
                    objects.remove(lastPosition);
                    cars.remove(lastPosition);
                    objects.put(car1.getPosition(), car1);
                    cars.putIfAbsent(car1.getPosition(), car1);
                }
                System.out.println(cars);
            }
        }
    }

    public void removeObject(IWorldElement object) {
        this.objects.remove(object);
    }
}