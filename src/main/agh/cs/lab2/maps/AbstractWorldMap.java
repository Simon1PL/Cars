package agh.cs.lab2.maps;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab2.mapElements.AbstractWorldMapElement;
import agh.cs.lab2.mapElements.Car;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected Position positionUpperRight;
    protected Position positionLowerLeft;
    protected List<AbstractWorldMapElement> objects = new ArrayList<>();

    public String toString() {
        return new MapVisualizer(this).draw(this.positionLowerLeft, this.positionUpperRight);
    }

    public AbstractWorldMapElement objectAt(Position position) {
        for (AbstractWorldMapElement object : this.objects) {
            if (object.getPosition().equals(position))
                return object;
        }
        return null;
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

    public boolean place(AbstractWorldMapElement object) {
        if (canMoveTo(object.getPosition())) {
            this.objects.add(object);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions) {
        List<Car> vehicles = new ArrayList<>();
        for (AbstractWorldMapElement object : this.objects) {
            if ((object instanceof Car)) {
                Car vehicle = (Car) object;
                vehicles.add(vehicle);
            }
        }
        if (vehicles.size() != 0) {
            for (int moveNumber = 0; moveNumber < directions.length; moveNumber++) {
                vehicles.get(moveNumber % vehicles.size()).move(directions[moveNumber]);
            }
        }
    }

    public void removeObject(AbstractWorldMapElement object) {
        this.objects.remove(object);
    }
}