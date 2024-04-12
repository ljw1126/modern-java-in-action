package modern.java.ch2.predicate;

import modern.java.ch2.Apple;
import modern.java.ch2.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate<Apple>{
    @Override
    public boolean test(Apple a) {
        return a.getColor() == Color.RED && a.getWeight() > 150;
    }
}
