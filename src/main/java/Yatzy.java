import java.util.Arrays;
import java.util.List;

public class Yatzy {

    private final List<Integer> dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int chance() {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public int yatzy() {
        boolean yatzy = dice.stream().allMatch(die -> die.equals(dice.getFirst()));
        return yatzy ? 50 : 0;
    }

    public int scores(Category category) {
        return category.sum(dice);
    }

}



