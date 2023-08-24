package Decorator;

public class CoffeeWithMilk extends CoffeeDecorator {
    int MILK_COST = 5;

    public CoffeeWithMilk(ICoffee iCoffee) {
        super(iCoffee);
    }

    public int addCostMilk() {

        System.out.println("+" + MILK_COST + " за молоко");
        return MILK_COST;
    }

    @Override
    public int cost() {
        return super.cost() + addCostMilk();
    }
}
