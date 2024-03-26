public class Chance implements Category{
    @Override
    public int sum(Roll roll) {
        return roll.sum();
    }
}
