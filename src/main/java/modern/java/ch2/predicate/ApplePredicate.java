package modern.java.ch2.predicate;


import modern.java.ch2.Apple;

@FunctionalInterface
public interface ApplePredicate<T> {
    boolean test(T a);
}
