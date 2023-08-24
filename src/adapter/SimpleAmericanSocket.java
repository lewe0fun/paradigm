package adapter;

public class SimpleAmericanSocket implements AmericanSocket{
    @Override
    public void supply_electricity() {
        System.out.println("110v");
    }
}
