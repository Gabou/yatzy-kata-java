import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 3, 3, 6, 14",
            "4, 5, 5, 6, 1, 21",
            "2, 3, 4, 5, 1, 15",
            "3, 3, 4, 5, 1, 16"
    })
    void chance_scores_sum_of_all_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).chance());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 1, 1, 50",
            "6, 6, 6, 6, 6, 50",
            "1, 1, 1, 2, 1, 0"
    })
    void yatzy_scores_50_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).yatzy());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 1",
            "1, 2, 1, 4, 5, 2",
            "1, 2, 1, 1, 1, 4",
            "3, 3, 3, 4, 5, 0"
    })
    void ones_scores_sum_of_all_one_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.ONES));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 2, 5, 1, 4",
            "2, 2, 2, 2, 2, 10",
            "6, 6, 6, 6, 3, 0"
    })
    void twos_scores_sum_of_all_two_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.TWOS));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 2, 3, 6",
            "2, 3, 3, 3, 3, 12",
            "6, 6, 6, 6, 4, 0"
    })
    void threes_scores_sum_of_all_three_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.THREES));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 12",
            "4, 4, 5, 5, 5, 8",
            "4, 5, 5, 5, 5, 4",
            "1, 1, 2, 4, 4, 8"
    })
    void fours_scores_sum_of_all_four(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.FOURS));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 10",
            "4, 4, 5, 5, 5, 15",
            "4, 5, 5, 5, 5, 20"
    })
    void fives_scores_sum_of_all_five_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.FIVES));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5, 5, 0",
            "4, 4, 6, 5, 5, 6",
            "6, 5, 6, 6, 5, 18"
    })
    void sixes_scores_sum_of_all_six_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersCategory.SIXES));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 3, 5, 6, 6",
            "5, 3, 3, 3, 5, 10",
            "5, 3, 6, 6, 5, 12",
            "1, 2, 3, 4, 5, 0",
            "3, 3, 3, 4, 4, 8",
            "1, 1, 6, 2, 6, 12",
            "3, 3, 3, 4, 1, 6",
            "3, 3, 3, 3, 1, 6"
    })
    void pair_scores_sum_of_two_highest_identical_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersOfAKindCategory.PAIR));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 5, 4, 5, 16",
            "3, 3, 5, 5, 5, 16",
            "3, 5, 5, 5, 5, 0",
            "1, 1, 2, 3, 3, 8",
            "1, 1, 2, 3, 4, 0",
            "1, 1, 2, 2, 2, 6",
            "3, 3, 3, 3, 1, 0"
    })
    void two_pair_scores_sum_of_two_different_pair_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(new TwoPairs()));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 3, 4, 5, 9",
            "5, 3, 5, 4, 5, 15",
            "3, 3, 3, 3, 5, 9",
            "3, 3, 4, 5, 6, 0",
            "3, 3, 3, 3, 1, 9"
    })
    void three_of_a_kind_scores_sum_of_three_identical_dice(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersOfAKindCategory.THREE_OF_A_KIND));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 5, 4, 5, 20",
            "3, 3, 3, 3, 5, 12",
            "2, 2, 2, 2, 5, 8",
            "2, 2, 2, 5, 5, 0",
            "2, 2, 2, 2, 2, 8"
    })
    void four_of_a_kind_scores_sum_of_four_identical_dice_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(NumbersOfAKindCategory.FOUR_OF_A_KIND));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 15",
            "2, 3, 4, 5, 1, 15",
            "1, 2, 2, 4, 5, 0"
    })
    void small_straight_scores_sum_of_one_two_three_four_five_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(StraightCategory.SMALL));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3, 4, 5, 20",
            "2, 3, 4, 5, 6, 20",
            "1, 2, 2, 4, 5, 0"
    })
    void large_straight_scores_sum_of_two_three_four_five_six_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(StraightCategory.LARGE));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 2, 2, 6, 18",
            "2, 3, 4, 5, 6, 0",
            "6, 3, 2, 2, 6, 0",
            "1, 1, 2, 2, 2, 8",
            "2, 2, 3, 3, 4, 0",
            "4, 4, 4, 4, 4, 0"
    })
    void full_house_scores_sum_of_a_pair_and_a_three_of_a_kind_test(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedResult) {
        assertEquals(expectedResult, new Yatzy(dice1, dice2, dice3, dice4, dice5).scores(new FullHouse()));
    }
}
