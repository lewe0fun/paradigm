package adapter;

public class SimpleEuroSocket implements EuroSocket{
    @Override
    public void supply_electricity() {
        System.out.println("200v");
    }
}
