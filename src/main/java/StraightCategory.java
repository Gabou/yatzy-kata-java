import java.util.List;

public enum StraightCategory implements Category{
    SMALL,
    LARGE;

    @Override
    public int sum(List<Integer> dice) {
        if (dice.stream().distinct().count() == 5) {
            return dice.stream().mapToInt(Integer::intValue).sum();
        }
        return 0;
    }
}
