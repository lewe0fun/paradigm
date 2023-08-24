package adapter;

public class USPlugAdapter implements EuroSocket {
    private final AmericanSocket americanSocket;

    public USPlugAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void supply_electricity() {
        americanSocket.supply_electricity();
    }
}
