package agh.cs.lab2;

import agh.cs.lab2.mapElements.Car;
import agh.cs.lab2.mapElements.HayStack;
import agh.cs.lab2.mapElements.OptionsParser;
import agh.cs.lab2.maps.IWorldMap;
import agh.cs.lab2.maps.MapDirection;
import agh.cs.lab2.maps.RectangularMap;
import agh.cs.lab2.maps.UnboundedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSystem {
    public static void main(String[] args) {
        //LAB4 IWorldMap map = new RectangularMap(10, 5); plus to co lab5
        /*LAB5
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"b", "f", "b", "f", "l", "f"});
        List<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(-4, -4));
        stacks.add(new HayStack(7, 7));
        stacks.add(new HayStack(3, 6));
        stacks.add(new HayStack(2, 0));
        IWorldMap map =new UnboundedMap(stacks);
        new Car(map, new Position(2, 2), MapDirection.NORTH);
        new Car(map, new Position(3, 4), MapDirection.NORTH);
        map.run(directions);
        System.out.println(map);
        */
        /*lab3
        RectangularMap map1 = new RectangularMap(0, 4, 0, 4);
        Car car1 = new Car(map1, new Position(2, 2), MapDirection.NORTH);
        System.out.println("Mapa: 5 na 5 (pola od 0 do 4)");
        System.out.println("direction: "+ car1 + "\nposition: " + car1.getPosition());
        System.out.println("Sterowanie samochodem:");
        System.out.println("f-jazda do przodu");
        System.out.println("b-jazda do tyłu");
        System.out.println("r-obrót w prawo");
        System.out.println("l-obrót w lewo");
        System.out.println("print-wyświetlenie mapy");
        while (true) {
            Scanner input = new Scanner(System.in);
            String text = input.nextLine();
            if(text.equals("print")) System.out.println(map1);
            else {
                String tab[] = new String[text.length()];
                for (int i = 0; i < text.length(); i++) {
                    tab[i] = Character.toString(text.charAt(i));
                }
                MoveDirection tablica[] = OptionsParser.parse(tab);
                for (MoveDirection a : tablica) {
                    car1.move(a);
                }
                System.out.println(car1.toString() + car1.getPosition());
            }
        }
        */
    }
}