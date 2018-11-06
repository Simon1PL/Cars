package agh.cs.lab2.maps;

import agh.cs.lab2.Position;
import agh.cs.lab2.mapElements.HayStack;
import agh.cs.lab2.mapElements.IWorldElement;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    //pytanie, mozemy teraz tworzyc obiekty z atrybutami "null" lub sam obiekt "null", jak to zablokowac
    //pytanie2, czemu wszystkie metody w AbstractWorldMap musza byc publiczne, uzywamy ich tylko wewnatrz tej klasy wiec private lepsze (trzeba by usunac z interface)
    //w interface zmienilem car na abstractMapElement w metodzie place ok?
    //testy do map, bezsensu, jak, atrybuty sa prywatne wiec nie moge sprawdzac a metody sa wywolywane przy tworzeniu obiektow
    //metoda run w abstractMap nie dziala bo przy aktualizowaniu mapy cars jest zmieniana kolejnsoc, co tera
    public UnboundedMap(List<HayStack> stacks) {
        for (HayStack stack : stacks) {
            this.place(stack);
        }
    }

    public void setMapLimit(Position position) {
        if (this.positionLowerLeft == null && this.positionUpperRight == null) {
            this.positionLowerLeft = position;
            this.positionUpperRight = position;
        } else {
            this.positionUpperRight=this.positionUpperRight.upperRight(position);
            this.positionLowerLeft=this.positionLowerLeft.lowerLeft(position);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (!isOccupied(position)) {
            setMapLimit(position);
            return true;
        }
        return false;
    }

    @Override
    public void removeObject(IWorldElement object) {
        this.objects.remove(object);
        if (this.objects.size() == 0) {
            this.positionLowerLeft = null;
            this.positionUpperRight = null;
        } else {
            if (this.positionUpperRight.x == object.getPosition().x || this.positionUpperRight.y == object.getPosition().y || this.positionLowerLeft.y == object.getPosition().y || this.positionLowerLeft.x == object.getPosition().x) {
                this.positionLowerLeft=null;
                this.positionUpperRight=null;
                for (IWorldElement element : this.objects.values()) {
                    setMapLimit(element.getPosition());
                }
            }
        }
    }
}