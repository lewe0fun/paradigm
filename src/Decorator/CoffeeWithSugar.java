package Decorator;

public class CoffeeWithSugar extends CoffeeDecorator{
    int SHUGAR_COST=2;
    public CoffeeWithSugar(ICoffee iCoffee) {
        super(iCoffee);
    }
public int addShugarCost(){
    System.out.println("+" + SHUGAR_COST + " за сахар");
    return SHUGAR_COST;
}
    @Override
    public int cost() {
        return super.cost()+addShugarCost();
    }
}
