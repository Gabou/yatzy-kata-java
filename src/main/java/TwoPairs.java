import java.util.List;

public class TwoPairs implements Category {
    @Override
    public int sum(List<Integer> dice) {

        int firstPair = NumbersOfAKindCategory.PAIR.sum(dice);
        int secondPair = NumbersOfAKindCategory.PAIR.sum(dice.stream().filter(die -> die != firstPair/2).toList());

        if (firstPair == 0 || secondPair == 0) {
            return  0;
        }
        return firstPair + secondPair;
    }
}
