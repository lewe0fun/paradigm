package Decorator;

public class CoffeeDecorator implements ICoffee{
    ICoffee iCoffee;

    public CoffeeDecorator(ICoffee iCoffee) {
        this.iCoffee = iCoffee;
    }

    @Override
    public int cost() {
        return iCoffee.cost();
    }
}
