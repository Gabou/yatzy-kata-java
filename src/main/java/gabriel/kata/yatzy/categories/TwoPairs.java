package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public final class TwoPairs implements Category {
    @Override
    public int sum(Roll roll) {

        var diceWithSameValue = roll.retrieveDiceWithSameValue(2);

        if (diceWithSameValue.size() != 2) {
            return 0;
        }

        return diceWithSameValue.stream().mapToInt(Integer::intValue).sum() * 2;
    }
}
