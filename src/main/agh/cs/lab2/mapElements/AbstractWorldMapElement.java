package agh.cs.lab2.mapElements;

import agh.cs.lab2.maps.IWorldMap;
import agh.cs.lab2.Position;

abstract class AbstractWorldMapElement implements IWorldElement{
    protected Position position;
    protected IWorldMap map;

    public Position getPosition() {
        return this.position;
    }
}
