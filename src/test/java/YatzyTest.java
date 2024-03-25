import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(2,3,4,5,1).chance());
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, new Yatzy(4,4,4,4,4).yatzy());
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void ones_scores_sum_of_all_one() {
        assertEquals(1, new Yatzy(1,2,3,4,5).scores(NumbersCategory.ONES));
        assertEquals(2, new Yatzy(1,2,1,4,5).scores(NumbersCategory.ONES));
        assertEquals(0, new Yatzy(6,2,2,4,5).scores(NumbersCategory.ONES));
        assertEquals(4, new Yatzy(1,2,1,1,1).scores(NumbersCategory.ONES));
    }

    @Test
    public void twos_scores_sum_of_all_two() {
        assertEquals(4, new Yatzy(1,2,3,2,6).scores(NumbersCategory.TWOS));
        assertEquals(10, new Yatzy(2,2,2,2,2).scores(NumbersCategory.TWOS));
    }

    @Test
    public void threes_scores_sum_of_all_three() {
        assertEquals(6, new Yatzy(1,2,3,2,3).scores(NumbersCategory.THREES));
        assertEquals(12, new Yatzy(2,3,3,3,3).scores(NumbersCategory.THREES));
    }

    @Test
    public void fours_scores_sum_of_all_four()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).scores(NumbersCategory.FOURS));
        assertEquals(8, new Yatzy(4,4,5,5,5).scores(NumbersCategory.FOURS));
        assertEquals(4, new Yatzy(4,5,5,5,5).scores(NumbersCategory.FOURS));
    }

    @Test
    public void fives_scores_sum_of_all_five() {
        assertEquals(10, new Yatzy(4,4,4,5,5).scores(NumbersCategory.FIVES));
        assertEquals(15, new Yatzy(4,4,5,5,5).scores(NumbersCategory.FIVES));
        assertEquals(20, new Yatzy(4,5,5,5,5).scores(NumbersCategory.FIVES));
    }

    @Test
    public void sixes_scores_sum_of_all_six() {
        assertEquals(0, new Yatzy(4,4,4,5,5).scores(NumbersCategory.SIXES));
        assertEquals(6, new Yatzy(4,4,6,5,5).scores(NumbersCategory.SIXES));
        assertEquals(18, new Yatzy(6,5,6,6,5).scores(NumbersCategory.SIXES));
    }

    @Test
    public void pair_scores_sum_of_two_highest_identical_dice() {
        assertEquals(6, new Yatzy(3,4,3,5,6).scores(NumbersOfAKindCategory.PAIR));
        assertEquals(10, new Yatzy(5,3,3,3,5).scores(NumbersOfAKindCategory.PAIR));
        assertEquals(12, new Yatzy(5,3,6,6,5).scores(NumbersOfAKindCategory.PAIR));
    }

    @Test
    public void two_pair_scores_sum_of_two_different_pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).scores(new TwoPairs()));
        assertEquals(16, new Yatzy(3,3,5,5,5).scores(new TwoPairs()));
        assertEquals(0, new Yatzy(3,5,5,5,5).scores(new TwoPairs()));
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_identical_dice()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).scores(NumbersOfAKindCategory.THREE_OF_A_KIND));
        assertEquals(15, new Yatzy(5,3,5,4,5).scores(NumbersOfAKindCategory.THREE_OF_A_KIND));
        assertEquals(9, new Yatzy(3,3,3,3,5).scores(NumbersOfAKindCategory.THREE_OF_A_KIND));
    }

    @Test
    public void four_of_a_kind_scores_sum_of_four_identical_dice() {
        assertEquals(20, new Yatzy(5,5,5,4,5).scores(NumbersOfAKindCategory.FOUR_OF_A_KIND));
        assertEquals(12, new Yatzy(3,3,3,3,5).scores(NumbersOfAKindCategory.FOUR_OF_A_KIND));
    }

    @Test
    public void small_straight_scores_sum_of_one_two_three_four_five() {
        assertEquals(15, new Yatzy(1,2,3,4,5).scores(StraightCategory.SMALL));
        assertEquals(15, new Yatzy(2,3,4,5,1).scores(StraightCategory.SMALL));
        assertEquals(0, new Yatzy(1,2,2,4,5).scores(StraightCategory.SMALL));
    }

    @Test
    public void large_straight_scores_sum_of_two_three_four_five_six() {
        assertEquals(20, new Yatzy(6,2,3,4,5).scores(StraightCategory.LARGE));
        assertEquals(20, new Yatzy(2,3,4,5,6).scores(StraightCategory.LARGE));
        assertEquals(0, new Yatzy(1,2,2,4,5).scores(StraightCategory.LARGE));
    }

    @Test
    public void full_house_scores_sum_of_a_pair_and_a_three_of_a_kind() {
        assertEquals(18, new Yatzy(6,2,2,2,6).scores(new FullHouse()));
        assertEquals(0, new Yatzy(2,3,4,5,6).scores(new FullHouse()));
        assertEquals(0, new Yatzy(6,3,2,2,6).scores(new FullHouse()));
    }
}
