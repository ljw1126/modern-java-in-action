package modern.java.ch2;

import modern.java.ch2.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilteringApples {

    private FilteringApples() {
        throw new UnsupportedOperationException();
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == color) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate<Apple> p) {
        return inventory.stream()
                .filter(p::test)
                .collect(toList());
    }
}
