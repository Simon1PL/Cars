package agh.cs.lab2.maps;

import agh.cs.lab2.Position;
import agh.cs.lab2.mapElements.AbstractWorldMapElement;
import agh.cs.lab2.mapElements.HayStack;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    //pytanie, mozemy teraz tworzyc obiekty z atrybutami "null" lub obiekt "null", jak to zablokowac
    //pytanie2, czemu wszystkie metody w AbstractWorldMap musza byc publiczne, uzywamy ich tylko wewnatrz tej klasy wiec private lepsze, trzeba by usunac z interface
    public UnboundedMap(List<HayStack> stacks) {
        for (HayStack stack : stacks) {
            if (canMoveTo(stack.getPosition())) objects.add(stack);
        }
        if (this.objects.size() != 0) {
            this.positionLowerLeft = objects.get(0).getPosition();
            this.positionUpperRight = objects.get(0).getPosition();

            for (AbstractWorldMapElement object : this.objects) {
                setMapLimit(object.getPosition());
            }
        } else System.out.println("podana lista jest pusta, nie mozna stwozyc unbounded map");
    }

    private void setMapLimit(Position position) {
        if (!setMapLimitLeft(position)) setMapLimitRight(position);
        if (!setMapLimitLower(position)) setMapLimitUpper(position);
    }

    private boolean setMapLimitUpper(Position position) {
        if (position.y > this.positionUpperRight.y) {
            this.positionUpperRight = new Position(this.positionUpperRight.x, position.y);
            return true;
        }
        return false;
    }

    private boolean setMapLimitLower(Position position) {
        if (position.y < this.positionLowerLeft.y) {
            this.positionLowerLeft = new Position(this.positionLowerLeft.x, position.y);
            return true;
        }
        return false;
    }

    private boolean setMapLimitRight(Position position) {
        if (position.x > this.positionUpperRight.x) {
            this.positionUpperRight = new Position(position.x, this.positionUpperRight.y);
            return true;
        }
        return false;
    }

    private boolean setMapLimitLeft(Position position) {
        if (position.x < this.positionLowerLeft.x) {
            this.positionLowerLeft = new Position(position.x, this.positionLowerLeft.y);
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (!isOccupied(position)) {
            if (this.objects.size() == 0) {
                this.positionUpperRight = position;
                this.positionLowerLeft = position;
            } else setMapLimit(position);
            return true;
        }
        return false;
    }

    @Override
    public void removeObject(AbstractWorldMapElement object) {
        this.objects.remove(object);
        if (this.objects.size() == 0) {
            this.positionLowerLeft = null;
            this.positionUpperRight = null;
        } else {
            if (this.positionUpperRight.x == object.getPosition().x) {
                this.positionUpperRight = new Position(objects.get(0).getPosition().x, this.positionUpperRight.y);
                for (AbstractWorldMapElement element : this.objects)
                    setMapLimitRight(element.getPosition());
            } else if (this.positionLowerLeft.x == object.getPosition().x) {
                this.positionLowerLeft = new Position(objects.get(0).getPosition().x, this.positionLowerLeft.y);
                for (AbstractWorldMapElement element : this.objects)
                    setMapLimitLeft(element.getPosition());
            }
            if (this.positionUpperRight.y == object.getPosition().y) {
                this.positionUpperRight = new Position(this.positionUpperRight.x, objects.get(0).getPosition().y);
                for (AbstractWorldMapElement element : this.objects)
                    setMapLimitUpper(element.getPosition());
            } else if (this.positionLowerLeft.y == object.getPosition().y) {
                this.positionLowerLeft = new Position(this.positionLowerLeft.x, objects.get(0).getPosition().y);
                for (AbstractWorldMapElement element : this.objects)
                    setMapLimitLower(element.getPosition());

            }
        }
    }
}