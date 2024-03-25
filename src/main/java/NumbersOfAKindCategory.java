import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum NumbersOfAKindCategory implements Category{
    PAIR(2),
    THREE_OF_A_KIND(3),
    FOUR_OF_A_KIND(4);

    private final int numberOfScoringDice;

    NumbersOfAKindCategory(int numberOfScoringDice) {
        this.numberOfScoringDice = numberOfScoringDice;
    }

    @Override
    public int sum(List<Integer> dice) {
        return dice.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= numberOfScoringDice)
                .map(Map.Entry::getKey)
                .distinct()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) * numberOfScoringDice;
    }
}
