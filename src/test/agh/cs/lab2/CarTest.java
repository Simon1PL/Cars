package agh.cs.lab2;

import agh.cs.lab2.mapElements.Car;
import agh.cs.lab2.maps.MapDirection;
import agh.cs.lab2.maps.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarTest {
    // Testy metody move
    // uwaga metoda assert dla obiektow typu car nie sprawdza czy samochody znajduja sie na tej samej mapie
    RectangularMap map = new RectangularMap(4, 4);
    Car car1 = new Car(map, new Position(2, 2), MapDirection.NORTH);

    @Test
    public void testDirection() {
        Car testCar = new Car(map, new Position(2, 3), MapDirection.WEST);
        car1.move(MoveDirection.LEFT);
        assertTrue(car1.toString().equals(testCar.toString()));
    }

    @Test
    public void testPosition() {
        car1.move(MoveDirection.FORWARD);
        Car testCar = new Car(map, new Position(2, 3), MapDirection.NORTH); //uwaga, musimy tworzyc samochod testowy dopiero po ruchach 'car1' zeby miejsce na mapie nie bylo zajete
        assertTrue(car1.equals(testCar));
    }

    @Test
    public void testEndOfTheMap() {
        car1.move(MoveDirection.BACKWARD);
        car1.move(MoveDirection.BACKWARD);
        car1.move(MoveDirection.BACKWARD);
        car1.move(MoveDirection.BACKWARD);
        car1.move(MoveDirection.FORWARD);
        Car testCar = new Car(map, new Position(2, 1), MapDirection.NORTH); //uwaga, musimy tworzyc samochod testowy dopiero po ruchach 'car1' zeby miejsce na mapie nie bylo zajete
        assertTrue(car1.equals(testCar));
    }
}
