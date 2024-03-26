package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public final class YatzyCategory implements Category {
    @Override
    public int sum(Roll roll) {
        return roll.allSameDie() ? 50 : 0;
    }
}
