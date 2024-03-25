import java.util.List;

public class FullHouse implements Category {
    @Override
    public int sum(List<Integer> dice) {
        int threeOfAKind = NumbersOfAKindCategory.THREE_OF_A_KIND.sum(dice);
        int twoOfAKind = NumbersOfAKindCategory.PAIR.sum(dice.stream().filter(die -> die != threeOfAKind/3).toList());

        if (threeOfAKind == 0 || twoOfAKind == 0) {
            return  0;
        }
        return threeOfAKind + twoOfAKind;
    }
}
