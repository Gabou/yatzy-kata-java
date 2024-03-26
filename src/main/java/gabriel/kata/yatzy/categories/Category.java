package gabriel.kata.yatzy.categories;

import gabriel.kata.yatzy.Roll;

public sealed interface Category permits Chance, FullHouse, NumbersCategory, NumbersOfAKindCategory, StraightCategory, TwoPairs, YatzyCategory {
    int sum(Roll roll);
}
