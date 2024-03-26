public class Yatzy implements Category {
    @Override
    public int sum(Roll roll) {
        return roll.allSameDie() ? 50 : 0;
    }
}
