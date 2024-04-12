package modern.java.ch2.predicate;


import modern.java.ch2.Apple;

public class AppleWeightPredicate implements ApplePredicate<Apple> {
    @Override
    public boolean test(Apple a) {
        return a.getWeight() > 150;
    }
}
