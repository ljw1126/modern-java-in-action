package modern.java.ch2.predicate;

import modern.java.ch2.Apple;
import modern.java.ch2.Color;

public class AppleColorPredicate implements ApplePredicate<Apple>{
    @Override
    public boolean test(Apple a) {
        return a.getColor() == Color.GREEN;
    }
}
