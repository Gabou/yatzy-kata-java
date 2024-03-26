package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

import java.util.function.Predicate;

import static gabriel.kata.yatzy.categories.NumbersOfAKindCategory.ThreeOfAKind;

public final class FullHouse implements Category {
    @Override
    public int sum(Roll roll) {
        int threeOfAKind = new ThreeOfAKind().sum(roll);
        int twoOfAKind = roll.retrieveDiceWithSameValue(2).stream()
                .filter(diceWithDifferentValueThan(threeOfAKind / 3))
                .findFirst()
                .orElse(0) * 2;

        if (threeOfAKind == 0 || twoOfAKind == 0) {
            return  0;
        }
        return threeOfAKind + twoOfAKind;
    }

    private static Predicate<Integer> diceWithDifferentValueThan(int threeOfAKind) {
        return die -> die != threeOfAKind;
    }
}
