package modern.java.ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FilteringApplesTest {
    private static final Apple APPLE1 = new Apple(80, "green");
    private static final Apple APPLE2 = new Apple(155, "green");
    private static final Apple APPLE3 = new Apple(120, "red");

    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = Arrays.asList(APPLE1, APPLE2, APPLE3);
    }

    @Test
    void 초록색_사과는_2개이다_메소드참조() {
        List<Apple> apples = FilteringApples.filterApples(inventory, FilteringApples::isGreenApple);
        assertThat(apples).hasSize(2)
                .containsExactly(APPLE1, APPLE2);
    }

    @Test
    void 무게가_150초과하는사과는_하나이다_메소드참조() {
        List<Apple> apples = FilteringApples.filterApples(inventory, FilteringApples::isHeavyApple);
        assertThat(apples).hasSize(1)
                .containsExactly(APPLE2);
    }



    @Test
    void 초록색_사과는_2개이다_람다식() {
        List<Apple> apples = FilteringApples.filterApples(inventory, apple -> "green".equals(apple.getColor()));
        assertThat(apples).hasSize(2)
                .containsExactly(APPLE1, APPLE2);
    }

    @Test
    void 무게가_150초과하는사과는_하나이다_람다식() {
        List<Apple> apples = FilteringApples.filterApples(inventory, apple -> apple.getWeight() > 150);
        assertThat(apples).hasSize(1)
                .containsExactly(APPLE2);
    }

    @Test
    void 무게가_80미만이고_색깔이_brown인_사과는_없다() {
        List<Apple> apples = FilteringApples.filterApples(inventory, apple -> apple.getWeight() < 80 || "brown".equals(apple.getColor()));
        assertThat(apples).isEmpty();
    }
}
