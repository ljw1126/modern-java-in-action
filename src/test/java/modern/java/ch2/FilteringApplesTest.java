package modern.java.ch2;

import modern.java.ch2.predicate.AppleColorPredicate;
import modern.java.ch2.predicate.ApplePredicate;
import modern.java.ch2.predicate.AppleRedAndHeavyPredicate;
import modern.java.ch2.predicate.AppleWeightPredicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FilteringApplesTest {
    private static final Apple APPLE1 = new Apple(80, Color.GREEN);
    private static final Apple APPLE2 = new Apple(155, Color.GREEN);
    private static final Apple APPLE3 = new Apple(120, Color.RED);

    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = Arrays.asList(APPLE1, APPLE2, APPLE3);
    }

    @Test
    void 녹색사과는_2개이다() {
        List<Apple> apples = FilteringApples.filterApplesByColor(inventory, Color.GREEN);
        assertThat(apples).hasSize(2)
                .containsExactly(APPLE1, APPLE2);
    }

    @Test
    void 빨간사과는_1개이다() {
        List<Apple> apples = FilteringApples.filterApplesByColor(inventory, Color.RED);
        assertThat(apples).hasSize(1)
                .containsExactly(APPLE3);
    }

    @Test
    void AppleColorPredicate() {
        List<Apple> apples = FilteringApples.filter(inventory, new AppleColorPredicate());
        assertThat(apples).hasSize(2)
                .containsExactly(APPLE1, APPLE2);
    }

    @Test
    void AppleWeightPredicate() {
        List<Apple> apples = FilteringApples.filter(inventory, new AppleWeightPredicate());
        assertThat(apples).hasSize(1)
                .containsExactly(APPLE2);
    }

    @Test
    void AppleRedAndHeavyPredicate() {
        List<Apple> apples = FilteringApples.filter(inventory, new AppleRedAndHeavyPredicate());
        assertThat(apples).isEmpty();
    }

    @Test
    void 함수형_인터페이스는_익명함수를선언하여_필터링할수있다() {
        List<Apple> apples = FilteringApples.filter(inventory, new ApplePredicate<Apple>() {
            @Override
            public boolean test(Apple a) {
                return a.getColor() == Color.RED;
            }
        });

        assertThat(apples).hasSize(1)
                .containsExactly(APPLE3);
    }
}
